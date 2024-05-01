package com.example.timetablemanagement.Controllers;

import com.example.timetablemanagement.DTOs.TimetableEntryDto;
import com.example.timetablemanagement.Models.Timetable;
import com.example.timetablemanagement.Models.TimetableEntry;
import com.example.timetablemanagement.Services.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getTimetableById(@PathVariable("id") Long id) {
        return timetableService.getTimetableEntry(id);
    }


    @PostMapping("/timetable")
    public ResponseEntity<TimetableEntryDto> createTimetable(@RequestBody TimetableEntry timetable) {
        if(timetable == null) {
            return ResponseEntity.badRequest().build();
        }
        System.out.println("Creating timetable");
        System.out.println(timetable.toString());
        TimetableEntry timetableEntry =  timetableService.createTimetableEntry(timetable);
        TimetableEntryDto timetableEntryDto = new TimetableEntryDto(timetableEntry);
        ResponseEntity<TimetableEntryDto> responseEntity = new ResponseEntity<>(timetableEntryDto, HttpStatus.CREATED);

        return responseEntity;
    }

    //Updating an timetable entry
    @PutMapping("/timetable/{id}")
    public String updateTimetable(@PathVariable Long id, @RequestBody Timetable timetable) {

        return "We will update the timetable soon!";
    }


    //Deleting a timetable entry
    @DeleteMapping("/timetable/{id}")
    public ResponseEntity<?> deleteTimetable(@PathVariable Long id) {
        return timetableService.deleteTimetableEntry(id);
    }


}
