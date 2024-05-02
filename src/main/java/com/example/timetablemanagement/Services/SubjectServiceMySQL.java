package com.example.timetablemanagement.Services;

import com.example.timetablemanagement.DTOs.TimetableEntryDto;
import com.example.timetablemanagement.Models.Subject;
import com.example.timetablemanagement.Models.TimetableEntry;
import com.example.timetablemanagement.Repositories.SubjectRepo;
import com.example.timetablemanagement.Repositories.TimetableEntryRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceMySQL implements SubjectService {
    private SubjectRepo subjectRepo;
    private TimetableEntryRepo timetableEntryRepo;

    public SubjectServiceMySQL(SubjectRepo subjectRepo, TimetableEntryRepo timetableEntryRepo) {
        this.subjectRepo = subjectRepo;
        this.timetableEntryRepo = timetableEntryRepo;
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
    public List<TimetableEntryDto> getAllEntries(Long id) {
        List<TimetableEntry> timetableEntryList = timetableEntryRepo.getTimetableEntriesBySubject_Id(id);
        List<TimetableEntryDto> response = new ArrayList<>();
        for(TimetableEntry entry : timetableEntryList) {
            response.add(new TimetableEntryDto(entry));
        }
        return response;
    }

    @Override
    public void deleteSubject(Long id) {
        Optional<Subject> subject = subjectRepo.findById(id);
        subject.ifPresent(subjectRepo::delete);

    }
}
