package com.movietickets.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public enum UserRole {
    CUSTOMER(List.of("ROLE_CUSTOMER")),
    THEATRE_PARTNER(List.of("ROLE_THEATRE_PARTNER")),
    ADMIN(List.of("ROLE_ADMIN", "ROLE_THEATRE_PARTNER", "ROLE_CUSTOMER"));

    private final List<String> roles;

    UserRole(List<String> roles) {
        this.roles = roles;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
