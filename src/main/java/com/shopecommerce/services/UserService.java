package com.shopecommerce.services;

import com.shopecommerce.dto.RegisterForm;
import com.shopecommerce.dto.ResponseForm;

public interface UserService {
    ResponseForm register(RegisterForm registerForm);
}
