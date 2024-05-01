package com.example.timetablemanagement.Repositories;

import com.example.timetablemanagement.Models.Subject;
import lombok.Lombok;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectRepo extends JpaRepository<Subject, Long> {
    @Override
    Optional<Subject> findById(Long id);

    @Override
    Subject save(Subject subject);

    @Query("SELECT s from Subject s WHERE s.name = ?1")
    Optional<Subject> findByName(String name);
}
