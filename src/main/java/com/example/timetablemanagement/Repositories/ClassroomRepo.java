package com.example.timetablemanagement.Repositories;

import com.example.timetablemanagement.Models.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassroomRepo extends JpaRepository<Classroom, Long> {

    @Override
    Optional<Classroom> findById(Long id);

    @Override
    Classroom save(Classroom classroom);
}
