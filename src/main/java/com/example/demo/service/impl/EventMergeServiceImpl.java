package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import java.time.LocalDate;
import java.util.*;

public class EventMergeServiceImpl {

    private final AcademicEventRepository eventRepo;
    private final EventMergeRecordRepository mergeRepo;

    public EventMergeServiceImpl(AcademicEventRepository e,EventMergeRecordRepository m){
        this.eventRepo=e; this.mergeRepo=m;
    }

    public EventMergeRecord mergeEvents(List<Long> ids,String reason){
        List<AcademicEvent> events = eventRepo.findAllById(ids);
        if(events.isEmpty())
            throw new ResourceNotFoundException("No events found");

        LocalDate start = events.stream().map(AcademicEvent::getStartDate).min(LocalDate::compareTo).get();
        LocalDate end = events.stream().map(AcademicEvent::getEndDate).max(LocalDate::compareTo).get();

        EventMergeRecord mr = new EventMergeRecord();
        mr.setSourceEventIds(ids.toString().replaceAll("[\\[\\] ]",""));
        mr.setMergedStartDate(start);
        mr.setMergedEndDate(end);
        mr.setMergeReason(reason);

        return mergeRepo.save(mr);
    }

    public List<EventMergeRecord> getMergeRecordsByDate(LocalDate s,LocalDate e){
        return mergeRepo.findByMergedStartDateBetween(s,e);
    }
}
