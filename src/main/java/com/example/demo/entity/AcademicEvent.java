package com.example.demo.entity;

import jakarta.persistence.Entity;


@Entity
public class AcademicEvent {
    private Long id;
    private Long branchId;
    private String title;
    private String eventType;
    private String startDate;
    private String endDate;
    private String location;
    private String description;
    private String submittedAt;
    public AcademicEvent() {

    }
    public void ValidateAndInitializer() {
        this.submittedAt = LocalDateTime.now();
        if (startDate != null && endDate != null && startDate.isAfter(endDate)) {
            throw new RuntimeException("ValidationException: startDate must be before or equal to endDate.");
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getBranchId() { return branchId; }
    public void setBranchId(Long branchId) { this.branchId = branchId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getEventType() { return eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDateTime getSubmittedAt() { return submittedAt; }
    public void setSubmittedAt(LocalDateTime submittedAt) { this.submittedAt = submittedAt; }
    
    public AcademicEvent(Long id, Long branchId, String title, String eventType, String startDate, String endDate, String location, String description, String submittedAt) {
        this.id = id;
        this.branchId = branchId;
        this.title = title;
        this.eventType = eventType;
        
    }
}