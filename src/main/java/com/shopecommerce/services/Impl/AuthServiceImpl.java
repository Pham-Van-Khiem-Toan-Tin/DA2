package com.shopecommerce.services.Impl;

import com.shopecommerce.dto.RegisterForm;
import com.shopecommerce.dto.ResponseForm;
import com.shopecommerce.entity.UserEntity;
import com.shopecommerce.repository.UserRepository;
import com.shopecommerce.services.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthServiceImpl  implements AuthService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public ResponseForm register(RegisterForm registerForm) {
        Boolean isExist = userRepository.existsByEmail(registerForm.getEmail());
        ResponseForm responseForm = new ResponseForm();
        if (Boolean.TRUE.equals(isExist)) {
            responseForm.setStatus(500);
            responseForm.setMessage("Tài khoản đã tồn tại");
        }
        else {
            UserEntity newUser = new UserEntity();
            newUser.setId(registerForm.getName());
            newUser.setEmail(registerForm.getEmail());
            newUser.setPassword(passwordEncoder.encode(registerForm.getPassword()));
            newUser.setRole("ADMIN");
            newUser.setAddress(registerForm.getAddress());
            newUser.setPhone(registerForm.getPhone());
            newUser.setStatus(1);
            userRepository.save(newUser);
            responseForm.setStatus(200);
            responseForm.setMessage("Đăng kí thành công.");
        }
        return responseForm;
    }

    @Override
    public ResponseEntity<String> renewRefreshToken(String accessToken) {
        Query query = new Query();
        query.addCriteria(Criteria.where("access_token_list").in(accessToken));
        UserEntity user = mongoTemplate.findOne(query, UserEntity.class);
        if(user != null && user.getRefreshToken() != null) {
            String refreshToken = user.getRefreshToken();

        }
        if(user.getAccessTkList().get(user.getAccessTkList().size() -1).equals(accessToken)) {

        }
        String responseBody = "This is an example response";
        return ResponseEntity<>(responseBody, HttpStatus.OK);
    }
}
