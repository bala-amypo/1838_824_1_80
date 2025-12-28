package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.exception.*;
import com.example.demo.repository.UserAccountRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAccountServiceImpl {

    private final UserAccountRepository repo;
    private final PasswordEncoder encoder;

    public UserAccountServiceImpl(UserAccountRepository r,PasswordEncoder e){
        this.repo=r; this.encoder=e;
    }

    public UserAccount register(UserAccount u){
        if(repo.existsByEmail(u.getEmail()))
            throw new ValidationException("Email already in use");

        if(u.getPassword().length() < 8)
            throw new ValidationException("Password must be at least 8 characters");

        u.setPassword(encoder.encode(u.getPassword()));
        return repo.save(u);
    }

    public UserAccount getUser(Long id){
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}
