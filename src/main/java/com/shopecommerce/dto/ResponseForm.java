package com.shopecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseForm {
    private Integer status;
    private String message;
    private String accessToken;
}
