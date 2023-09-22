package com.shopecommerce.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

import static com.shopecommerce.utils.DocumentConstants.*;

@Document(collection = PRODUCT_COLLECTION)
@Getter
@Setter
public class ProductEntity extends BaseEntity {
    @Id
    @Field(ID)
    private String id;
    @Field(PRODUCT_NAME)
    private String name;
    @Field(PRODUCT_PRICE)
    private Float price;
    @Field(PRODUCT_STOCK)
    private Integer stock;
    @Field(PRODUCT_CATEGORY)
    private String category;
    @Field(PRODUCT_DESCRIPTION)
    private String description;
    @Field(PRODUCT_DISCOUNT)
    private List<DiscountEntity> discounts;
}
