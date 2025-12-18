package com.example.demo.service;

import com.example.demo.entity.BranchProfile;
import jakarta.persistence.Service;

public interface BranchProfileService {
    public BranchProfile createBranch(BranchProfile branch);
    public BranchProfile updateBranchStatus(Long id, boolean active);
    public BranchProfile getAllBranches();
    public BranchProfile getBranchById(Long id);
    public BranchProfile findByBranchCode(String branchCode);
}