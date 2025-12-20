package com.example.demo.repository;

import com.example.demo.entity.AcademicEvent;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AcademicEventRepository extends JpaRepository<AcademicEvent, Long>{
    public List<AcademicEvent> findByBranchId(Long branchId);
}