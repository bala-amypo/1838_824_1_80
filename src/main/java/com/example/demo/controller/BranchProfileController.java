package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.BranchProfile;
import com.example.demo.services.BranchProfileService;

@RestController
@RequestMapping("/api/branch")
public class BranchProfileController {

    
    @Autowired
    private BranchProfileService branchProfileService;
    @PostMapping
    public BranchProfile createBranch(@RequestBody BranchProfile branch) {
        return branchProfileService.createBranch(branch);
    }
    @GetMapping
    public List<BranchProfile> getAllBranches() {
        return branchProfileService.getAllBranches();
    }
    @GetMapping("/{id}")
    public BranchProfile getBranchById(@PathVariable Long id) {
        return branchProfileService.getBranchById(id);
    }
    @GetMapping("/code/{branchCode}")
    public BranchProfile getBranchByCode(@PathVariable String branchCode) {
        return branchProfileService.findByBranchCode(branchCode);
    }
    @PatchMapping("/{id}/status")
    public BranchProfile updateBranchStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {
        return branchProfileService.updateBranchStatus(id, active);
    }

}