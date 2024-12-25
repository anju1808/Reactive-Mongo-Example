package com.ust.course_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "course")
public class Course {
    @Id
    private long id;
    private String name;
    private String description;

    // Constructors, Getters, and Setters
}