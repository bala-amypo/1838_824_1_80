package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.autowired;
import org.springframework.beans.factory.annotation.GetMapping;
import org.springframework.beans.factory.annotation.PostMapping;
import org.springframework.beans.factory.annotation.PutMapping;
import com.example.demo.entity.AcademicEvent;
import com.example.demo.services.AcademicEventService;

@RestController
@RequestMapping("/api/events")
public class AcademicEventController {

    @autowired
    private AcademicEventService academicEventService;

    @PostMapping
    public AcademicEvent createEvent(@RequestBody AcademicEvent event) {
        return academicEventService.createEvent(event);
    }
    @GetMapping
    public List<AcademicEvent> getAllEvents() {
        return academicEventService.getAllEvents();
    }
    @GetMapping("/{id}")
    public AcademicEvent getEventById(@PathVariable Long id) {
        return academicEventService.getEventById(id);
    }
    @GetMapping("/branch/{branchId}")
    public List<academicEvent> getEventsByBranch(@PathVariable Long branchId){
        return academicEventService.getEventsByBranch(branchId);
    }
    @PutMapping("/{id}")
    public AcademicEvent updateEvent(@PathVariable Longid, @RequestBody AcademicEvent event){
        return academicEventService.updateEvent(id,event);
    }

}