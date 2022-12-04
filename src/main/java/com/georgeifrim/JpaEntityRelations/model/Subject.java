package com.georgeifrim.JpaEntityRelations.model;

import com.georgeifrim.JpaEntityRelations.controller.dto.SubjectDto;
import lombok.Getter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    private String name;

//    @JsonIgnore
    @ManyToMany(mappedBy = "subjectsEnrolled")
    private Set<Student> studentsEnrolled = new HashSet<>();




//    public void enrollStudent(Student student) {
//        studentiInrolati.add(student);
//    }

    public SubjectDto toDomain(){
        var listOfEnrolledStudents = studentsEnrolled.stream()
                .map(Student::toDomain)
                .collect(Collectors.toList());

        return SubjectDto.builder()
                .id(id)
                .name(name)
                .studentsEnrolled(listOfEnrolledStudents)
                .build();
    }
}
