package com.github.loafer.demo.springboot.hello.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhaojh.
 */
@Controller
@RequestMapping("hello")
public class HelloController {

    @RequestMapping("greeting")
    @ResponseBody
    public String greeting(@RequestParam(value = "name", defaultValue = "Spring Boot") String name){
        return "Hello, " + name + '!';
    }
}
