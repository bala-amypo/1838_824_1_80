package com.example.demo.repository;

import com.example.demo.entity.AcademicEvent;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademicEventRepository extends JpaRepository<AcademicEvent, Long>{
    List<AcademicEvent> findByBranchId(Long branchId);
}