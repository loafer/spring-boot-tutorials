package com.github.loafer.demo.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author zhaojh.
 */
@Component
public class ConfigComponent {
  private static final Logger logger = LoggerFactory.getLogger(ConfigComponent.class);

  @Value("${property.one}")
  private String propertyOne;

  @Value("${property.two}")
  private String propertyTwo;

  @Value("${property.three}")
  private String propertyThree;

  @Value("${property.four}")
  private String propertyFour;

  @PostConstruct
  public void PostConstruct(){
    logger.info("Property One: {}", propertyOne);
    logger.info("Property Two: {}", propertyTwo);
    logger.info("Property Three: {}", propertyThree);
    logger.info("Property Four: {}", propertyFour);
  }
}
