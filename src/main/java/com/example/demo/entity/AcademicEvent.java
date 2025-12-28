package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.*;

@Entity
public class AcademicEvent {

    @Id @GeneratedValue
    private Long id;
    private Long branchId;
    private String title;
    private String eventType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String venue;
    private String description;
    private LocalDateTime submittedAt;

    public AcademicEvent(){}

    public AcademicEvent(Long id,Long branchId,String title,String eventType,
                         LocalDate start,LocalDate end,String venue,
                         String desc,LocalDateTime submittedAt){
        this.id=id; this.branchId=branchId; this.title=title;
        this.eventType=eventType; this.startDate=start; this.endDate=end;
        this.venue=venue; this.description=desc; this.submittedAt=submittedAt;
    }

    @PrePersist
    public void prePersist(){
        submittedAt = LocalDateTime.now();
    }

    // getters
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public Long getBranchId(){return branchId;}

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }
}
