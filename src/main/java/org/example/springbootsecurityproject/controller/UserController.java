package org.example.springbootsecurityproject.controller;


import org.example.springbootsecurityproject.model.Users;
import org.example.springbootsecurityproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Users register(@RequestBody Users user){
        return userService.register(user);

    }
    @PostMapping("/login")
    public String login(@RequestBody Users user){
        System.out.println("Entered the login endpoint");
        String bearerToken = userService.verify(user);

        return bearerToken;
    }
}
