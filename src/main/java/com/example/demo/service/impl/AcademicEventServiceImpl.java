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
    private AcademicEventRepository academicEventRepository;

    @Override
    public AcademicEvent createEvent(AcademicEvent event) {
        return academicEventRepository.save(event);
    }

    @Override
    public List<AcademicEvent> getEventByBranch(Long branchId) {
        return academicEventRepository.findByBranchId(branchId);
    }

    @Override
    public AcademicEvent updateEvent(Long id, AcademicEvent event) {
        // Ensure event exists
        academicEventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "AcademicEvent not found with id: " + id));

        // Force ID and save updated object
        event.setId(id);
        return academicEventRepository.save(event);
    }

    @Override
    public AcademicEvent getEventById(Long id) {
        return academicEventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "AcademicEvent not found with id: " + id));
    }

    @Override
    public List<AcademicEvent> getAllEvents() {
        return academicEventRepository.findAll();
    }
}
