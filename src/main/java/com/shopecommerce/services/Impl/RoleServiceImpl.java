package com.shopecommerce.services.Impl;

import com.shopecommerce.entity.RoleEntity;
import com.shopecommerce.repository.RoleRepository;
import com.shopecommerce.services.RoleService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void addRole() {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId("USER");
        roleEntity.setName("USER");
        roleEntity.setPriority(2);
        roleEntity.setStatus(1);
        List<String> functions = new ArrayList<>();
        functions.add("TEST");
        roleEntity.setFunctions(functions);
        roleRepository.save(roleEntity);
    }
}
