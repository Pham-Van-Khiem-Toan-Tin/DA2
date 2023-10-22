package com.shopecommerce.services;

import com.shopecommerce.entity.UserEntity;

public interface JWTService {
    String generateTokenAfterLoginSuccess();
    boolean validateAccessToken(String token);
    boolean validateRefreshToken(String refreshToken);
    String generateAccessToken(UserEntity user);
    UserEntity generateUserFromToken(String token);
}
