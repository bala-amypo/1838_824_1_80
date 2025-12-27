package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String storeName;

    private String address;
    private String region;

    @Column(nullable = false)
    private boolean active = true;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStoreName() { return storeName; }
    public void setStoreName(String storeName) { this.storeName = storeName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
