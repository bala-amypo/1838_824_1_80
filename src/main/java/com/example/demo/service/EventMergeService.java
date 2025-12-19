package com.example.demo.service;


import com.example.demo.entity.EventMergeRecord;


public interface EventMergeService {
    public EventMerge mergeEvents(List<Long> eventIds, string reason);
    public EventMerge getAllMergeRrecord();
    public EventMerge getMergeRecordById(Long id);
    public EventMerge getMergeRecordByDate(LocalDate start, LocalDate end);
}