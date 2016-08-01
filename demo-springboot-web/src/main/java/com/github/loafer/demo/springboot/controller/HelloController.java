package com.github.loafer.demo.springboot.controller;

import com.github.loafer.demo.springboot.web.ResponseData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaojh.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
  private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

  @RequestMapping(method = RequestMethod.GET)
  public ResponseData sayHello(){
    return new ResponseData().success("Hello Spring Boot!");
  }
}
