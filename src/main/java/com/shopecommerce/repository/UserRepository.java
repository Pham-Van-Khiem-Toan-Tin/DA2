package com.shopecommerce.repository;

import com.shopecommerce.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {
    @Query(value = "{'email':  ?0}", fields = "{'access_token_list':  0, 'refresh_token':  0}")
    Optional<UserEntity> findByEmail(String email);
    boolean existsByEmail(String email);
}
