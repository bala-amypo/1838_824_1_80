package com.example.demo.repository;

import com.example.demo.entity.ClashRecord;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Repository
public interface ClashRecordRepository extends JpaRepository<ClashRecord, Long>{
    public List<ClashRecord> findByEventAId(Long eventAId,);

    public List<ClashRecord> findByResolvedFalse();
}