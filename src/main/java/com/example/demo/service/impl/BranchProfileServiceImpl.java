package com.example.demo.service.impl;

import com.example.demo.entity.BranchProfile;
import com.example.demo.repository.BranchProfileRepository;
import com.example.demo.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BranchProfileServiceImpl {

    private final BranchProfileRepository repo;

    public BranchProfileServiceImpl(BranchProfileRepository r){this.repo=r;}

    public BranchProfile createBranch(BranchProfile b){
        return repo.save(b);
    }

    public BranchProfile updateBranchStatus(Long id,Boolean active){
        BranchProfile bp = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Branch not found"));
        bp.setActive(active);
        return repo.save(bp);
    }

    public List<BranchProfile> getAllBranches(){
        return repo.findAll();
    }
}
