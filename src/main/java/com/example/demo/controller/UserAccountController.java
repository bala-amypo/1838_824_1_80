package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountService service;

    public UserAccountController(UserAccountService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public UserAccount register(@RequestBody UserAccount user) {
        return service.register(user);
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String fullName,
            @RequestParam String password
    ) {
        return service.login(fullName, password);
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
