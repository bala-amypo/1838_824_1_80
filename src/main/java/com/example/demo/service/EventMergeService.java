package com.example.demo.service;

import com.example.demo.entity.EventMergeRecord;

import java.time.LocalDate;
import java.util.List;

public interface EventMergeService {

    public EventMergeRecord mergeEvents(List<Long> eventIds, String reason);

    public List<EventMergeRecord> getAllMergeRecords();

    public EventMergeRecord getMergeRecordById(Long id);

    public List<EventMergeRecord> getMergeRecordsByDate(LocalDate start, LocalDate end);
}
