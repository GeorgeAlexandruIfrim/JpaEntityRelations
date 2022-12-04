package com.georgeifrim.JpaEntityRelations.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Value;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Value
@Builder
@JsonIgnoreProperties({"id, subjectsEnrolled"})
public class StudentDto {

//    public StudentDto(Integer id, String name, List<SubjectDto> subjectsEnrolled) {
//        this.id = id;
//        this.name = name;
//        this.subjectsEnrolled = subjectsEnrolled;
//    }
//    public StudentDto (String name){
//        this.name = name;
//    }
    Integer id;
    String name;
    List<SubjectDto> subjectsEnrolled;
}
