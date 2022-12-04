package com.georgeifrim.JpaEntityRelations.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.georgeifrim.JpaEntityRelations.controller.dto.StudentDto;
import com.georgeifrim.JpaEntityRelations.controller.dto.SubjectDto;
import lombok.Getter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "student_subject",
            joinColumns = @JoinColumn (name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private Set<Subject> subjectsEnrolled = new HashSet<>();


    public void enrollSubject(Subject subject) {
        subjectsEnrolled.add(subject);
        subject.getStudentsEnrolled().add(this);
    }

    public StudentDto toDomain(){
        var listOfEnrolledSubjects = getSubjectsEnrolled().stream()
                .map(Subject::toDomain)
                .collect(Collectors.toList());

        return StudentDto.builder()
                .id(id)
                .name(name)
                .subjectsEnrolled(listOfEnrolledSubjects)
                .build();
    }


}
