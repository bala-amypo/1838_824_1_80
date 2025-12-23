package com.example.demo.service;

import com.example.demo.entity.HarmonizedCalendar;

import java.time.LocalDate;
import java.util.List;

public interface HarmonizedCalendarService {

    HarmonizedCalendar generateCalendar(HarmonizedCalendar calendar);

    HarmonizedCalendar getCalendarById(Long id);

    List<HarmonizedCalendar> getAllCalendars();

    List<HarmonizedCalendar> getCalendarsInRange(
            LocalDate start,
            LocalDate end
    );
}
