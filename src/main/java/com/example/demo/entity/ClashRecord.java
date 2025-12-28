package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ClashRecord {

    @Id @GeneratedValue
    private Long id;
    private Long eventAId;
    private Long eventBId;
    private String clashType;
    private String severity;
    private String remarks;
    private LocalDateTime detectedAt;
    private Boolean resolved;

    public ClashRecord(){}

    public ClashRecord(Long id,Long a,Long b,String type,
                       String sev,String r,LocalDateTime d,Boolean res){
        this.id=id; this.eventAId=a; this.eventBId=b;
        this.clashType=type; this.severity=sev;
        this.remarks=r; this.detectedAt=d; this.resolved=res;
    }

    @PrePersist
    public void prePersist(){
        detectedAt = LocalDateTime.now();
        if(resolved==null) resolved=false;
    }

    public Boolean getResolved(){return resolved;}
    public void setResolved(Boolean r){this.resolved=r;}
}
