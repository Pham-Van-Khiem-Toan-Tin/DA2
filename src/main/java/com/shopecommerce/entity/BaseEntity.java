package com.shopecommerce.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

import static com.shopecommerce.utils.constants.DocumentConstants.*;

@Document
@Getter
@Setter
public class BaseEntity {
    @Field(value = CREATE_AT)
    private Date createAt;
    @Field( value = MODIFIED_AT)
    private Date modifiedAt;
}
