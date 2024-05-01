package com.example.timetablemanagement.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer standard;
    private String section;
    @OneToMany
    private List<TimetableEntry> timetableEntryList;
}
