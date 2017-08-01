package com.github.loafer.demo.datasource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaojh.
 */
@Component
public class DatasourceProxyBeanProcessor implements BeanPostProcessor, EnvironmentAware {
    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String name) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String name) throws BeansException {
        if(bean instanceof DataSource){
            DataSource dataSourceBean = (DataSource) bean;
            AbstractRoutingDataSource routingDataSource = new RoutingDataSource();
            routingDataSource.setDefaultTargetDataSource(dataSourceBean);
            ((RoutingDataSource)routingDataSource).setEnvironment(this.environment);

            Map<Object, Object> targetDataSources = new HashMap<>();
            targetDataSources.put("master", dataSourceBean);
            routingDataSource.setTargetDataSources(targetDataSources);
            routingDataSource.afterPropertiesSet();
            return routingDataSource;
        }
        return bean;
    }
}
