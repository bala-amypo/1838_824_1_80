package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.service.AcademicEventService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class AcademicEventServiceImpl implements AcademicEventService {

    private final AcademicEventRepository academicEventRepository;

    @Autowired
    public AcademicEventServiceImpl(AcademicEventRepository academicEventRepository) {
        this.academicEventRepository = academicEventRepository;
    }

    @Override
    public AcademicEvent createEvent(AcademicEvent event) {
        return academicEventRepository.save(event);
    }

    @Override
    public List<AcademicEvent> getAllEvents() {
        return academicEventRepository.findAll();
    }

    @Override
    public AcademicEvent getEventById(Long id) {
        return academicEventRepository.findById(id).orElse(null);
    }

    @Override
    public AcademicEvent updateEvent(Long id, AcademicEvent event) {
        event.setId(id);
        return academicEventRepository.save(event);
    }
}
