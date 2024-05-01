package com.example.timetablemanagement.Controllers;

import com.example.timetablemanagement.Models.Timetable;
import com.example.timetablemanagement.Models.TimetableEntry;
import com.example.timetablemanagement.Services.TimetableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/timetable")
public class TimetableController {

    private TimetableService timetableService;

    public TimetableController(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    @GetMapping("")
    public Timetable getTimetable(Long id) {
//        System.out.println("Creating timetable");
        return null;
    }


    @PostMapping("")
    public ResponseEntity<TimetableEntry> createTimetableEntry(@RequestBody TimetableEntry timetableEntry) {
        System.out.println("Creating timetable");
        return timetableService.createTimetableEntry(timetableEntry);
    }

}
