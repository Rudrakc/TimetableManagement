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

    public enum daysOfWeek {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

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
