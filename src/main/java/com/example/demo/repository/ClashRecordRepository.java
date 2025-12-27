package com.example.demo.repository;

import com.example.demo.entity.ClashRecord;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Repository
// ClashRecordRepository.java
public interface ClashRecordRepository extends JpaRepository<ClashRecord, Long> {
    List<ClashRecord> findByEventAIdOrEventBId(long a, long b);
}
