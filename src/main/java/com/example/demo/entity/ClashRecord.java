package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ClashRecord {
    
    @Id
    private Long id;
    private Long eventAId;
    private Long eventBId;
    private String clashType;
    
}