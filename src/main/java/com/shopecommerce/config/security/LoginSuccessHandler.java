package com.shopecommerce.config.security;

import com.google.gson.Gson;
import com.shopecommerce.dto.ResponseForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private static final Gson gson = new Gson();
    @Autowired
    private JwtService jwtService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        response.setContentType("application/json");
        String accessToken = jwtService.generateTokenAfterLoginSuccess();
        ResponseForm responseForm = new ResponseForm();
        responseForm.setStatus(200);
        responseForm.setMessage("Đăng nhập thành công");
        responseForm.setAccessToken("Bearer " + accessToken);
        response.setCharacterEncoding("UTF-8");
        response.setStatus(200);
        response.getWriter().write(gson.toJson(responseForm));
    }

}
