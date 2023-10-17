package com.shopecommerce.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

import static com.shopecommerce.utils.constants.DocumentConstants.*;

@Document(collection = ROLE_COLLECTION)
@Getter
@Setter
public class RoleEntity {
    @Id
    @Field(ID)
    private String id;

    @Field(ROLE_NAME)
    private String name;

    @Field(ROLE_STATUS)
    private Integer status;

    @Field(ROLE_PRIORITY)
    private Integer priority;

    @Field(ROLE_FUNCTIONS)
    private List<String> functions;
}
