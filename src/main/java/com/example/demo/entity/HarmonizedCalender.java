package com.example.demo.entity;

import jakarta.persistence.Entity;

@Entity
public class HarmonizedCalender {
    private Long id;
    private String title;
    private String generatedBy;
    private LocalDateTime generatedAt;
    
}