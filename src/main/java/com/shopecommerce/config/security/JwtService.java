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
import org.springframework.stereotype.Service;

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
    private int rfEx;
    @Value("${token.app.acSecret}")
    private String acSecret;
    @Value("${token.app.acEx}")
    private int acEx;
    public String generateTokenAfterLoginSuccess() {
        UserEntity user = WebUtils.getUserDetail().getUser();
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(user.getId()));
        String refreshToken = jwtUtils.generateJwtToken(rfSecret, rfEx ,user);
        String accessToken = jwtUtils.generateJwtToken(acSecret, acEx, user);
        return accessToken;
    }
}
