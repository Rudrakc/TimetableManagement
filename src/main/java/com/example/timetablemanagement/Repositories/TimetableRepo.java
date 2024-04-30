package com.example.timetablemanagement.Repositories;

import com.example.timetablemanagement.Models.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimetableRepo extends JpaRepository<Timetable, Long> {
}
