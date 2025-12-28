package com.example.demo.security;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import org.springframework.security.core.userdetails.*;
import java.util.Collections;

public class CustomUserDetailsService implements UserDetailsService {

    private final UserAccountRepository userRepository;

    public CustomUserDetailsService(UserAccountRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        UserAccount user = userAccountRepository
        .findByEmail(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));


        return new User(
                user.getEmail(),
                user.getPassword(),
                Collections.emptyList()
        );
    }
}
