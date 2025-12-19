package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import java.util.List;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.service.AcademicEventService;
import org.springframework.sterotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AcademicEventServiceImpl implements AcademicEventService {

    @Autowired
    private AcademicEventRepository aer;
    @Override
    public AcademicEvent createAcademicEvent(AcademicEvent Event){
        return aer.save(Event)
    }
    @Override
    public List<AcademicEvent>getEventsByBranch(Long branchId){
        return academicEventRepository.findByBranchId(branchId);
    } 
    @Override
    public AcademicEvent
}