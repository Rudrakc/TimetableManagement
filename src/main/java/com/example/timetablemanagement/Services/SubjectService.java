package com.example.timetablemanagement.Services;

import com.example.timetablemanagement.DTOs.TimetableEntryDto;
import com.example.timetablemanagement.Models.Subject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface SubjectService {
    Subject getSubject(Long id);

    ResponseEntity<?> updateSubject(Subject subject);
    List<TimetableEntryDto> getAllEntries(Long id);

    void deleteSubject(Long id);
}
