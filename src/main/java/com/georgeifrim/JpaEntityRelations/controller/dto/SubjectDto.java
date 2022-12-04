package com.georgeifrim.JpaEntityRelations.controller.dto;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class SubjectDto {

//    public SubjectDto(Integer id, String name, List<StudentDto> studentsEnrolled) {
//        this.id = id;
//        this.name = name;
//        this.studentsEnrolled = studentsEnrolled;
//    }

    Integer id;
    String name;
    List<StudentDto> studentsEnrolled;
}
