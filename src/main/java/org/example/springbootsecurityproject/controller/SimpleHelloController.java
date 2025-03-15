package org.example.springbootsecurityproject.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleHelloController {
    @GetMapping("/")
    public String greet(HttpServletRequest request){
        return "Welcome to anupam" + request.getSession().getId();
    }

}
