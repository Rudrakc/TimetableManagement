package com.example.timetablemanagement.Repositories;

import com.example.timetablemanagement.Models.Subject;
import lombok.Lombok;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepo extends JpaRepository<Subject, Long> {
}
