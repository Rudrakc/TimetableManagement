package com.example.timetablemanagement.Services;

import com.example.timetablemanagement.Models.Classroom;
import com.example.timetablemanagement.Models.Subject;
import com.example.timetablemanagement.Models.TimeSlot;
import com.example.timetablemanagement.Models.TimetableEntry;
import com.example.timetablemanagement.Repositories.ClassroomRepo;
import com.example.timetablemanagement.Repositories.SubjectRepo;
import com.example.timetablemanagement.Repositories.TimeSlotRepo;
import com.example.timetablemanagement.Repositories.TimetableEntryRepo;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

@Service
public class SelfService implements TimetableService{
    private TimetableEntryRepo timetableEntryRepo;
    private TimeSlotRepo timeSlotRepo;
    private SubjectRepo subjectRepo;
    private ClassroomRepo classroomRepo;

    public SelfService(TimetableEntryRepo timetableEntryRepo, TimeSlotRepo timeSlotRepo, SubjectRepo subjectRepo, ClassroomRepo classroomRepo) {
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
        List<TimetableEntry> timetableEntryList = subject.getTimetableEntryList();
        timetableEntryList.add(timetableEntry);

        //Saving TimeSlot
        TimeSlot timeSlot = timeSlotRepo.save((timetableEntry.getTimeSlot()));

        //Saving Classroom
        Optional<Classroom> optionalClassroom = classroomRepo.findByName(timetableEntry.getClassroom().getStandard(), timetableEntry.getClassroom().getSection());
        if(optionalClassroom.isEmpty()){
            classroomRepo.save(timetableEntry.getClassroom());
        }
        Classroom classroom =  classroomRepo.findByName(timetableEntry.getClassroom().getStandard(), timetableEntry.getClassroom().getSection()).get();
        List<TimetableEntry> classroomEntryList = classroom.getTimetableEntryList();
        classroomEntryList.add(timetableEntry);

        timetableEntry.setClassroom(classroom);
        timetableEntry.setSubject(subject);
        timetableEntry.setTimeSlot(timeSlot);

        return timetableEntryRepo.save(timetableEntry);
    }
}
