package com.shopecommerce.config.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.shopecommerce.dto.SubFunctionDTO;
import com.shopecommerce.entity.RoleFunctionsEntity;
import com.shopecommerce.exception.UsernameNotActiveException;
import com.shopecommerce.repository.RoleFunctionsRepository;
import com.shopecommerce.utils.constants.BEConstants;
import com.shopecommerce.utils.constants.EActiveStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shopecommerce.entity.RoleEntity;
import com.shopecommerce.entity.UserEntity;
import com.shopecommerce.repository.RoleRepository;
import com.shopecommerce.repository.UserRepository;

@Service
@Slf4j
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    RoleFunctionsRepository roleFunctionsRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException, UsernameNotActiveException {
        log.debug("Find user by email: {}", email);
        UserEntity user = userRepository.findByEmail(email).orElse(null);
        if (user == null) {
            log.error("{} not found", email);
            throw new UsernameNotFoundException(BEConstants.NOT_EXIST);
        }
        String roleId = user.getRole();
        if (EActiveStatus.INACTIVE.getValue().equals(user.getStatus())) {
            log.error("{} is not active", email);
            throw new UsernameNotActiveException(BEConstants.LOCK_USER);
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        List<String> authorities = new ArrayList<>();
        List<String> functions = new ArrayList<>();
        List<SubFunctionDTO> subFunctions = new ArrayList<>();
        if (roleId != null) {

            if (BEConstants.ROLE_SUPER.equals(roleId)) {
                List<RoleFunctionsEntity> list = roleFunctionsRepository.findAll();
                for (RoleFunctionsEntity function : list) {
                    if (!functions.contains(function.getId())) {
                        functions.add(function.getId());
                    }
                    for (SubFunctionDTO sub : function.getSubFunctions()) {
                        if (!functions.contains(sub.getId())) {
                            functions.add(sub.getId());
                        }
                        if (sub.getAuthorities() != null) {
                            sub.getAuthorities().forEach(authority -> functions.add(authority.getId()));
                        }
                        /* Add sub function */
                        if (!subFunctions.contains(sub)) {
                            subFunctions.add(sub);
                        }
                    }
                }
            } else {
                RoleEntity role = roleRepository.findRoleEntityByIdAndStatus(roleId, EActiveStatus.ACTIVE.getValue())
                        .orElse(null);
                if (role != null) {

                    for (String func : role.getFunctions()) {
                        RoleFunctionsEntity function = roleFunctionsRepository.getRoleFunctionsEntityByCode(func);
                        if (function != null) {

                            if (!functions.contains(function.getId())) {
                                functions.add(function.getId());
                            }

                            for (SubFunctionDTO sub : function.getSubFunctions()) {
                                sub.getAuthorities().forEach(authority -> {
                                    if (func.equals(authority.getId())) {
                                        functions.add(authority.getId());
                                        if (!functions.contains(sub.getId())) {
                                            functions.add(sub.getId());
                                        }
                                        /* Add sub func */
                                        if (!subFunctions.contains(sub)) {
                                            subFunctions.add(sub);
                                        }
                                    }
                                });
                            }
                        }
                    }
                }
            }
            authorities = functions;

            if (!authorities.isEmpty()) {

                authorities.forEach(authority -> grantedAuthorities.add(new SimpleGrantedAuthority(authority)));
            }
        }
        return new CustomUserDetail(user, grantedAuthorities, subFunctions);
    }
}
