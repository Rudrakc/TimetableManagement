package com.example.timetablemanagement.Services;

import com.example.timetablemanagement.Models.Classroom;

public interface ClassRoomService {
    Classroom createClassRoom(Integer standarad, String section);

    Classroom getClassRoomByName(Integer standard,String section);

    Classroom getClassRoomById(Long id);

    boolean deleteClassRoomById(Long id);
}
