package com.example.demo.service;

import com.example.demo.entity.BranchProfile;

public interface BranchProfileService {

    BranchProfile createBranch(BranchProfile branchProfile);

    BranchProfile updateBranchStatus(long branchId, boolean active);

    BranchProfile getBranch(long branchId);
}
