package com.example.demo.entity;

import jakarta.persistence.entity;
import jakarta.persistence.Id;
import jakarta.persistence.LocalDateTime;

@Entity
public class BranchProfile {
    @Id
    private Long id;
    private String branchCode;
    private String branchName;
    private String contactEmail;
    private LocalDateTime lastSyncAt;
    private Boolean active 

}