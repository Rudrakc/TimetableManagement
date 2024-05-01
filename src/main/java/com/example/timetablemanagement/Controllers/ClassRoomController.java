package com.example.timetablemanagement.Controllers;

import com.example.timetablemanagement.Services.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClassRoomController {

    @Autowired
    private ClassRoomService classRoomService;

    public ClassRoomController(ClassRoomService classRoom) {
        this.classRoomService = classRoom;
    }


}