package com.shopecommerce.repository;

import com.shopecommerce.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {
    UserEntity findByEmail(String email);
    boolean existsByEmail(String email);
}
