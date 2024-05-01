package com.example.timetablemanagement.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.ls.LSException;

import java.util.List;
@Getter
@Setter
@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany
    private List<TimetableEntry> timetableEntryList;
    private String teacherName;

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", timetableEntryList=" + timetableEntryList +
                ", teacherName='" + teacherName + '\'' +
                '}';
    }
}
