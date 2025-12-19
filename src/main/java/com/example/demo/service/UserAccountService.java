package com.example.demo.service;

package com.example.demo.service;

import com.example.demo.entity.HarmonizedCalendar; 
import jakarta.persistence.Service;

@Service
public interface UserAccountService {
    public UserAccount register(UserAccount user);
    public UserAccount gertUser(Long id);
    public UserAccount getAllUsers();
    public UserAccount findByEmail(String email)
}