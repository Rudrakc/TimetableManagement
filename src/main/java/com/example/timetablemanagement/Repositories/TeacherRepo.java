package com.example.timetablemanagement.Repositories;

import com.example.timetablemanagement.Models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {

        @Override
        Teacher save(Teacher teacher);

        @Override
        Optional<Teacher> findById(Long id);
}
