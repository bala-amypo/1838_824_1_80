package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserAccountController {

    private final UserAccountService service;

    public UserAccountController(UserAccountService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public UserAccount register(@RequestBody UserAccount userAccount) {
        return service.register(userAccount);
    }

    @PostMapping("/login")
    public UserAccount login(@RequestParam String username,
                             @RequestParam String password) {
        return service.login(username, password);
    }

    @GetMapping
    public List<UserAccount> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserAccount getUserById(@PathVariable Long id) {
        return service.getUserById(id);
    }
}
