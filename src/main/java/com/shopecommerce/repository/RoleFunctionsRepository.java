package com.shopecommerce.repository;

import com.shopecommerce.entity.RoleFunctionsEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleFunctionsRepository extends MongoRepository<RoleFunctionsEntity, String> {

}
