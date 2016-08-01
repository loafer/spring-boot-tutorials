package com.github.loafer.demo.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhaojh.
 */
@SpringBootApplication
public class Log4jApplication {
  private static final Logger logger = LoggerFactory.getLogger(Log4jApplication.class);

  public static void main(String[] args) throws InterruptedException {
    SpringApplication.run(Log4jApplication.class, args);

//    for (int i=0; i<20; i++){
//      logger.info("{}", i);
//
//      Thread.sleep(2000);
//    }
  }
}
