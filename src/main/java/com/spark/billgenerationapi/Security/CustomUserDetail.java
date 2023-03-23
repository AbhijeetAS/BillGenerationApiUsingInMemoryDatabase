package com.spark.billgenerationapi.Security;

import com.spark.billgenerationapi.dto.Roles;
import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;
import com.spark.billgenerationapi.entity.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomUserDetail implements UserDetails {
    private final String username;
    private final String password;
//    private final Set<SimpleGrantedAuthority> grantedAuthorities;


    public CustomUserDetail(User user) {
        username=user.getUserId();
        password=user.getPassword();
//        grantedAuthorities= user.getRole().getAllAuthorities();
    }






    private User user;

//    public CustomUserDetail(User user) {
//        this.user = user;
//    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
          return getAuthorities();

    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
