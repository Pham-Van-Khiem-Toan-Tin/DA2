package com.shopecommerce.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

import static com.shopecommerce.utils.constants.DocumentConstants.*;

@Document
@Getter
@Setter
public class JwtTokenEntity {
    @Id
    @Field(ID)
    private String id;

}
