package com.example.timetablemanagement.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class TimetableEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private daysOfWeek day;
    @ManyToOne
    private Subject subject;
    @OneToOne
    private TimeSlot timeSlot;
    @OneToOne
    private Classroom classroom;


}
