package com.example.timetablemanagement.Controllers;

import com.example.timetablemanagement.DTOs.TimetableEntryDto;
import com.example.timetablemanagement.Models.Classroom;
import com.example.timetablemanagement.Models.TimetableEntry;
import com.example.timetablemanagement.Services.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClassRoomController {

    @Autowired
    private ClassRoomService classRoomService;

    public ClassRoomController(ClassRoomService classRoom) {
        this.classRoomService = classRoom;
    }


    //Here we will fetch all the classrooms
    @GetMapping("/classroom")
    public String getClassRoom() {
        return "We will fetch all the class rooms soon!";
    }

    //Here We will Fetch the classroom by id
    @GetMapping("/classroom/{id}")
    public ResponseEntity<Object> getClassRoomById(@PathVariable("id") Long id) {
        Classroom classroom =  classRoomService.getClassRoomById(id);
        if (classroom != null) {
            return new ResponseEntity<>(classroom, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new String("Classroom not found"), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/classroom/timetable/{id}")
    public List<TimetableEntryDto> getTimetableEnteries(@PathVariable("id") Long id) {
        return classRoomService.getTimetableEnteries(id);
    }



    //Here we will create a classroom
    // also define the request body
    // creating a good object for that
    @PostMapping("/classroom")
    public ResponseEntity<Object> createClassroom(@RequestBody Classroom classroom) {
        System.out.println("Creating classroom");
        System.out.println(classroom.toString());

        // Validation: Check for required fields
        if (classroom.getStandard() == null || classroom.getSection() == null) {
            return new ResponseEntity<>(new String("Standard and Section must be provided"), HttpStatus.BAD_REQUEST);
        }

        Classroom savedClassroom = classRoomService.createClassRoom(classroom.getStandard(),classroom.getSection());

        // Handle successful creation or potential errors
        if (savedClassroom != null) {
            return new ResponseEntity<>(savedClassroom, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new String("Error creating classroom"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}