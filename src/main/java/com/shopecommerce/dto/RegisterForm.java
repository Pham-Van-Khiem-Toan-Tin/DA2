package com.shopecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterForm {
    private String name;
    private String email;
    private String phone;
    private String address;
    private String password;
    private Integer status;
}
