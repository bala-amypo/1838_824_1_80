package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class UserAccountController {

    private final UserAccountService service;

    public UserAccountController(UserAccountService service) {
        this.service = service;
    }

    // POST /auth/register - Register a new user
    @PostMapping("/register")
    public UserAccount register(@RequestBody UserAccount user) {
        return service.register(user);
    }

    // POST /auth/login - Login and return JWT token
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody UserAccount user) {
        String token = service.login(user.getFirstname(), user.getPassword());
        return Map.of("token", token);
    }

    // GET /auth/users - ADMIN only
    @GetMapping("/users")
    public List<UserAccount> getAllUsers() {
        return service.getAllUsers();
    }

    // GET /auth/users/{id} - ADMIN only
    @GetMapping("/users/{id}")
    public UserAccount getUserById(@PathVariable Long id) {
        return service.getUserById(id);
    }
}
