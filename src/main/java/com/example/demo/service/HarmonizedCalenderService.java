package com.example.demo.service;

import com.example.demo.entity.HarmonizedCalender; 
import jakarta.persistence.Service;

@Service
public interface HarmoonizedCalenderService {
    public HarmonizedCalender generateHarmonizedCalender(String title, String generatedBy);
    public HarmonizedCalender getCalenderById(Long id);
    public HarmonizedCalender getAllCalendars();
    public HarmonizedCalender getCalendars
}