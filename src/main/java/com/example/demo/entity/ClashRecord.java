package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "clash_record")
public class ClashRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long eventAId;

    @Column(nullable = false)
    private Long eventBId;

    @Column(nullable = false)
    private String clashType;

    @Column(nullable = false)
    private String severity;

    private Boolean resolved;

    private LocalDateTime detectedAt;

    // ===== Constructors =====

    public ClashRecord() {
        // JPA requires a no-args constructor
    }

    // ===== Getters and Setters =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEventAId() {
        return eventAId;
    }

    public void setEventAId(Long eventAId) {
        this.eventAId = eventAId;
    }

    public Long getEventBId() {
        return eventBId;
    }

    public void setEventBId(Long eventBId) {
        this.eventBId = eventBId;
    }

    public String getClashType() {
        return clashType;
    }

    public void setClashType(String clashType) {
        this.clashType = clashType;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public Boolean getResolved() {
        return resolved;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }

    public LocalDateTime getDetectedAt() {
        return detectedAt;
    }

    public void setDetectedAt(LocalDateTime detectedAt) {
        this.detectedAt = detectedAt;
    }
}
