package com.shopecommerce.services;

import com.shopecommerce.dto.RegisterForm;
import com.shopecommerce.dto.ResponseForm;

public interface AuthService {
    ResponseForm register(RegisterForm registerForm);
    String renewRefreshToken(String accessToken);
}
