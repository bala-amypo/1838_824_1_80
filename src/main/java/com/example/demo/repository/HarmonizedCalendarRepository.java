package com.example.demo.repository;

import com.example.demo.entity.HarmonizedCalendar;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface HarmonizedCalendarRepository extends JpaRepository<HarmonizedCalendar, Long>{

}