package com.shopecommerce.utils;

import java.util.Objects;

import com.shopecommerce.config.security.CustomUserDetail;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.shopecommerce.entity.UserEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WebUtils {
    private WebUtils() {

    }
    public static CustomUserDetail getUserDetail() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }
        if (auth instanceof AnonymousAuthenticationToken) {
            log.info("user is anonymousAuthentication");
        }
        if (auth.getPrincipal() instanceof CustomUserDetail) {
            return (CustomUserDetail) auth.getPrincipal();
        } else {
            return (CustomUserDetail) auth.getDetails();
        }
    }
}
