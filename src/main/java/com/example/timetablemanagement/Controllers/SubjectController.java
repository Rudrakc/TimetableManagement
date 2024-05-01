package com.example.timetablemanagement.Controllers;

import com.example.timetablemanagement.DTOs.TimetableEntryDto;
import com.example.timetablemanagement.Services.SubjectService;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping("/subject/{id}")
    public void updateSubject(@PathVariable("id") Long id, @RequestBody TimetableEntryDto timetableEntryDto) {
        subjectService.updateSubject(id, timetableEntryDto);
    }

    @DeleteMapping("/subject/{id}")
    public void deleteSubject(@PathVariable("id") Long id) {
        subjectService.deleteSubject(id);
    }
}
