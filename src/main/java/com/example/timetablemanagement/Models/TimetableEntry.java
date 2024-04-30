package com.example.timetablemanagement.Models;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class TimetableEntry {
    private Long id;
    private daysOfWeek day;
    private Subject subject;
    private TimeSlot timeSlot;
    private Classroom classroom;


}
