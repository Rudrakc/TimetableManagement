package com.example.timetablemanagement.Models;

import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.ls.LSInput;

import java.util.List;
import java.util.Map;
@Getter
@Setter
public class Timetable {
    private Long id;
    private Map<daysOfWeek, List<TimetableEntry>> timetableEntryMap;
    private Classroom classroom;

}


