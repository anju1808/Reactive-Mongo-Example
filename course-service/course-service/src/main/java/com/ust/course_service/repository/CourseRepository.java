package com.ust.course_service.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
// import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.ust.course_service.model.Course;

@Repository
public interface CourseRepository extends ReactiveMongoRepository<Course, Long> {
    
}
