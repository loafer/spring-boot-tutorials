package com.github.loafer.demo.datasource;

/**
 * Created by zhaojh.
 */
public class DataSourceContext {
  private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

  public static void setDatasourceName(String datasourceName){
    contextHolder.set(datasourceName);
  }

  public static String getDatasourceName(){
    return contextHolder.get();
  }

  public static void clean(){
    contextHolder.remove();
  }
}
