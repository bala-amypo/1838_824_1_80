package com.example.demo.service;

import jakarta.persistence.service;
import com.example.demo.entity.ClashRecord;

public interface ClashDetectionService {
    public ClashRecord logClash(ClashRecord clash);
    public ClashgetClashesForEvent(Long eventId);

}