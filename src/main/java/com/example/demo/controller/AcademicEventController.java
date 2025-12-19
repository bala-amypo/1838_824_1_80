package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.autowired;
import org.springframework.beans.factory.annotation.GetMapping;
import org.springframework.beans.factory.annotation.PostMapping;
import org.springframework.beans.factory.annotation.PutMapping;
import com.example.demo.entity.BranchProfile;
import com.example.demo.services.BranchProfileService;

@RestController
@RequestMapping("/api/academic-events")
public class AcademicEventController {

    @Autowired
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
    public List<AcademicEvent> getEventsByBranch(@PathVariable Long branchId) {
        return academicEventService.getEventsByBranch(branchId);
    }

    @PutMapping("/{id}")
    public AcademicEvent updateEvent(
            @PathVariable Long id,
            @RequestBody AcademicEvent event) {
        return academicEventService.updateEvent(id, event);
    }
}
