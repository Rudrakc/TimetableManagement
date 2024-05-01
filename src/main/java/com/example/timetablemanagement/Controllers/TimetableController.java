package com.example.timetablemanagement.Controllers;

import com.example.timetablemanagement.Models.Timetable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimetableController {

    @GetMapping("/timetable")
    public Timetable getTimetable(Long id) {
        return null;
    }


    @PostMapping("/timetable")
    public ResponseEntity<Timetable> createTimetable(@RequestBody Timetable timetable) {
        System.out.println("Creating timetable");
        return null;
    }

}
