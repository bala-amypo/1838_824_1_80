package com.example.demo.service.impl;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.repository.HarmonizedCalendarRepository;
import com.example.demo.service.HarmonizedCalendarService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HarmonizedCalendarServiceImpl implements HarmonizedCalendarService {

    private final HarmonizedCalendarRepository repository;

    public HarmonizedCalendarServiceImpl(HarmonizedCalendarRepository repository) {
        this.repository = repository;
    }

    @Override
    public HarmonizedCalendar generateCalendar(HarmonizedCalendar calendar) {
        calendar.setGeneratedBy("SYSTEM");
        return repository.save(calendar);
    }

    @Override
    public HarmonizedCalendar getCalendarById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Calendar not found"));
    }

    @Override
    public List<HarmonizedCalendar> getAllCalendars() {
        return repository.findAll();
    }

    @Override
    public List<HarmonizedCalendar> getCalendarsInRange(LocalDate start, LocalDate end) {
        return repository.findByStartDateGreaterThanEqualAndEndDateLessThanEqual(start, end);
    }
}
