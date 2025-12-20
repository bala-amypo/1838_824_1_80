package com.example.demo.repository;

import com.example.demo.entity.BranchProfile;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BranchProfileRepository extends JpaRepository<BranchProfile, Long>{
    Optional<BranchProfile> findByBranchCode(String branchCode);
}