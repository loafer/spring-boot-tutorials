package com.github.loafer.demo.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ConfigComponent{
  private static final Logger logger = LoggerFactory.getLogger(ConfigComponent.class);

  @Value("${property.one}")
  private String propertyOne;

  @Autowired
  private ConnectionSettings connectionSettings;

  @Autowired
  private FooComponent fooComponent;

  @PostConstruct
  public void postConstruct(){
    logger.info("Property One: {}", propertyOne);
    logger.info("Connection Settings: {}", connectionSettings);
    logger.info("fooComponent: {}", fooComponent);
  }
}
