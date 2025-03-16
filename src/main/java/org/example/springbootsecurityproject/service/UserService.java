package org.example.springbootsecurityproject.service;


import org.example.springbootsecurityproject.model.Users;
import org.example.springbootsecurityproject.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.beans.JavaBean;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private JWTService jwtService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    @Autowired
    private AuthenticationManager authenticationManager;

    public Users register(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public String verify(Users user) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if(authentication.isAuthenticated()) return jwtService.generateToken(user.getUsername());
        return "Failed";
    }
}
