package com.example.timetablemanagement.DTOs;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimetableEntryDto {
    private String day;
    private String subjectName;
    private String teacherName;
    private String timeSlot;
    private String classroom;
}
