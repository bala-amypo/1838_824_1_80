package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrePersist;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class EventMergeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sourceEventIds;
    private String mergedTitle;
    private LocalDate mergedStartDate;
    private LocalDate mergedEndDate;
    private String mergeReason;

    private LocalDateTime createdAt;

    @PrePersist
    public void validateAndInitialize() {
        this.createdAt = LocalDateTime.now();

        if (this.mergedStartDate == null) {
            this.mergedStartDate = LocalDate.now();
        }

        if (this.mergedEndDate == null) {
            this.mergedEndDate = LocalDate.now();
        }
    }

    // Constructors
    public EventMergeRecord() {}

    public EventMergeRecord(
            String sourceEventIds,
            String mergedTitle,
            LocalDate mergedStartDate,
            LocalDate mergedEndDate,
            String mergeReason
    ) {
        this.sourceEventIds = sourceEventIds;
        this.mergedTitle = mergedTitle;
        this.mergedStartDate = mergedStartDate;
        this.mergedEndDate = mergedEndDate;
        this.mergeReason = mergeReason;
    }

    // Getters & Setters
    public Long getId() {
        return id;
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
}
