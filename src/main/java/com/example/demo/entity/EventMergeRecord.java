package com.example.demo.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import java.time.LocalDateTime;
import java.time.LocalDate;

@Entity
public class EventMergeRecord {
    @Id
    private Long id;
    private String sourceEventIds;
    private String mergedTitle;
    private LocalDate mergedStartDate;
    private LocalDate mergedEndDate;
    private String mergeReason;
    private LocalDateTime createdAt;
    public void ValidateAndInitializer() {
        this.createdAt = LocalDateTime.now();
        this.mergedStartDate = LocalDate.now();
        this mergedEndDate = LocalDate.now();
    }
}