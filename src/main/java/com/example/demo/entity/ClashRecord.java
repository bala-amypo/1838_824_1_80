package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "clash_records")
public class ClashRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventAId;
    private Long eventBId;

    private String clashType;
    private String severity;

    private Boolean resolved;
    private LocalDateTime detectedAt;

    // ===== Constructors =====

    public ClashRecord() {
        // required by JPA
    }

    // ===== JPA Lifecycle =====

    @PrePersist
    public void prePersist() {
        this.detectedAt = LocalDateTime.now();
        if (this.resolved == null) {
            this.resolved = false;
        }
    }

    // ===== Getters =====

    public Long getId() {
        return id;
    }

    public Long getEventAId() {
        return eventAId;
    }

    public Long getEventBId() {
        return eventBId;
    }

    public String getClashType() {
        return clashType;
    }

    public String getSeverity() {
        return severity;
    }

    public Boolean getResolved() {
        return resolved;
    }

    public LocalDateTime getDetectedAt() {
        return detectedAt;
    }

    // ===== Setters (REQUIRED BY TESTS & SERVICES) =====

    public void setId(Long id) {
        this.id = id;
    }

    public void setEventAId(Long eventAId) {
        this.eventAId = eventAId;
    }

    public void setEventBId(Long eventBId) {
        this.eventBId = eventBId;
    }

    public void setClashType(String clashType) {
        this.clashType = clashType;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }

    public void setDetectedAt(LocalDateTime detectedAt) {
        this.detectedAt = detectedAt;
    }
}
