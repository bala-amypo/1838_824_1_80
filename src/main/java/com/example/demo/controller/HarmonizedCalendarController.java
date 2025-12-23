package com.example.demo.controller;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.service.HarmonizedCalendarService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/harmonized-calendars")
public class HarmonizedCalendarController {

    private final HarmonizedCalendarService harmonizedCalendarService;

    public HarmonizedCalendarController(HarmonizedCalendarService harmonizedCalendarService) {
        this.harmonizedCalendarService = harmonizedCalendarService;
    }

    // POST /generate - Generate a harmonized calendar
    @PostMapping("/generate")
    public HarmonizedCalendar generateCalendar(
            @RequestBody HarmonizedCalendar calendar) {
        return harmonizedCalendarService.generateCalendar(calendar);
    }

    // GET /{id} - Get calendar by ID
    @GetMapping("/{id}")
    public HarmonizedCalendar getCalendarById(@PathVariable Long id) {
        return harmonizedCalendarService.getCalendarById(id);
    }

    // GET / - List all calendars
    @GetMapping
    public List<HarmonizedCalendar> getAllCalendars() {
        return harmonizedCalendarService.getAllCalendars();
    }

    // GET /range - Get calendars within date range
    @GetMapping("/range")
    public List<HarmonizedCalendar> getCalendarsInRange(@RequestParam LocalDate start, @RequestParam LocalDate end) {
        return harmonizedCalendarService.getCalendarsInRange(start, end);
    }
}
