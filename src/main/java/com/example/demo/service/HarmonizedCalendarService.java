package com.example.demo.service;

import com.example.demo.entity.HarmonizedCalendar;

import java.time.LocalDate;
import java.util.List;

public interface HarmonizedCalendarService {

    public HarmonizedCalendar generateCalendar(HarmonizedCalendar calendar);

    public HarmonizedCalendar getCalendarById(Long id);

    public List<HarmonizedCalendar> getAllCalendars();

    public List<HarmonizedCalendar> getCalendarsInRange(LocalDate effectiveFrom, LocalDate effectiveTo);
}
