package com.example.timetablemanagement.Controllers;

import com.example.timetablemanagement.Models.Classroom;
import com.example.timetablemanagement.Services.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClassRoomController {

    @Autowired
    private ClassRoomService classRoomService;

    public ClassRoomController(ClassRoomService classRoom) {
        this.classRoomService = classRoom;
    }


    //Here we will fetch all the class rooms
    @GetMapping("/classroom")
    public String getClassRoom() {
        return "We will fetch all the class rooms soon!";
    }

    //Here We will Fetch the class room by id
    @GetMapping("/classroom/{id}")
    public ResponseEntity<Object> getClassRoomById(Long id) {
        Classroom classroom =  classRoomService.getClassRoomById(id);
        if (classroom != null) {
            return new ResponseEntity<>(classroom, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new String("Classroom not found"), HttpStatus.NOT_FOUND);
        }
    }



    //Here we will create a class room
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