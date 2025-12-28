package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UserAccount {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;
    private String department;
    private LocalDateTime createdAt;

    public UserAccount() {}

    public UserAccount(Long id,String name,String email,String password,
                       String role,String department,LocalDateTime createdAt){
        this.id=id; this.name=name; this.email=email; this.password=password;
        this.role=role; this.department=department; this.createdAt=createdAt;
    }

    @PrePersist
    public void prePersist() {
        if (role == null) role = "REVIEWER";
        createdAt = LocalDateTime.now();
    }

    // getters & setters
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getEmail(){return email;}
    public String getPassword(){return password;}
    public String getRole(){return role;}
    public LocalDateTime getCreatedAt(){return createdAt;}
}
