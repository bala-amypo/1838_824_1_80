package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl
        implements UserAccountService {

    private final UserAccountRepository repository;

    public UserAccountServiceImpl(UserAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserAccount register(UserAccount user) {
        user.setRole("USER");
        return repository.save(user);
    }

    @Override
    public String login(String fullName, String password) {

        UserAccount user = repository.findByFullName(fullName)
                .orElseThrow(() -> new RuntimeException("Invalid full name"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }

        return "LOGIN_SUCCESS";
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public UserAccount getUserById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
