package com.shopecommerce.utils;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import com.google.gson.Gson;
import com.shopecommerce.config.security.CustomUserDetail;
import com.shopecommerce.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
    private static final Gson gson = new Gson();


    public String generateJwtToken(String secret,int exprise, UserEntity user) {
        return Jwts.builder().setSubject(gson.toJson(user)).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + exprise)).signWith(generateSecretKey(secret))
                .compact();
    }
    public SecretKey generateSecretKey(String secret) {
        byte[] keyBytes = secret.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

//    public String generateTokenFromUsername(String username) {
//        return Jwts.builder().setSubject(username).setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + jwtEx)).signWith(generateSecretKey())
//                .compact();
//    }
//
//    public String getUserNameFromToken(String token) {
//        return Jwts.parser().setSigningKey(generateSecretKey()).build().parseClaimsJws(token).getBody().getSubject();
//    }

//    public boolean validateJwtToken(String authToken) {
//        try {
//            Jwts.parser().setSigningKey(generateSecretKey()).build().parseClaimsJws(authToken);
//            return true;
//        } catch (MalformedJwtException e) {
//            logger.error("Invalid JWT token: {}", e.getMessage());
//        } catch (ExpiredJwtException e) {
//            logger.error("JWT token is expired: {}", e.getMessage());
//        } catch (UnsupportedJwtException e) {
//            logger.error("JWT token is unsupported: {}", e.getMessage());
//        } catch (IllegalArgumentException e) {
//            logger.error("JWT claims string is empty: {}", e.getMessage());
//        }
//
//        return false;
//    }
}
