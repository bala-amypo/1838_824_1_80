package com.example.demo.service.impl;

import com.example.demo.entity.ClashRecord;
import com.example.demo.repository.ClashRecordRepository;
import com.example.demo.service.ClashDetectionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClashDetectionServiceImpl implements ClashDetectionService {

    private final ClashRecordRepository clashRecordRepository;

    public ClashDetectionServiceImpl(ClashRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClashRecord logClash(ClashRecord clashRecord) {
        ClashRecord.setResolved(false);
        ClashRecord.setLoggedAt(LocalDateTime.now());
        return clashRecordrepository.save(ClashRecord);
    }

    @Override
    public ClashRecord resolveClash(Long id) {
        ClashRecord clash = clashRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clash not found"));

        clash.setResolved(true);
        return repository.save(clash);
    }

    @Override
    public List<ClashRecord> getClashesByEventId(Long eventId) {
        return repository.findByEventId(eventId);
    }

    @Override
    public List<ClashRecord> getUnresolvedClashes() {
        return repository.findByResolvedFalse();
    }

    @Override
    public List<ClashRecord> getAllClashes() {
        return repository.findAll();
    }
}
