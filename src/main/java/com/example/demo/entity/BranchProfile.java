package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.LocalDateTime;
import java.lang.Boolean;

@Entity
public class BranchProfile {
    @Id
    private Long id;
    private String branchCode;
    private String branchName;
    private String contactEmail;
    private LocalDateTime lastSyncAt;
    private Boolean active;
    public void ValidateAndInitializer() {
        this.lastSyncAt = LocalDateTime.now();
    }

}