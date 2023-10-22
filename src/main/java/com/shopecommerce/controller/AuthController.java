package com.shopecommerce.controller;

import com.shopecommerce.dto.RegisterForm;
import com.shopecommerce.dto.ResponseForm;
import com.shopecommerce.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseForm signUp(@RequestBody RegisterForm registerForm) {
        return authService.register(registerForm);
    }

    @PostMapping("/refresh")
    public ResponseEntity<String> refreshToken(String accessToken) {
         return authService.renewRefreshToken(accessToken);
    }
}
