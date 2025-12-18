package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.lang.Boolean;
import java.time.LocalDateTime;


@Entity
public class ClashRecord {
    
    @Id
    private Long id;
    private Long eventAId;
    private Long eventBId;
    private String clashType;
    private String severity;
    private String details;
    private LocalDateTime detectedAt;
    private Boolean resolved;

    public void ValidateAndInitializer() {
        this.detectedAt = LocalDateTime.now();

    }
    
}