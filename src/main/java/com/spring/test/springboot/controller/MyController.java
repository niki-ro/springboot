package com.spring.test.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "Hello, you are inside!");
        return "hello";
    }

    @RequestMapping("/logout")
    public String logout () {
       return "index?logout";
    }

    @RequestMapping(value = "/")
    public String firstIn() {
        return "index";
    }
}
