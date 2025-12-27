package com.example.demo.service.impl;

import com.example.demo.entity.BranchProfile;
import com.example.demo.repository.BranchProfileRepository;
import com.example.demo.service.BranchProfileService;
import org.springframework.stereotype.Service;

@Service
public class BranchProfileServiceImpl implements BranchProfileService {

    private final BranchProfileRepository repository;

    public BranchProfileServiceImpl(BranchProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public BranchProfile createBranch(BranchProfile branchProfile) {
        return repository.save(branchProfile);
    }

    @Override
    public BranchProfile updateBranchStatus(long branchId, boolean active) {
        BranchProfile branch = repository.findById(branchId)
                .orElseThrow(() -> new RuntimeException("Branch not found"));

        branch.setActive(active);
        return repository.save(branch);
    }

    @Override
    public BranchProfile getBranch(long branchId) {
        return repository.findById(branchId)
                .orElseThrow(() -> new RuntimeException("Branch not found"));
    }
}
