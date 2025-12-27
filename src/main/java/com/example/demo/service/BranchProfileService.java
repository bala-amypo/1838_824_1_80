package com.example.demo.service;

import com.example.demo.entity.BranchProfile;
import java.util.List;

public interface BranchProfileService {

    BranchProfile create(BranchProfile branchProfile);

    List<BranchProfile> getAll();

    BranchProfile getById(Long id);

    BranchProfile findByBranchCode(String branchCode);
}
