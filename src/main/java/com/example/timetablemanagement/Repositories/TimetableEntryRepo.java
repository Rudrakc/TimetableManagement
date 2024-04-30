package com.example.timetablemanagement.Repositories;

import com.example.timetablemanagement.Models.TimetableEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimetableEntryRepo extends JpaRepository<TimetableEntry, Long> {
}
