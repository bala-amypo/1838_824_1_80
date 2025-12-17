package com.example.demo.entity;

import jakarta.persistence.Id;
import jakarta.persistence.lastSync

@Entity
public class BranchProfile {
    @Id
    private Long id;
    private String branchCode;
    private String branchName;
    private String contactEmail;
    @Prepersist
    private String lastSyncAt;
    private Boolean active;
}