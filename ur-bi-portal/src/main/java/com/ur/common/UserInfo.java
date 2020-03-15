package com.ur.common;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

@Data
public class UserInfo implements UserDetails {
    private static final long serialVersionUID = -1041327031937199938L;

    private Long id;

    private String name;

    private String username;

    private String password;

    private boolean isAccountNonExpired = true;

    private boolean isAccountNonLocked = true;

    private boolean isCredentialsNonExpired = true;

    private boolean isEnabled = true;

    private Set<AuthorityInfo> authorities = new HashSet<>();

    private String jobnumber;
}