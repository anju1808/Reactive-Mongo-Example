package com.ust.course_service.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.course_service.model.Course;
import com.ust.course_service.repository.CourseRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// import reactor.core.publisher.Flux;
// import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping
    public Mono<Course> addCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    @GetMapping("/{id}")
    public Mono<Course> getCourse(@PathVariable Long id) {
        return courseRepository.findById(id);
    }

    @GetMapping
    public Flux<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}