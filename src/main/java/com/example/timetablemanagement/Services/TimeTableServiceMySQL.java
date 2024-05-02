package com.example.timetablemanagement.Services;

import com.example.timetablemanagement.DTOs.TimetableEntryDto;
import com.example.timetablemanagement.Models.Classroom;
import com.example.timetablemanagement.Models.Subject;
import com.example.timetablemanagement.Models.TimeSlot;
import com.example.timetablemanagement.Models.TimetableEntry;
import com.example.timetablemanagement.Repositories.ClassroomRepo;
import com.example.timetablemanagement.Repositories.SubjectRepo;
import com.example.timetablemanagement.Repositories.TimeSlotRepo;
import com.example.timetablemanagement.Repositories.TimetableEntryRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TimeTableServiceMySQL implements TimetableService{
    private TimetableEntryRepo timetableEntryRepo;
    private TimeSlotRepo timeSlotRepo;
    private SubjectRepo subjectRepo;
    private ClassroomRepo classroomRepo;

    public TimeTableServiceMySQL(TimetableEntryRepo timetableEntryRepo, TimeSlotRepo timeSlotRepo, SubjectRepo subjectRepo, ClassroomRepo classroomRepo) {
        this.classroomRepo = classroomRepo;
        this.subjectRepo = subjectRepo;
        this.timeSlotRepo = timeSlotRepo;
        this.timetableEntryRepo = timetableEntryRepo;
    }

    @Override
    public TimetableEntry createTimetableEntry(TimetableEntry timetableEntry) {
        // Saving Subject
        Optional<Subject> optionalSubject = subjectRepo.findByName(timetableEntry.getSubject().getName());
        if(optionalSubject.isEmpty()) {
            subjectRepo.save(timetableEntry.getSubject());
        }
        Subject subject = subjectRepo.findByName(timetableEntry.getSubject().getName()).get();


        //Saving TimeSlot
        TimeSlot timeSlot = timeSlotRepo.save((timetableEntry.getTimeSlot()));

        //Saving Classroom
        Optional<Classroom> optionalClassroom = classroomRepo.findByName(timetableEntry.getClassroom().getStandard(), timetableEntry.getClassroom().getSection());
        if(optionalClassroom.isEmpty()){
            classroomRepo.save(timetableEntry.getClassroom());
        }
        Classroom classroom =  classroomRepo.findByName(timetableEntry.getClassroom().getStandard(), timetableEntry.getClassroom().getSection()).get();

        timetableEntry.setClassroom(classroom);
        timetableEntry.setSubject(subject);
        timetableEntry.setTimeSlot(timeSlot);

        return timetableEntryRepo.save(timetableEntry);
    }

    @Override
    public ResponseEntity<Object> getTimetableEntry(Long id) {
        Optional<TimetableEntry> timetableEntry = timetableEntryRepo.findById(id);
        if(timetableEntry.isEmpty()) {
            return new ResponseEntity<>("Timetable Entry not found", HttpStatus.NOT_FOUND);
        }
        TimetableEntryDto response = new TimetableEntryDto(timetableEntry.get());
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(200));
    }

    @Override
    public List<TimetableEntryDto> getAllTimetableEntries() {
        List<TimetableEntry> timetableEntryList = timetableEntryRepo.findAll();
        List<TimetableEntryDto> response =  new ArrayList<>();
        for(TimetableEntry entry : timetableEntryList) {
            response.add(new TimetableEntryDto(entry));
        }
        return response;
    }

    public ResponseEntity<Object> deleteTimetableEntry(Long id) {
        if(timetableEntryRepo.findById(id).isEmpty()) {
            return new ResponseEntity<>("Timetable Entry not found", null, 404);
        }
        timetableEntryRepo.deleteById(id);
        return new ResponseEntity<>("Timetable Entry deleted", null, 200);
    }


    public ResponseEntity<Object> updateTimetableEntry(TimetableEntry timetableEntry) {
        Optional<TimetableEntry> optionalTimetableEntry = timetableEntryRepo.findById(timetableEntry.getId());

        if(optionalTimetableEntry.isEmpty()) {
            return new ResponseEntity<>("Timetable Entry not found", HttpStatus.NOT_FOUND);
        }

        TimetableEntry existingTimetableEntry = optionalTimetableEntry.get();

        if(timetableEntry.getSubject()!=null) {
            existingTimetableEntry.setSubject(timetableEntry.getSubject());
        }
        if(timetableEntry.getTimeSlot()!=null) {
            existingTimetableEntry.setTimeSlot(timetableEntry.getTimeSlot());
        }
        if(timetableEntry.getClassroom()!=null) {
            existingTimetableEntry.setClassroom(timetableEntry.getClassroom());
        }

        try {
            timetableEntryRepo.save(existingTimetableEntry);
        } 
        catch (Exception e) {
            return new ResponseEntity<>("Error updating timetable entry", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(existingTimetableEntry, HttpStatus.OK);
    }

}
