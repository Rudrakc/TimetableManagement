package com.example.timetablemanagement.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.ls.LSInput;

import java.util.List;
import java.util.Map;
@Getter
@Setter
@Entity
public class Timetable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    private List<TimetableEntry> timetableEntryList;
    @OneToOne
    private Classroom classroom;

}


