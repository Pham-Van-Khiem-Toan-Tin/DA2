package com.shopecommerce.repository;

import com.shopecommerce.entity.RoleEntity;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface RoleRepository extends MongoRepository<RoleEntity, String> {
    Optional<RoleEntity> findById(String id);
    Optional<RoleEntity> findRoleEntityByIdAndStatus(String id, Integer status);
}
