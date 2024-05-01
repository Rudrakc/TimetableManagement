package com.example.timetablemanagement.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class TimetableEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private daysOfWeek day;
    @ManyToOne
    private Subject subject;
    @OneToOne
    private TimeSlot timeSlot;
    @ManyToOne
    private Classroom classroom;


     public String toString() {
         return "TimetableEntry{" +
                 "id=" + id +
                 ", day=" + day +
                 ", subject=" + subject.toString() +
                 ", timeSlot=" + timeSlot +
                 ", classroom=" + classroom +
                 '}';
     }
}
