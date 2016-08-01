package com.github.loafer.demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;

/**
 * @author zhaojh.
 */
@SpringBootApplication
public class YamlConfApplication {

  @ConfigurationProperties("foo")
  @Bean
  public FooComponent fooComponent(){
    return new FooComponent();
  }

//  @Bean
//  public Validator localValidatorFactoryBean(){
//    LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
//    factoryBean.setProviderClass(org.hibernate.validator.HibernateValidator.class);
//    return factoryBean;
//  }

  public static void main(String[] args){
    SpringApplication.run(YamlConfApplication.class, args);
  }
}
