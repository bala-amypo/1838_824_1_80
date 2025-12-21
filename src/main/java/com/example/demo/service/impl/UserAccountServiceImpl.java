package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repository;

    public UserAccountServiceImpl(UserAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserAccount register(UserAccount user) {
        user.setRole("USER"); // default role
        return repository.save(user);
    }

    @Override
    public String login(String fullname, String password) {
        UserAccount user = repository.findByFullname(fullname).orElseThrow(() -> new RuntimeException("Invalid fullname"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }

        // Dummy JWT token (replace with real JWT later)
        return "JWT_TOKEN_FOR_" + user.getFullname();

    }

    @Override
    public List<UserAccount> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public UserAccount getUserById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
