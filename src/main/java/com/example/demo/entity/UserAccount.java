package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserAccount {
    
    @Id
    private Long id;
    private String fullName;
    private String email;
    private String password;
    private String role;
    private String department;
    private LocalDateTime createdAt;

    public void ValidateAndInitializer() {
        this.
    }
}