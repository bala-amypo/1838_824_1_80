package com.example.demo.service;

import com.example.demo.entity.UserAccount;

import java.util.List;

public interface UserAccountService {

    public UserAccount register(UserAccount user);

    public String login(String username, String password);

    public List<UserAccount> getAllUsers();

    public UserAccount getUserById(Long id);
}
