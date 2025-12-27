package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.List;

public interface UserAccountService {

    UserAccount register(UserAccount userAccount);

    UserAccount login(String username, String password);

    List<UserAccount> getAllUsers();

    UserAccount getUserById(Long id);
}
