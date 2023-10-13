package com.shopecommerce.services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email);
        Optional<RoleEntity> roleOfUser = roleRepository.findById(user.getRole());
        List<String> authoritiesString = roleOfUser.isPresent() ? roleOfUser.get().getFunctions() : new ArrayList<>();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authoritiesString.forEach(role -> authorities.add(new SimpleGrantedAuthority(role)));
        return new User(user.getEmail(), user.getPassword(), authorities);
    }
}
