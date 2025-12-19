package com.example.demo.service;

import java.util.List;
import java.time.LocalDate;

import com.example.demo.entity.EventMergeRecord;

public interface EventMergeService {

    public List<EventMergeRecord> getAllMergedEvents();

    public EventMergeRecord getMergedEventById(Long id);

    public EventMergeRecord mergeEvents(
            List<String> sourceEventIds,
            String mergedTitle,
            LocalDate startDate,
            LocalDate endDate
    );
}
