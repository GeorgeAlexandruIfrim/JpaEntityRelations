package com.georgeifrim.JpaEntityRelations.repository;

import com.georgeifrim.JpaEntityRelations.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
