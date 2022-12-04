package com.georgeifrim.JpaEntityRelations.controller;

import com.georgeifrim.JpaEntityRelations.controller.dto.SubjectDto;
import com.georgeifrim.JpaEntityRelations.model.Subject;
import com.georgeifrim.JpaEntityRelations.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    SubjectRepository subjectRepository;


    @GetMapping
    List<SubjectDto> getSubjects(){
        return subjectRepository.findAll()
                .stream()
                .map(Subject::toDomain)
                .collect(Collectors.toList());
    }

    @PostMapping
    SubjectDto createSubject(@RequestBody Subject subject){
        Subject saved = subjectRepository.save(subject);
        return saved.toDomain();

    }

//    @PutMapping("{subjectId}/student/{studentId}")
//    SubjectDto enroll


}

