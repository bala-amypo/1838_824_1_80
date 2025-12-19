package com.example.demo.controller;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.service.AcademicEventService;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/academic-events")
public class AcademicEventController {

    @Autowired
    private AcademicEventService academicEventService;

    @PostMapping
    public AcademicEvent create(@RequestBody AcademicEvent event) {
        return academicEventService.createEvent(event);
    }

    @GetMapping
    public List<AcademicEvent> getAll() {
        return academicEventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public AcademicEvent getById(@PathVariable Long id) {
        return academicEventService.getEventById(id);
    }
}
