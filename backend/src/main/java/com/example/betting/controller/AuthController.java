package com.example.betting.controller;

import com.example.betting.model.User;
import com.example.betting.repository.UserRepository;
import com.example.betting.security.JwtUtil;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public AuthController(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
public String login(@RequestBody User user) {
    System.out.println("Login attempt for username: " + user.getUsername());
    
    User existingUser = userRepository.findByUsername(user.getUsername())
            .orElseThrow(() -> new RuntimeException("User not found"));

    if (existingUser.getPassword().equals(user.getPassword())) {
        String token = jwtUtil.generateToken(existingUser.getUsername());
        System.out.println("Token generated: " + token);
        return token;
    }

    throw new RuntimeException("Invalid credentials");
}

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("User already exists");
        }
        userRepository.save(user);
        return jwtUtil.generateToken(user.getUsername());
    }

}
