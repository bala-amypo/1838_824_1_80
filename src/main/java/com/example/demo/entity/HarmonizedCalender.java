package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
public class HarmonizedCalender {

    @Id
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