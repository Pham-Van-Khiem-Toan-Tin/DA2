package com.shopecommerce.dto;

import lombok.Data;

import java.util.List;
@Data
public class SubFunctionDTO {
    private String id;
    private String description;
    private List<AuthorityDTO> authorities;
    private String href;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubFunctionDTO that = (SubFunctionDTO) o;

        return id.equals(that.id);
    }
}
