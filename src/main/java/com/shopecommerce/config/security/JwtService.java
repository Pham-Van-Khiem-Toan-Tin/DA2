package com.shopecommerce.config.security;

import com.shopecommerce.entity.UserEntity;
import com.shopecommerce.repository.UserRepository;
import com.shopecommerce.utils.JwtUtils;
import com.shopecommerce.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;

@Service
public class JwtService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private JwtUtils jwtUtils;

    @Value("${token.app.rfSecret}")
    private String rfSecret;
    @Value("${token.app.rfEx}")
    private long rfEx;
    @Value("${token.app.acSecret}")
    private String acSecret;
    @Value("${token.app.acEx}")
    private long acEx;
    public String generateTokenAfterLoginSuccess() {
        UserEntity user = WebUtils.getUserDetail().getUser();
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(user.getId()));
        String refreshToken = jwtUtils.generateJwtToken(rfSecret, rfEx ,user);
        String accessToken = jwtUtils.generateJwtToken(acSecret, acEx, user);
        Update update = new Update();
        update.set("refresh_token", refreshToken);
        update.set("access_token_list", new ArrayList<String>(Collections.singleton(accessToken)));
        mongoTemplate.updateFirst(query, update, UserEntity.class);
        return accessToken;
    }
    public boolean validateToken(String token) {
        return jwtUtils.validateJwtToken(acSecret,token);
    }
    public UserEntity generateUserFromToken(String token) {
        return jwtUtils.getUserNameFromToken(acSecret, token);
    }
}
