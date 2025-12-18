package com.example.demo.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import java.time.LocalDateTime;
import java.time.LocalDate;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GeneratedType;

@Entity
public class EventMergeRecord {
    @Id
    private Long id;
    private String sourceEventIds;
    private String mergedTitle;
    private LocalDate mergedStartDate;
    private LocalDate mergedEndDate;
    private String mergeReason;
    

    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private LocalDateTime createdAt;
    public void ValidateAndInitializer() {
        this.createdAt = LocalDateTime.now();
        this.mergedStartDate = LocalDate.now();
        this mergedEndDate = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSourceEventIds() {
        return sourceEventIds;
    }

    public void setSourceEventIds(String sourceEventIds) {
        this.sourceEventIds = sourceEventIds;
    }

    public String getMergedTitle() {
        return mergedTitle;
    }

    public void setMergedTitle(String mergedTitle) {
        this.mergedTitle = mergedTitle;
    }

    public LocalDate getMergedStartDate() {
        return mergedStartDate;
    }

    public void setMergedStartDate(LocalDate mergedStartDate) {
        this.mergedStartDate = mergedStartDate;
    }

    public LocalDate getMergedEndDate() {
        return mergedEndDate;
    }

    public void setMergedEndDate(LocalDate mergedEndDate) {
        this.mergedEndDate = mergedEndDate;
    }

    public String getMergeReason() {
        return mergeReason;
    }

    public void setMergeReason(String mergeReason) {
        this.mergeReason = mergeReason;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public EventMergeRecord(LocalDateTime createdAt, Long id, String mergeReason, LocalDate mergedEndDate, LocalDate mergedStartDate, String mergedTitle, String sourceEventIds) {
        this.createdAt = createdAt;
        this.id = id;
        this.mergeReason = mergeReason;
        this.mergedEndDate = mergedEndDate;
        this.mergedStartDate = mergedStartDate;
        this.mergedTitle = mergedTitle;
        this.sourceEventIds = sourceEventIds;
    }
    public EventMergeRecord() {
    
}
}