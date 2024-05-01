package com.example.timetablemanagement.Services;

import com.example.timetablemanagement.DTOs.TimetableEntryDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface SubjectService {
    List<TimetableEntryDto> getTimetableEnteries( Long id);
}
