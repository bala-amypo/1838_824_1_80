package com.example.demo.entity;


@Entity
public class BranchProfile {
    @Id
    private Long id;
    private String branchCode;
    private String branchName;
    private String contactEmail;
    @Prepersist
    private String lastyncAt;
    private Boolean active;
}