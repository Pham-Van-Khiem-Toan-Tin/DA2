package com.shopecommerce.repository;

import com.shopecommerce.entity.RoleFunctionsEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleFunctionsRepository extends MongoRepository<RoleFunctionsEntity, String> {
    @Query("{'sub_functions.authorities._id' :  ?0}")
    RoleFunctionsEntity getRoleFunctionsEntityByCode(String code);
}
