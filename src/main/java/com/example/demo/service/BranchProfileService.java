package com.example.demo.service;

import com.example.demo.entity.BranchProfile;
import jakarta.persistence.service;

public interface BranchProfileService {
    public BranchProfile createBranch(BranchProfile branch);
    public BranchProfile updateBranchStatus(Long id, boolean active);
    public BranchProfile getAllBranches();
    public 
}