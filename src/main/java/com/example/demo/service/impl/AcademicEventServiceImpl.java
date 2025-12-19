package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.service.AcademicEventService;
import org.springframework.sterotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AcademicEventServiceImpl implements AcademicEventService {

    @Autowired
    AcademicEventRepository aer;

}