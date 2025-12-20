package com.example.demo.repository;

import com.example.demo.entity.HarmonizedCalendar;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.time.LocalDate
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface HarmonizedCalendarRepository extends JpaRepository<HarmonizedCalendar, Long>{
    public List<HarmonizedCalendar> findByStartDateGreaterThanEqualAndEndDateLessThanEqual(LocalDate start, LocalDate end);
}