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

    public ClashDetectionServiceImpl(ClashRecordRepository clashRecordRepository) {
        this.clashRecordRepository = clashRecordRepository;
    }

    @Override
    public ClashRecord logClash(ClashRecord clashRecord) {
        clashRecord.setResolved(false);
        clashRecord.setDetectedAt(LocalDateTime.now());
        return clashRecordRepository.save(clashRecord);
    }

    @Override
    public ClashRecord resolveClash(Long id) {
        ClashRecord clash = clashRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clash not found"));

        clash.setResolved(true);
        return clashRecordRepository.save(clash);
    }

    @Override
    public List<ClashRecord> getClashesByEventId(Long eventId) {
        List<ClashRecord> clashesA = clashRecordRepository.findByEventAId(eventId);
        List<ClashRecord> clashesB = clashRecordRepository.findByEventBId(eventId);

        clashesA.addAll(clashesB);
        return clashesA;
    }


    @Override
    public List<ClashRecord> getUnresolvedClashes() {
        return clashRecordRepository.findByResolvedFalse();
    }

    @Override
    public List<ClashRecord> getAllClashes() {
        return clashRecordRepository.findAll();
    }
}
