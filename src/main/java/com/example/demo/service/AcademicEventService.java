package com.example.demo.service;

import jakarta.persistence.Service;
import com.example.demo.entity.AcademicEvent;

@Service
public interface AcademicCalenderService{
    public AcademicCalender createEvent(AcademicEvent event);
    public AcademicCalender getEventByBranch(Long branchId);
    public AcademicCalender updateEvent(Long id, AcademicEvent event);
    public AcademicCalender getEventById(Long id);
    public AcademicCalender getAllEvents();
}
