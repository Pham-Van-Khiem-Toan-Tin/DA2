package com.shopecommerce.controller;

import com.shopecommerce.dto.RegisterForm;
import com.shopecommerce.dto.ResponseForm;
import com.shopecommerce.entity.UserEntity;
import com.shopecommerce.services.AuthService;
import com.shopecommerce.services.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    public ResponseEntity<String> refreshToken(@RequestBody Map<String, String> accessTokenmap) {
        return authService.renewRefreshToken(accessTokenmap.get("accessToken"));
    }
}
