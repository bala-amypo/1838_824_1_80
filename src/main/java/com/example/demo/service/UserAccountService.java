package com.example.demo.service;

import com.example.demo.entity.HarmonizedCalendar; 



public interface UserAccountService {
    public UserAccount register(UserAccount user);
    public UserAccount gertUser(Long id);
    public List<UserAccount> getAllUsers();
    public UserAccount findByEmail(String email);
    public UserAccount updateUser(Long id, UserAccount user);

    void deleteUser(Long id);
}