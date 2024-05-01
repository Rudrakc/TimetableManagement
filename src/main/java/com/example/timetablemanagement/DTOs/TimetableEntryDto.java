package com.example.timetablemanagement.DTOs;
import com.example.timetablemanagement.Models.TimetableEntry;
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

    public TimetableEntryDto(String day, String subjectName, String teacherName, String timeSlot, String classroom) {
        this.day = day;
        this.subjectName = subjectName;
        this.teacherName = teacherName;
        this.timeSlot = timeSlot;
        this.classroom = classroom;
    }

    public TimetableEntryDto() {
    }

    public TimetableEntryDto(TimetableEntry timetableEntry) {
        TimetableEntryDto timetableEntryDto = this;
        timetableEntryDto.day = (String.valueOf(timetableEntry.getDay()));
        timetableEntryDto.subjectName = (timetableEntry.getSubject().getName());
        timetableEntryDto.teacherName = (timetableEntry.getSubject().getTeacherName());
        timetableEntryDto.timeSlot = (timetableEntry.getTimeSlot().getStartTime()+" - "+timetableEntry.getTimeSlot().getEndTime());
        timetableEntryDto.classroom = (timetableEntry.getClassroom().getStandard() + timetableEntry.getClassroom().getSection());
    }
}
