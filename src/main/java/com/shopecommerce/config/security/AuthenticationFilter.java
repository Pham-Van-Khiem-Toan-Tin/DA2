package com.shopecommerce.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopecommerce.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import com.google.gson.Gson;
import com.shopecommerce.dto.ResponseForm;
import com.shopecommerce.utils.JwtUtils;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private CustomUserDetailService customUserDetailService;
    @Autowired
    private JwtService jwtService;

    private static final Gson gson = new Gson();

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            String requestURI = request.getRequestURI();
            if (!requestURI.contains("/login") || requestURI.contains("/register")) {
                String accessToken = parseAccessToken(request);
                if (accessToken != null) {
                    boolean validateAccessToken = jwtService.validateToken(accessToken);
                    if (validateAccessToken) {

                    } else {
                        RestTemplate restTemplate = new RestTemplate();
                        HttpHeaders httpHeaders = new HttpHeaders();
                        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                        HttpEntity<String> requestRf = new HttpEntity<>(accessToken, httpHeaders);

                    }
                    UserEntity user = jwtService.generateUserFromToken(accessToken);
                    UserDetails userDetail = customUserDetailService.loadUserByUsername(user.getEmail());
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                            userDetail, null, userDetail.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        } catch (Exception e) {
            logger.error("Cannot validate Token", e);
            response.setStatus(403);
            ResponseForm responseForm = new ResponseForm();
            responseForm.setStatus(403);
            response.setContentType("application/json");
            responseForm.setMessage("Bạn không có quyền truy cập");
            response.getWriter().write(gson.toJson(responseForm));
            return;
        }
        filterChain.doFilter(request, response);
    }

    private String parseAccessToken(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");
        if (StringUtils.hasText(headerAuth)) {
            return headerAuth.split(" ")[1];
        }
        return null;
    }
}
