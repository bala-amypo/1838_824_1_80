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

    public ClashRecord() {}

    @PrePersist
    public void prePersist() {
        this.detectedAt = LocalDateTime.now();
        if (this.resolved == null) this.resolved = false;
    }

    // getters & setters
    public void setClashType(String clashType) { this.clashType = clashType; }
    public void setSeverity(String severity) { this.severity = severity; }

    public Long getEventAId() { return eventAId; }
    public Long getEventBId() { return eventBId; }
    public LocalDateTime getDetectedAt() { return detectedAt; }

    public void setResolved(Boolean resolved) { this.resolved = resolved; }
}
