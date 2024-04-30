package com.example.timetablemanagement.Models;

import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.ls.LSException;

import java.util.List;
@Getter
@Setter
public class Subject {
    private Long id;
    private String name;
    private List<TimetableEntry> timetableEntryList;
    private Teacher teacher;

}
