package com.example.demo.service;

import jakarta.persistence.Service;
import com.example.demo.entity.ClashRecord;

@Service
public interface ClashDetectionService {
    public ClashRecord logClash(ClashRecord clash);
    public ClashRecord getClashesForEvent(Long eventId);
    public ClashRecord resolveClash(Long clashId);
    public ClashRecord getUnresolvedClashes();
    public ClashRecord getAllClashes();
}