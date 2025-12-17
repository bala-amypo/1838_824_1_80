// package com.example.demo.entity;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.lastSyncAt;

// @Entity
// public class BranchProfile {
//     @Id
//     @GenerateValue(strategy=GenerationType.IDENTITY)
//     private Long id;
//     @Column(unique=true, nullable=false)
//     private String branchCode;
//     private String branchName;
//     private String contactEmail;
//     private String lastSyncAt;
//     private Boolean active;
//     @PrePersist
//     protected void onCreate() {
//         this.lastSyncAt=LocalDateTime.now();
//     }
// }