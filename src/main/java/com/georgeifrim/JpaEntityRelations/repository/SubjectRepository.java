package com.georgeifrim.JpaEntityRelations.repository;

import com.georgeifrim.JpaEntityRelations.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
