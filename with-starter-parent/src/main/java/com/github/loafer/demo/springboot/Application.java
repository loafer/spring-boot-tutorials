package com.github.loafer.demo.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhaojh.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application implements CommandLineRunner{
    private final Logger logger = LoggerFactory.getLogger(Application.class);

    @Override
    public void run(String... strings) throws Exception {
        logger.info("服务已启动.");
    }

    public static void main(String[] args){
        SpringApplication.run(Application.class);
    }
}
