package com.ust.students_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ust.students_service.dto.Webinar;
import com.ust.students_service.model.Student;
import com.ust.students_service.repository.StudentRepository;
import com.ust.students_service.service.WebinarService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private WebinarService webinarService;

    @GetMapping
    public String welcomeMessage() {
        return "Welcome to the Students API. Use /webinar/{webinarId} to fetch data.";
    }

    @GetMapping("/webinar/{webinarId}")
    public Mono<Webinar> getWebinarWithStudents(@PathVariable String webinarId) {
        return webinarService.getWebinarById(webinarId)
                .flatMap(webinar -> studentRepository.findByWebinarId(webinarId).collectList()
                        .map(students -> {
                            webinar.setStudents(students);
                            return webinar;
                        }));
    }

    // POST endpoint to add student details
    @PostMapping
    public Mono<Student> addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }
}
