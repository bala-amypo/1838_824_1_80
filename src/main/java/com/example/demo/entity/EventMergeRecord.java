package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.*;
import java.time.LocalDate;

@Entity
public class EventMergeRecord {

    @Id @GeneratedValue
    private Long id;
    private String sourceEventIds;
    private String mergedTitle;
    private LocalDate mergedStartDate;
    private LocalDate mergedEndDate;
    private String mergeReason;
    private LocalDateTime createdAt;

    public EventMergeRecord(){}

    public EventMergeRecord(Long id,String src,String title,
                            LocalDate s,LocalDate e,String reason,
                            LocalDateTime c){
        this.id=id; this.sourceEventIds=src; this.mergedTitle=title;
        this.mergedStartDate=s; this.mergedEndDate=e;
        this.mergeReason=reason; this.createdAt=c;
    }

    @PrePersist
    public void prePersist(){ createdAt = LocalDateTime.now(); }

    // getters setters
    public void setId(Long id){this.id=id;}
    public Long getId(){return id;}
    public String getSourceEventIds(){return sourceEventIds;}
}
