package com.shopecommerce.config.security;

import com.shopecommerce.dto.SubFunctionDTO;
import com.shopecommerce.entity.UserEntity;
import com.shopecommerce.utils.constants.EActiveStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class CustomUserDetail implements UserDetails {
    @Getter
    @Setter
    private UserEntity user;
    private final List<GrantedAuthority> authorities;

    @Getter
    @Setter
    private List<SubFunctionDTO> subFunctions;

    public CustomUserDetail(UserEntity user, List<GrantedAuthority> authorities) {
        this.user = user;
        this.authorities = authorities;
    }

    public CustomUserDetail(UserEntity user, List<GrantedAuthority> authorities, List<SubFunctionDTO> subFunctions) {
        this.user = user;
        this.authorities = authorities;
        this.subFunctions = subFunctions;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return Objects.equals(this.user.getStatus(), EActiveStatus.ACTIVE.getValue());
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return Objects.equals(this.user.getStatus(), EActiveStatus.ACTIVE.getValue());
    }
}
