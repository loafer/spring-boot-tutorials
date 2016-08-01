package com.github.loafer.demo.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class WebApplication implements CommandLineRunner{
  private static final Logger logger = LoggerFactory.getLogger(WebApplication.class);

  //注入此bean可以获得应用启动时传入的参数
  @Autowired
  private ApplicationArguments arguments;

  @Override
  public void run(String... strings) throws Exception {
    //pring arguments
    logger.info("{}", arguments.getOptionNames());
  }

  public static void main(String[] args) {
    logger.info("=====befor=====");
    SpringApplication.run(WebApplication.class, args);
    logger.info("=====after=====");
  }
}
