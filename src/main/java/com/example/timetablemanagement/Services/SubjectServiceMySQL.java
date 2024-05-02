package com.example.timetablemanagement.Services;

import com.example.timetablemanagement.DTOs.TimetableEntryDto;
import com.example.timetablemanagement.Models.Subject;
import com.example.timetablemanagement.Models.TimetableEntry;
import com.example.timetablemanagement.Repositories.SubjectRepo;
import com.example.timetablemanagement.Repositories.TimetableEntryRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceMySQL implements SubjectService {
    private SubjectRepo subjectRepo;

    public SubjectServiceMySQL(SubjectRepo subjectRepo) {
        this.subjectRepo = subjectRepo;
    }
    @Override
    public Subject getSubject(Long id) {
        Optional<Subject> subject = subjectRepo.findById(id);
        if(subject.isEmpty()){
            return null;
        }
        return subject.get();
    }

    @Override
    public ResponseEntity<?> updateSubject(Subject subjects) {
        Optional<Subject> subject = subjectRepo.findById(subjects.getId());
            if(subject.isEmpty())return  new ResponseEntity<>("Subject not Found", HttpStatus.NOT_FOUND);
        Subject subjectUpdated = subjectRepo.save(subject.get());
        return new ResponseEntity<>(subjectUpdated,HttpStatus.OK);
    }

    @Override
    public void deleteSubject(Long id) {
//        Optional<Subject> subject =
    }
}
