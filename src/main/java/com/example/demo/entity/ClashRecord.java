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

    private String category;

    private LocalDateTime detectedAt;

    private Boolean resolved = false;

    public ClashRecord() {}

    // -------- JPA LIFECYCLE --------
    @PrePersist
    public void prePersist() {
        this.detectedAt = LocalDateTime.now();
    }

    // -------- GETTERS & SETTERS --------

    public Long getId() {
        return id;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getDetectedAt() {
        return detectedAt;
    }

    public Boolean getResolved() {
        return resolved;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }
}
