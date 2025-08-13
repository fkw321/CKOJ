package com.ming.ckoj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("Hello world");
        return "Hello world";
    }
}
