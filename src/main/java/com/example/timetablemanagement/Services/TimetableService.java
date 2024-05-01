package com.example.timetablemanagement.Services;

import com.example.timetablemanagement.Models.TimetableEntry;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

public interface TimetableService {
    TimetableEntry createTimetableEntry(TimetableEntry timetableEntry);

    ResponseEntity<?> getTimetableEntry(Long id);

    ResponseEntity<?> getAllTimetableEntries();

    ResponseEntity<?> deleteTimetableEntry(Long id);

}
