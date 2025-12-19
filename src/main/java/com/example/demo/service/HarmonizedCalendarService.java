package com.example.demo.service;

import com.example.demo.entity.HarmonizedCalendar; 



public interface HarmonizedCalendarService {
    public HarmonizedCalendar generateHarmonizedCalendar(String title, String generatedBy);
    public HarmonizedCalendar getCalendarById(Long id);
    public HarmonizedCalendar getAllCalendars();
    public HarmonizedCalendar getCalendarsWithinRange(LocalDate start, LocalDate end);
}