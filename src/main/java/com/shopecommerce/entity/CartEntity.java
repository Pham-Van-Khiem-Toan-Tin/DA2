package com.shopecommerce.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import static com.shopecommerce.utils.DocumentConstants.*;

@Document
@Getter
@Setter
public class CartEntity {
    @Field(PRODUCT_ID)
    private String productId;
    @Field(QUANTITY)
    private Integer quantity;
}
