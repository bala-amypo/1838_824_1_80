package com.example.demo.service;


import java.util.List;
import com.example.demo.entity.AcademicEvent;


public interface AcademicEventService{
    public AcademicEvent createEvent(AcademicEvent event);
    public AcademicEvent getEventByBranch(Long branchId);
    public AcademicEvent updateEvent(Long id, AcademicEvent event);
    public AcademicEvent getEventById(Long id);
    public AcademicEvent getAllEvents();
}
