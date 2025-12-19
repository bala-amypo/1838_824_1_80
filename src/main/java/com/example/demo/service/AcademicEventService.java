package com.example.demo.service;

import jakarta.persistence.Service;
import java.util.List;
import com.example.demo.entity.AcademicEvent;

@Service
public interface AcademicEventService{
    public AcademicEvent createEvent(AcademicEvent event);
    public AcademicEvent getEventByBranch(Long branchId);
    public AcademicEvent updateEvent(Long id, AcademicEvent event);
    public AcademicEvent getEventById(Long id);
    public AcademicEvent getAllEvents();
}
