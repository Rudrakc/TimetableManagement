package com.example.timetablemanagement.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int standard;
    private String section;
    @OneToOne
    private Teacher classTeacher;
    @OneToOne
    private Timetable timetable;
}
