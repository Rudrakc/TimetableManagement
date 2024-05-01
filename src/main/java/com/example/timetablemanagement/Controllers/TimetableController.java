package com.example.timetablemanagement.Controllers;

import com.example.timetablemanagement.Models.Timetable;
import com.example.timetablemanagement.Services.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TimetableController {

    @Autowired
    private TimetableService timetableService;

    public TimetableController(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    //Here we will fetch all the time tables
    @GetMapping("/timetable")
    public String getTimetable(Long id) {
        return "We will fetch all the time tables soon!";
    }


    //Here We will Fetch the timetable by id
    @GetMapping("/timetable/{id}")
    public String getTimetableById(@PathVariable Long id) {
        return "We will fetch the timetable by id soon!";
    }


    //Here we will create a timetable
    // also define the request body
    // creating a good object for that
    @PostMapping("/timetable")
    public String createTimetable(@RequestBody Timetable timetable) {
        return "We will create a timetable soon!";
    }

    //Updating an timetable enty
    @PutMapping("/timetable/{id}")
    public String updateTimetable(@PathVariable Long id, @RequestBody Timetable timetable) {
        return "We will update the timetable soon!";
    }

    //Deleting a timetable entry
    @DeleteMapping("/timetable/{id}")
    public String deleteTimetable(@PathVariable Long id) {
        return "We will delete the timetable soon!";
    }

}
