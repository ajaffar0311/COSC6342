package com.isms.isms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restController {

    // expose "/" endpoint that returns "Hello World"
    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }
}
