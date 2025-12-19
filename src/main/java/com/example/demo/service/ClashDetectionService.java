package com.example.demo.service;


import com.example.demo.entity.ClashRecord;


public interface ClashDetectionService {
    public ClashRecord logClash(ClashRecord clash);
    public ClashRecord getClashesForEvent(Long eventId);
    public ClashRecord resolveClash(Long clashId);
    public ClashRecord getUnresolvedClashes();
    public ClashRecord getAllClashes();
}