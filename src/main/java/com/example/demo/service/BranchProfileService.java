package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.BranchProfile;

public interface BranchProfileService {

    public BranchProfile create(BranchProfile branchProfile);

    public List<BranchProfile> getAll();

    public BranchProfile getById(Long id);

    public BranchProfile findByBranchCode(String branchCode);
}
