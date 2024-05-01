package com.example.timetablemanagement.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Entity
public class TimeSlot {
    private daysOfWeek day;
    private String startTime;
    private String endTime;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


}
