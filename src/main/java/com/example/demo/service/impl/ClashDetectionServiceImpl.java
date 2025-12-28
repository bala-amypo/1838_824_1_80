package com.example.demo.service.impl;

import com.example.demo.entity.ClashRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ClashRecordRepository;
import java.util.List;

public class ClashDetectionServiceImpl {

    private final ClashRecordRepository repo;

    public ClashDetectionServiceImpl(ClashRecordRepository r){this.repo=r;}

    public List<ClashRecord> getClashesForEvent(Long id){
        return repo.findByEventAIdOrEventBId(id,id);
    }

    public List<ClashRecord> getUnresolvedClashes(){
        return repo.findByResolvedFalse();
    }

    public ClashRecord resolveClash(Long id){
        ClashRecord cr = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Clash not found"));
        cr.setResolved(true);
        return repo.save(cr);
    }
}
