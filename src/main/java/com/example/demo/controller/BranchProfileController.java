package com.example.demo.controller;

import com.example.demo.entity.BranchProfile;
import com.example.demo.service.BranchProfileService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@RestController
@RequestMapping("/api/branches")
public class BranchProfileController {

    @Autowired
    private BranchProfileService branchProfileService;

    @PostMapping
    public BranchProfile create(@RequestBody BranchProfile branchProfile) {
        return branchProfileService.create(branchProfile);
    }

    @GetMapping
    public List<BranchProfile> getAll() {
        return branchProfileService.getAll();
    }

    @GetMapping("/{id}")
    public BranchProfile getById(@PathVariable Long id) {
        return branchProfileService.getById(id);
    }

    @GetMapping("/code/{branchCode}")
    public BranchProfile getByBranchCode(@PathVariable String branchCode) {
        return branchProfileService.findByBranchCode(branchCode);
    }
}

