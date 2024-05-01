package com.example.timetablemanagement.Services;

import com.example.timetablemanagement.DTOs.TimetableEntryDto;
import com.example.timetablemanagement.Models.Classroom;
import com.example.timetablemanagement.Models.TimetableEntry;
import com.example.timetablemanagement.Repositories.ClassroomRepo;
import com.example.timetablemanagement.Repositories.TimetableEntryRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClassRoomServiceMySql implements ClassRoomService{

    private ClassroomRepo classroomRepo;
    private TimetableEntryRepo timetableEntryRepo;
    public ClassRoomServiceMySql(ClassroomRepo classroomRepo,TimetableEntryRepo timetableEntryRepo){
        this.classroomRepo = classroomRepo;
        this.timetableEntryRepo = timetableEntryRepo;
    }

    @Override
    public Classroom createClassRoom(Integer standard, String section) {
        Classroom classroom = new Classroom();
        classroom.setStandard(standard);
        classroom.setSection(section);
        return classroomRepo.save(classroom);
    }

    @Override
    public Classroom getClassRoomByName(Integer standard, String section) {
        Optional<Classroom> classroom = classroomRepo.findByName(standard, section);
        return classroom.orElse(null);
    }

    @Override
    public Classroom getClassRoomById(Long id) {
        Optional<Classroom> classroom = classroomRepo.findById(id);
        return classroom.orElse(null);
    }

    @Override
    public boolean deleteClassRoomById(Long id) {
        Optional<Classroom> classroom = classroomRepo.findById(id);
        if(classroom.isPresent()) {
            classroomRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<TimetableEntryDto> getTimetableEnteries(Long id){
        List<TimetableEntry> timetableEntryList =  timetableEntryRepo.getTimetableEntriesByClassroom_Id(id);
        List<TimetableEntryDto> response = new ArrayList<>();
        for(TimetableEntry entry : timetableEntryList) {
            response.add(new TimetableEntryDto(entry));
        }
        return response;
    }

}
