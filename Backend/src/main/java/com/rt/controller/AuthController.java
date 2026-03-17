package com.rt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rt.entity.User;
import com.rt.service.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

@Autowired
private UserService userService;

@PostMapping("/register")
public User register(@RequestBody User user) {
    return userService.register(user);
}

@PostMapping("/login")
public User login(@RequestBody User user) {
    return userService.login(user.getEmail(), user.getPassword());
}

}