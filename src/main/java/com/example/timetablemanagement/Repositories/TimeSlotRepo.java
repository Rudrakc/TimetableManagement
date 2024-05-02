package com.example.timetablemanagement.Repositories;

import com.example.timetablemanagement.Models.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TimeSlotRepo extends JpaRepository<TimeSlot, Long> {
    @Override
    Optional<TimeSlot> findById(Long aLong);

    @Override
    TimeSlot save(TimeSlot timeSlot);

}
