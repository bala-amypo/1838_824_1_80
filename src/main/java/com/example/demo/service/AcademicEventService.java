package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.service.AcademicEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicEventServiceImpl implements AcademicEventService {

    @Autowired
    private AcademicEventRepository repository;

    @Override
    public AcademicEvent createEvent(AcademicEvent event) {
        return repository.save(event);
    }

    // ORIGINAL
    @Override
    public List<AcademicEvent> getEventByBranch(Long branchId) {
        return repository.findByBranchId(branchId);
    }

    // ✅ REQUIRED BY TESTS
    public List<AcademicEvent> getEventsByBranch(Long branchId) {
        return getEventByBranch(branchId);
    }

    @Override
    public AcademicEvent updateEvent(Long id, AcademicEvent event) {
        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
        event.setId(id);
        return repository.save(event);
    }

    @Override
    public AcademicEvent getEventById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    @Override
    public List<AcademicEvent> getAllEvents() {
        return repository.findAll();
    }
}
