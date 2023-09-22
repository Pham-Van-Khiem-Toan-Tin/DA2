package com.shopecommerce.repository;

import com.shopecommerce.entity.OrdersAdminEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersAdminRepository extends MongoRepository<OrdersAdminEntity, String> {

}
