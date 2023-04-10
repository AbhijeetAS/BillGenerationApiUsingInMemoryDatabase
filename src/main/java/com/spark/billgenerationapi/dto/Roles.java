package com.spark.billgenerationapi.dto;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public enum Roles {

    CUSTOMER(Set.of(Authority.READ_ORDER)),
    POS(Set.of(Authority.WRITE_ORDER, Authority.READ_ORDER)),
    MANAGER(Set.of(Authority.GET_EARN, Authority.WRITE_ORDER)),
    ADMIN(Set.of(Authority.GET_EARN, Authority.WRITE_ORDER));

    private final Set<Authority> authorities;

    Roles(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthority()
    {
        Set<SimpleGrantedAuthority> permissions=getAuthorities().stream().map(permission->new SimpleGrantedAuthority(permission.getPermission())).collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return permissions;
    }


}