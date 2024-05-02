package com.example.timetablemanagement.Controllers;

import com.example.timetablemanagement.DTOs.TimetableEntryDto;
import com.example.timetablemanagement.Models.Subject;
import com.example.timetablemanagement.Services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    public SubjectController(SubjectService subjectService){
        this.subjectService = subjectService;
    }

    @GetMapping("/subject/{id}")
    public ResponseEntity<?> getSubject(@PathVariable("id") Long id) {
        Subject subject = subjectService.getSubject(id);
        if(subject == null){
            return  new ResponseEntity<>("No Subjecct Exits with the given id", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(subject, HttpStatus.OK);

    }
    @GetMapping("/subject/timetalbe/{id}")
    public List<TimetableEntryDto> getAllEntries(@PathVariable("id") Long id) {
        return subjectService.getAllEntries(id);
    }
    @PutMapping("/subject/{id}")
    public ResponseEntity<?> updateSubject( @RequestBody Subject subject) {
        return subjectService.updateSubject(subject);
    }

    @DeleteMapping("/subject/{id}")
    public void deleteSubject(@PathVariable("id") Long id) {
        subjectService.deleteSubject(id);
    }
}
