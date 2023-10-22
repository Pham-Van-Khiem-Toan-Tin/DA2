package com.shopecommerce.services;

import com.shopecommerce.dto.RegisterForm;
import com.shopecommerce.dto.ResponseForm;
import com.shopecommerce.entity.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface AuthService {
    ResponseForm register(RegisterForm registerForm);
    ResponseEntity<String> renewRefreshToken(String accessToken);
}
