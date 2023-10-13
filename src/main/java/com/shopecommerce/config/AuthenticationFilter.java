package com.shopecommerce.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.google.gson.Gson;
import com.shopecommerce.dto.ResponseForm;
import com.shopecommerce.services.Impl.CustomUserDetailService;
import com.shopecommerce.utils.JwtUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private CustomUserDetailService customUserDetailService;
    @Autowired
    private JwtUtils jwtUtils;

    private static final Gson gson = new Gson();

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            String accessToken = parseAccessToken(request);
            if (accessToken != null && jwtUtils.validateJwtToken(accessToken)) {
                String email = jwtUtils.getUserNameFromToken(accessToken);
                UserDetails userDetails = customUserDetailService.loadUserByUsername(email);
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
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
