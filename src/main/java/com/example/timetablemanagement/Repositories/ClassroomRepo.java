package com.example.timetablemanagement.Repositories;

import com.example.timetablemanagement.Models.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassroomRepo extends JpaRepository<Classroom, Long> {

    @Override
    Optional<Classroom> findById(Long id);

    @Override
    Classroom save(Classroom classroom);

    @Query("SELECT s FROM Classroom s WHERE s.standard = ?1 AND s.section = ?2")
    Optional<Classroom> findByName(int standard, String section);

    @Override
    void deleteById(Long id);
}
