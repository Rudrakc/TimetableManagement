package com.example.timetablemanagement.Services;

import com.example.timetablemanagement.Models.TimetableEntry;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SelfService implements TimetableService{


    @Override
    public ResponseEntity<TimetableEntry> createTimetableEntry(TimetableEntry timetableEntry) {
        return null;
    }
}
