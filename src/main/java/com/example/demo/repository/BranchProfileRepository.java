package com.example.demo.repository;

import com.eample.demo.entity.BranchProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchProfileRepository extends JpaRepository<BranchProfileEntity, Long>{
    
}