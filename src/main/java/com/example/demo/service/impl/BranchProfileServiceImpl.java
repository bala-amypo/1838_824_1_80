package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BranchProfile;
import com.example.demo.repository.BranchProfileRepository;
import com.example.demo.service.BranchProfileService;

@Service
public class BranchProfileServiceImpl implements BranchProfileService {

    @Autowired
    private BranchProfileRepository repository;

    @Override
    public BranchProfile create(BranchProfile branchProfile) {
        return repository.save(branchProfile);
    }

    @Override
    public List<BranchProfile> getAll() {
        return repository.findAll();
    }

    @Override
    public BranchProfile getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("BranchProfile not found with id " + id));
    }


    @Override
    public BranchProfile findByBranchCode(String branchCode) {
        return repository.findByBranchCode(branchCode);
    }
}

