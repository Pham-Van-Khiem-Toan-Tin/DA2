package com.shopecommerce.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Set;

import static com.shopecommerce.utils.DocumentConstants.*;

@Document(collection = FUNCTIONS_COLLECTION )
@Setter
@Getter
public class RoleFunctionsEntity {
    @Id
    @Field(ID)
    private String id;
    @Field(FUNCTION_DESCRIPTION)
    private String description;
    @Field(SUB_FUNCTIONS)
    private Set<String> subFunctions;

}
