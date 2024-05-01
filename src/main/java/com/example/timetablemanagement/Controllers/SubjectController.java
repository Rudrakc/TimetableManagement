package com.example.timetablemanagement.Controllers;

import com.example.timetablemanagement.DTOs.TimetableEntryDto;
import com.example.timetablemanagement.Services.SubjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubjectController {
    private SubjectService subjectService;
    public SubjectController(SubjectService subjectService){
        this.subjectService = subjectService;
    }

    @GetMapping("/subject/timetable/{id}")
    public List<TimetableEntryDto> getTimetableEnteries(@PathVariable("id") Long id) {
        return subjectService.getTimetableEnteries(id);
    }
}
