package com.example.demo.entity;

import jakarta.persistence.Id;
import jakarta.persistence.lastSyncAt;

@Entity
public class BranchProfile {
    @Id
    @GenerateValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true, nullable=false)
    private String branchCode;
    private String branchName;
    private String contactEmail;
    @Prepersist
    private String lastSyncAt;
    private Boolean active;
}