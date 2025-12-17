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
            throw new RuntimeException("ValidationException: startDate must be before or equal to endDate.")
    }
}