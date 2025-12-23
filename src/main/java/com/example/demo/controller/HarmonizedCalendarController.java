package com.example.demo.controller;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.service.HarmonizedCalendarService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/calendars")
public class HarmonizedCalendarController {

    private final HarmonizedCalendarService service;

    public HarmonizedCalendarController(
            HarmonizedCalendarService service
    ) {
        this.service = service;
    }

    @PostMapping
    public HarmonizedCalendar generateCalendar(
            @RequestBody HarmonizedCalendar calendar
    ) {
        return service.generateCalendar(calendar);
    }

    @GetMapping("/{id}")
    public HarmonizedCalendar getCalendarById(
            @PathVariable Long id
    ) {
        return service.getCalendarById(id);
    }

    @GetMapping
    public List<HarmonizedCalendar> getAllCalendars() {
        return service.getAllCalendars();
    }

    @GetMapping("/range")
    public List<HarmonizedCalendar> getCalendarsInRange(
            @RequestParam LocalDate start,
            @RequestParam LocalDate end
    ) {
        return service.getCalendarsInRange(start, end);
    }
}
