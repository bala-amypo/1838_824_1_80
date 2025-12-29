package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "clash_records")
public class ClashRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ===== Fields expected by tests =====
    private Long eventAId;
    private Long eventBId;

    private String category;

    private LocalDateTime detectedAt;

    private Boolean resolved = false;

    // ===== Constructors =====
    public ClashRecord() {
    }

    // ===== JPA lifecycle hook (expected by tests) =====
    @PrePersist
    public void prePersist() {
        if (this.detectedAt == null) {
            this.detectedAt = LocalDateTime.now();
        }
    }

    // ===== Getters & Setters (exact names tests use) =====

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
