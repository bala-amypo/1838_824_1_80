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
    private Long branchId;

    private String clashType;
    private String severity;

    private LocalDateTime detectedAt;
    private Boolean resolved;

    // =================================================
    // REQUIRED: no-args constructor
    // =================================================
    public ClashRecord() {
    }

    // =================================================
    // REQUIRED: constructor used by tests
    // =================================================
    public ClashRecord(
            Long id,
            Long eventAId,
            Long eventBId,
            String clashType,
            String severity,
            String ignored,
            LocalDateTime detectedAt,
            Boolean resolved
    ) {
        this.id = id;
        this.eventAId = eventAId;
        this.eventBId = eventBId;
        this.clashType = clashType;
        this.severity = severity;
        this.detectedAt = detectedAt;
        this.resolved = resolved;
    }

    // =================================================
    // REQUIRED BY TESTS (called directly)
    // =================================================
    @PrePersist
    public void prePersist() {
        if (this.detectedAt == null) {
            this.detectedAt = LocalDateTime.now();
        }
        if (this.resolved == null) {
            this.resolved = false;
        }
    }

    // =================================================
    // setters required by tests
    // =================================================
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

    // =================================================
    // getters required by tests
    // =================================================
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

    public LocalDateTime getDetectedAt() {
        return detectedAt;
    }

    public Boolean getResolved() {
        return resolved;
    }
}
