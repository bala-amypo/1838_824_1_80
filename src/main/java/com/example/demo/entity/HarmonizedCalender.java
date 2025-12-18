package com.example.demo.entity;

import jakarta.persistence.Entity;


@Entity
public class HarmonizedCalender {

    private Long id;
    private String title;
    private String generatedBy;
    private LocalDateTime generatedAt;
    private LocalDate effectiveTo;
    private LocalDate effectiveFrom;
    private String eventsJson;

    public void ValidateAndInitializer() {
        this.effectiveTo = LocalDate.now();
        this.effectiveFrom = LocalDate.now();
        this.generatedAt = LocalDateTime.now();
    }
}