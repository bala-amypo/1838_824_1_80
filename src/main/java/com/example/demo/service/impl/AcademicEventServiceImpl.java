package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import java.util.List;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.service.AcademicEventService;
import org.springframework.sterotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AcademicEventServiceImpl implements AcademicEventService {

    @Autowired
    private AcademicEventRepository aer;
    @Override
    public AcademicEvent createAcademicEvent(AcademicEvent Event){
        return aer.save(Event);
    }
    @Override
    public List<AcademicEvent>getEventsByBranch(Long branchId){
        return academicEventRepository.findByBranchId(branchId);
    } 
    @Override
    public AcademicEvent updateEvent(Long id, AcademicEvent event) {
        AcademicEvent existingEvent = academicEventRepository.findById(id).orElseThrow(() -> new RuntimeException("Academic Event not found with id: " + id));

        existingEvent.setTitle(event.getTitle());
        existingEvent.setEventType(event.getEventType());
        existingEvent.setStartDate(event.getStartDate());
        existingEvent.setEndDate(event.getEndDate());
        existingEvent.setLocation(event.getLocation());
        existingEvent.setDescription(event.getDescription());
        existingEvent.setBranchId(event.getBranchId());

        return academicEventRepository.save(existingEvent);
    }
     @Override
    public AcademicEvent getEventById(Long id) {
        return academicEventRepository.findById(id).orElseThrow(() -> new RuntimeException("Academic Event not found with id: " + id));
    }

    @Override
    public List<AcademicEvent> getAllEvents() {
        return academicEventRepository.findAll();
    }
}