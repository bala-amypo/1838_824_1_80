package com.example.demo.service.impl;

import com.example.demo.entity.BranchProfile;
import com.example.demo.repository.BranchProfileRepository;
import com.example.demo.service.BranchProfileService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchProfileServiceImpl implements BranchProfileService {

    private final BranchProfileRepository branchProfileRepository;

    public BranchProfileServiceImpl(BranchProfileRepository branchProfileRepository) {
        this.branchProfileRepository = branchProfileRepository;
    }

    @Override
    public BranchProfile create(BranchProfile branchProfile) {
        return branchProfileRepository.save(branchProfile);
    }

    @Override
    public List<BranchProfile> getAll() {
        return branchProfileRepository.findAll();
    }

    @Override
    public BranchProfile getById(Long id) {
        return branchProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BranchProfile not found"));
    }

    @Override
    public BranchProfile findByBranchCode(String branchCode) {
        return branchProfileRepository.findByBranchCode(branchCode)
                .orElseThrow(() -> new RuntimeException("Branch code not found"));
    }
}
