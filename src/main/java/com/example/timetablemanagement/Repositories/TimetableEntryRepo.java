package com.example.timetablemanagement.Repositories;

import com.example.timetablemanagement.Models.TimetableEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TimetableEntryRepo extends JpaRepository<TimetableEntry, Long> {
    @Override
    TimetableEntry save(TimetableEntry timetableEntry);

    @Override
    Optional<TimetableEntry> findById(Long id);
}
