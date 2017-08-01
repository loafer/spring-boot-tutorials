package com.github.loafer.demo.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


public class RoutingDataSource extends AbstractRoutingDataSource{
  private static final Logger logger = LoggerFactory.getLogger(RoutingDataSource.class);
  private static final String DATASOURCE_PROPERTY_PREFIX = "spring.datasource.";

  private Environment environment;
  private Map<Object, Object> targetDataSources;

  @Override
  protected Object determineCurrentLookupKey() {
    String dataSourceName = DataSourceContext.getDatasourceName();
    logger.info("datasource [{}].", StringUtils.hasText(dataSourceName)? dataSourceName : "master");
    return dataSourceName;
  }

  @Override
  public void setTargetDataSources(Map<Object, Object> targetDataSources) {
    this.targetDataSources = new HashMap<>(targetDataSources);
  }

  @Override
  public void afterPropertiesSet() {
    buildTargetDataSources();
    super.setTargetDataSources(targetDataSources);
    super.afterPropertiesSet();
  }


  public void setEnvironment(Environment environment) {
    this.environment = environment;
  }

  private void buildTargetDataSources(){
    RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(this.environment, DATASOURCE_PROPERTY_PREFIX);
    String targetDatasourceNames = propertyResolver.getProperty("names");
    logger.info("target datasource names: {}", targetDatasourceNames);

    if(!StringUtils.hasText(targetDatasourceNames)){
      return;
    }


    for (String name : targetDatasourceNames.split(",")){
      Map<String, Object> subProperties = propertyResolver.getSubProperties(name + '.');
      logger.info("sub properties: {}", subProperties);
      targetDataSources.put(name, buildDatasource(subProperties));
    }
  }

  private DataSource buildDatasource(Map<String, Object> properties){
    if(properties.containsKey("jndi-name")){
      return buildJndiDatasource(properties.get("jndi-name").toString());
    }else{
      return buildJdbcDatasource(properties);
    }
  }

  private DataSource buildJdbcDatasource(Map<String, Object> properties){
    DataSourceBuilder factory = DataSourceBuilder.create()
            .url(properties.get("url").toString())
            .username(properties.get("username").toString())
            .password(properties.get("password").toString());

    return factory.build();
  }

  private DataSource buildJndiDatasource(String datasourceName){
    JndiDataSourceLookup jndiDataSourceLookup = new JndiDataSourceLookup();
    return jndiDataSourceLookup.getDataSource(datasourceName);
  }
}
