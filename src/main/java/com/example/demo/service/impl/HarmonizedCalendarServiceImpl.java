package com.example.demo.service.impl;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.repository.HarmonizedCalendarRepository;
import java.time.LocalDate;
import java.util.List;

public class HarmonizedCalendarServiceImpl {

    private final HarmonizedCalendarRepository repo;

    public HarmonizedCalendarServiceImpl(HarmonizedCalendarRepository r){this.repo=r;}

    public HarmonizedCalendar generateHarmonizedCalendar(String title,String by){
        HarmonizedCalendar c = new HarmonizedCalendar();
        c.setTitle(title);
        c.setGeneratedBy(by);
        c.setEffectiveFrom(LocalDate.now());
        c.setEffectiveTo(LocalDate.now().plusDays(30));
        c.setEventsJson("[]");
        return repo.save(c);
    }

    public List<HarmonizedCalendar> getCalendarsWithinRange(LocalDate s,LocalDate e){
        return repo.findByEffectiveFromLessThanEqualAndEffectiveToGreaterThanEqual(s,e);
    }
}
