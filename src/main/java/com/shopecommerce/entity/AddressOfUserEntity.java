package com.shopecommerce.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import static com.shopecommerce.utils.DocumentConstants.*;

@Document
@Getter
@Setter
public class AddressOfUserEntity {
    @Field(CITY)
    private String city;
    @Field(COUNTRY)
    private String country;
    @Field(POSTAL_CODE)
    private String postalCode;
    @Field(COUNTRY_DETAIL)
    private String countryDetail;
    @Field(MOBILE)
    private String mobile;
}
