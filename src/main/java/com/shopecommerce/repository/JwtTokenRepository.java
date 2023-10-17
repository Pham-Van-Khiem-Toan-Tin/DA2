package com.shopecommerce.repository;

import com.shopecommerce.entity.JwtTokenEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JwtTokenRepository extends MongoRepository<JwtTokenEntity, String> {
}
