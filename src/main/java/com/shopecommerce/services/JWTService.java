package com.shopecommerce.services;

import com.shopecommerce.entity.UserEntity;

public interface JWTService {
    String generateTokenAfterLoginSuccess();
    boolean validateToken(String token);
    UserEntity generateUserFromToken(String token);
}
