package com.georgeifrim.JpaEntityRelations.controller;

import com.georgeifrim.JpaEntityRelations.controller.dto.StudentDto;
import com.georgeifrim.JpaEntityRelations.controller.dto.SubjectDto;
import com.georgeifrim.JpaEntityRelations.model.Student;
import com.georgeifrim.JpaEntityRelations.model.Subject;
import com.georgeifrim.JpaEntityRelations.repository.StudentRepository;
import com.georgeifrim.JpaEntityRelations.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    SubjectRepository subjectRepository;

    @GetMapping
    List<StudentDto> getStudents(){
        return studentRepository.findAll().stream()
                .map(Student::toDomain)
                .collect(Collectors.toList());
    }

    @PostMapping
    StudentDto createStudent(@RequestBody Student student){
        Student saved = studentRepository.save(student);
        return saved.toDomain();
    }

    @PutMapping("/{studentId}/subjects/{subjectId}")
    StudentDto enrollSubjectToStudent(
            @PathVariable Integer studentId,
            @PathVariable Integer subjectId
    ){
        Subject subject = subjectRepository.findById(subjectId).get();
        Student student = studentRepository.findById(studentId).get();
        student.enrollSubject(subject);

        Student saved = studentRepository.save(student);

        List<SubjectDto> collect = saved.getSubjectsEnrolled().stream()
                .map(Subject::toDomain)
                .collect(Collectors.toList());

        return StudentDto.builder()
                .id(saved.getId())
                .name(saved.getName())
                .subjectsEnrolled(collect)
                .build();
    }
}
