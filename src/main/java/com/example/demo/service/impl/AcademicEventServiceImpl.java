package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.AcademicEventRepository;
import java.util.List;

public class AcademicEventServiceImpl {

    private final AcademicEventRepository repo;

    public AcademicEventServiceImpl(AcademicEventRepository r){this.repo=r;}

    public AcademicEvent createEvent(AcademicEvent e){
        if(e.getStartDate().isAfter(e.getEndDate()))
            throw new ValidationException("startDate cannot be after endDate");
        return repo.save(e);
    }

    public List<AcademicEvent> getEventsByBranch(Long id){
        return repo.findByBranchId(id);
    }
}
