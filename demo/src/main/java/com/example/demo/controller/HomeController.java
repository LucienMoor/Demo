package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }
    
    @GetMapping("/add")
    @ResponseBody
    public String add() {
    	
        return Integer.toString(addi());
    }
    
    public int addi() {
    	return 2+2;
    }
}
