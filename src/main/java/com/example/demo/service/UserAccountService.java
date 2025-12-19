package com.example.demo.service;

import com.example.demo.entity.HarmonizedCalendar; 



public interface UserAccountService {
    public UserAccount register(UserAccount user);
    public UserAccount gertUser(Long id);
    public UserAccount getAllUsers();
    public UserAccount findByEmail(String email);
}