package com.georgeifrim.JpaEntityRelations.repository;

import com.georgeifrim.JpaEntityRelations.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Integer> {
}
