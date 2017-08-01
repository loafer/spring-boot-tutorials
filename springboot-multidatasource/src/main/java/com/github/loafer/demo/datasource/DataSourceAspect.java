package com.github.loafer.demo.datasource;

import com.github.loafer.demo.datasource.annotation.TargetDataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by zhaojh.
 */
@Component
@Aspect
public class DataSourceAspect {

  @Around("@annotation(targetDataSource)")
  public Object changeDatasource(ProceedingJoinPoint pjp, TargetDataSource targetDataSource) throws Throwable {

    try {
      DataSourceContext.setDatasourceName(targetDataSource.value());
      Object rtnValue = pjp.proceed();
      DataSourceContext.clean();
      return rtnValue;
    } catch (Throwable throwable) {
      DataSourceContext.clean();
      throw throwable;
    }
  }
}
