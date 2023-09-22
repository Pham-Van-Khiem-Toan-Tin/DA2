package com.shopecommerce.repository;

import com.shopecommerce.entity.OrderUserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderUserRepository extends MongoRepository<OrderUserEntity, String> {

}
