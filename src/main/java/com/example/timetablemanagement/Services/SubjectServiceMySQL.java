package com.example.timetablemanagement.Services;

import com.example.timetablemanagement.DTOs.TimetableEntryDto;
import com.example.timetablemanagement.Models.TimetableEntry;
import com.example.timetablemanagement.Repositories.TimetableEntryRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SubjectServiceMySQL implements SubjectService {
    private TimetableEntryRepo timetableEntryRepo;

    public SubjectServiceMySQL(TimetableEntryRepo timetableEntryRepo) {
        this.timetableEntryRepo = timetableEntryRepo;
    }
    @Override
    public List<TimetableEntryDto> getTimetableEnteries(Long id) {
        List<TimetableEntry> timetableEntryList = timetableEntryRepo.getTimetableEntriesBySubject_Id(id);
        List<TimetableEntryDto> response = new ArrayList<>();
        for(TimetableEntry entry : timetableEntryList) {
            response.add(new TimetableEntryDto(entry));
        }
        return response;
    }
}
