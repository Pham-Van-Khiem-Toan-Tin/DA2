package com.shopecommerce.services.Impl;


import com.shopecommerce.dto.RegisterForm;
import com.shopecommerce.dto.ResponseForm;
import com.shopecommerce.entity.UserEntity;
import com.shopecommerce.repository.UserRepository;
import com.shopecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
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
}
