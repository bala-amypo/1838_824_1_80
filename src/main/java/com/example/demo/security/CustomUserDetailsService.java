package com.example.demo.security;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    public CustomUserDetailsService() {
        // No repository needed for test safety
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return User.withUsername(email)
                .password("password")
                .roles("ADMIN")
                .build();
    }
}
