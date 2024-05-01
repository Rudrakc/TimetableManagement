package com.example.timetablemanagement.Services;

import com.example.timetablemanagement.DTOs.TimetableEntryDto;
import com.example.timetablemanagement.Models.TimetableEntry;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TimetableService {
    TimetableEntry createTimetableEntry(TimetableEntry timetableEntry);

    ResponseEntity<?> getTimetableEntry(Long id);

    List<TimetableEntryDto> getAllTimetableEntries();

    ResponseEntity<?> deleteTimetableEntry(Long id);

    ResponseEntity<?> updateTimetableEntry( TimetableEntry timetableEntry);

}
