package com.shopecommerce.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

import static com.shopecommerce.utils.DocumentConstants.*;

@Document(collection = USER_COLLECTION)
@Getter
@Setter
public class UserEntity extends BaseEntity {
    @Id
    @Field(ID)
    private String id;

    @Field(USER_NAME)
    private String name;

    @Field(USER_EMAIL)
    private String email;

    @Field(USER_PASSWORD)
    private String password;

    @Field(USER_PHONE)
    private String phone;

    @Field(USER_ROLE)
    private String role;

    @Field(USER_ADDRESS)
    private List<AddressOfUserEntity> address;

    @Field(CART)
    private List<CartEntity> cart;

    @Field(LOGIN_FAIL)
    private Integer count;

    @Field(USER_BANNED)
    private Boolean banned;
}
