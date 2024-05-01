package com.example.timetablemanagement.Services;

import com.example.timetablemanagement.Models.Classroom;
import com.example.timetablemanagement.Repositories.ClassroomRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassRoomServiceMySql implements ClassRoomService{

    private ClassroomRepo classroomRepo;
    public ClassRoomServiceMySql(ClassroomRepo classroomRepo){
        this.classroomRepo = classroomRepo;
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
        if(classroom.isPresent()){
            return classroom.get();
        }
        return null;
    }

    @Override
    public Classroom getClassRoomById(Long id) {
        Optional<Classroom> classroom = classroomRepo.findById(id);
        if(classroom.isPresent()) {
            return classroom.get();
        }
        return null;
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

}
