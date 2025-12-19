package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.autowired;
import org.springframework.beans.factory.annotation.GetMapping;
import org.springframework.beans.factory.annotation.PostMapping;
import org.springframework.beans.factory.annotation.PutMapping;
import com.example.demo.entity.AcademicEvent;
import com.example.demo.services.AcademicEventService;

@RestController
@RequestMapping("/api/academicevents")
public class AcademicEventController {

    @autowired
    private AcademicEventService academicEventService;

    @PostMapping
    public AcademicEvent createEvent(@RequestBody AcademicEvent event) {
        return academicEventService.createEvent(event);
    }
    @GetMapping
    public List<AcademicEvent> getAllEvents() {
        return academicEvent
    }

}