package com.example.timetablemanagement.Repositories;

import com.example.timetablemanagement.Models.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TimetableRepo extends JpaRepository<Timetable, Long> {
    @Override
    Timetable save(Timetable timetable);

    @Override
    Optional<Timetable> findById(Long id);
}
