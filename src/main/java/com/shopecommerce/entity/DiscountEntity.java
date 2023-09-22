package com.shopecommerce.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import static com.shopecommerce.utils.DocumentConstants.*;

@Document
@Getter
@Setter
public class DiscountEntity extends BaseEntity {
    @Id
    @Field(ID)
    private String id;
    @Field(DISCOUNT_NAME)
    private String name;
    @Field(DISCOUNT_STATUS)
    private Boolean status;
    @Field(DISCOUNT_PERCENTAGE)
    private Integer percentage;
}
