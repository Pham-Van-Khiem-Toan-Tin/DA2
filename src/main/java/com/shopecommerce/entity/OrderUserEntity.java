package com.shopecommerce.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

import static com.shopecommerce.utils.DocumentConstants.*;

@Document(collection = ORDER_COLLECTION)
@Getter
@Setter
public class OrderUserEntity extends BaseEntity {
    @Id
    @Field(ID)
    private String id;
    @Field(USER_ID)
    private String userId;
    @Field(ORDER_ITEMS)
    private List<ProductOfOrderEntity> items;
    @Field(ORDER_TOTAL)
    private Float total;
    @Field(ORDER_TAX)
    private Float tax;
    @Field(PAYMENT_TYPE)
    private String paymentTypes;
    @Field(ORDER_STATUS)
    private String status;
}
