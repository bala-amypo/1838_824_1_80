package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
public class HarmonizedCalendar {

    @Id
    private Long id;
    private String title;
    private String generatedBy;
    private LocalDateTime generatedAt;
    private LocalDate effectiveTo;
    private LocalDate effectiveFrom;
    private String eventsJson;

    // public void ValidateAndInitializer() {
    //     this.effectiveTo = LocalDate.now();
    //     this.effectiveFrom = LocalDate.now();
    //     this.generatedAt = LocalDateTime.now();
    // }
    

    public HarmonizedCalendar(LocalDate effectiveFrom, LocalDate effectiveTo, String eventsJson, LocalDateTime generatedAt, String generatedBy, Long id, String title) {
        this.effectiveFrom = effectiveFrom;
        this.effectiveTo = effectiveTo;
        this.eventsJson = eventsJson;
        this.generatedAt = generatedAt;
        this.generatedBy = generatedBy;
        this.id = id;
        this.title = title;
    }

    // public void ValidateAndInitializer() {
    //     this.effectiveTo = LocalDate.now();
    //     this.effectiveFrom = LocalDate.now();
    //     this.generatedAt = LocalDateTime.now();
    // }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(String generatedBy) {
        this.generatedBy = generatedBy;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(LocalDateTime generatedAt) {
        this.generatedAt = generatedAt;
    }

    public LocalDate getEffectiveTo() {
        return effectiveTo;
    }

    public void setEffectiveTo(LocalDate effectiveTo) {
        this.effectiveTo = effectiveTo;
    }

    public LocalDate getEffectiveFrom() {
        return effectiveFrom;
    }

    public void setEffectiveFrom(LocalDate effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    public String getEventsJson() {
        return eventsJson;
    }

    public void setEventsJson(String eventsJson) {
        this.eventsJson = eventsJson;
    }
      public HarmonizedCalendar() {
         
    }

}