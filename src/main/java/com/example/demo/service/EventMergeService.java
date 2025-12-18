package com.example.demo.service;

import jakarta.persistence.Service;
import com.example.demo.entity.EventMergeRecord;

@Service
public interface EventMergeService {
    public EventMerge mergeEvents(List<Long> eventIds, string reason);
    public EventMerge getAllMergeRrecord();
    public EventMerge getMergeRecordById(Long id);
    public EventMerge getMergeRecordByDate(LocalDate start, LocalDate end)
}