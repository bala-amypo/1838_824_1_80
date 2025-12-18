package com.example.demo.repository;

import com.eample.demo.entity.AcademicEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademicEventRepository extends JpaRepository<AcademicEventEntity, Long>{
    
}