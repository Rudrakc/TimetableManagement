package com.example.timetablemanagement.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Classroom {
    private Long id;
    private int standard;
    private String section;
    private Teacher classTeacher;
    private Timetable timetable;
}
