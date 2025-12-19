package com.example.demo.service;

import java.util.List;
import java.time.LocalDate;

import com.example.demo.entity.EventMergeRecord;

public interface EventMergeService {

    List<EventMerge> getAllMergedEvents();

    EventMerge getMergedEventById(Long id);

    EventMerge mergeEvents(
            List<String> sourceEventIds,
            String mergedTitle,
            LocalDate startDate,
            LocalDate endDate
    );
}
