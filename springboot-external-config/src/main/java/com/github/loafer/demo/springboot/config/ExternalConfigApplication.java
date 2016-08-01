package com.github.loafer.demo.springboot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaojh.
 */
@SpringBootApplication
public class ExternalConfigApplication {
  private static final Logger logger = LoggerFactory.getLogger(ExternalConfigApplication.class);

  @Autowired
  private ExternalConfigComponent externalConfigComponent;

  public static void main(String[] args){
    SpringApplication app = new SpringApplication(ExternalConfigApplication.class);

    Map<String,Object> defaultProperties = new HashMap<String,Object>();
    defaultProperties.put("property.one","Value One");
    defaultProperties.put("property.two", "Value Two");

    app.setDefaultProperties(defaultProperties);
    app.run(args);
  }
}
