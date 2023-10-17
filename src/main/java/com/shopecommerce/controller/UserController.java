package com.shopecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopecommerce.dto.RegisterForm;
import com.shopecommerce.dto.ResponseForm;
import com.shopecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseForm signUp(@RequestBody RegisterForm registerForm) {
        return userService.register(registerForm);
    }
}
