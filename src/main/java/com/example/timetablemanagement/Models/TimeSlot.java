package com.example.timetablemanagement.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class TimeSlot {
    private Date startTime;
    private Date endTime;
}
