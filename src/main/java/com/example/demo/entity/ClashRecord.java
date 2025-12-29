package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "clash_records")
public class ClashRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "branch_id_1")
    private Long branchId1;

    @Column(name = "branch_id_2")
    private Long branchId2;

    @Column(name = "calendar_id")
    private Long calendarId;

    @Column(name = "event_name_1")
    private String eventName1;

    @Column(name = "event_name_2")
    private String eventName2;

    @Column(name = "clash_type")
    private String clashType;

    @Column(name = "logged_at")
    private LocalDateTime loggedAt;

    @Column(name = "resolved")
    private Boolean resolved;

    // ✅ REQUIRED: No-args constructor (JPA + tests)
    public ClashRecord() {
    }

    // ✅ REQUIRED: Constructor used by TEST CASES
    public ClashRecord(
            Long id,
            Long branchId1,
            Long branchId2,
            String eventName1,
            String eventName2,
            String clashType,
            LocalDateTime loggedAt,
            Boolean resolved
    ) {
        this.id = id;
        this.branchId1 = branchId1;
        this.branchId2 = branchId2;
        this.eventName1 = eventName1;
        this.eventName2 = eventName2;
        this.clashType = clashType;
        this.loggedAt = loggedAt;
        this.resolved = resolved;
    }

    // -------- GETTERS & SETTERS --------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBranchId1() {
        return branchId1;
    }

    public void setBranchId1(Long branchId1) {
        this.branchId1 = branchId1;
    }

    public Long getBranchId2() {
        return branchId2;
    }

    public void setBranchId2(Long branchId2) {
        this.branchId2 = branchId2;
    }

    public Long getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(Long calendarId) {
        this.calendarId = calendarId;
    }

    public String getEventName1() {
        return eventName1;
    }

    public void setEventName1(String eventName1) {
        this.eventName1 = eventName1;
    }

    public String getEventName2() {
        return eventName2;
    }

    public void setEventName2(String eventName2) {
        this.eventName2 = eventName2;
    }

    public String getClashType() {
        return clashType;
    }

    public void setClashType(String clashType) {
        this.clashType = clashType;
    }

    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }

    public void setLoggedAt(LocalDateTime loggedAt) {
        this.loggedAt = loggedAt;
    }

    public Boolean getResolved() {
        return resolved;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }
}
