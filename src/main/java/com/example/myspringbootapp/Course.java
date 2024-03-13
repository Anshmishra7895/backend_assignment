package com.example.myspringbootapp.course;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String subject;
    private int chapters;
    private String type;
    private String learnMode;

    // Constructors, getters, and setters

    public Course() {
    }

    public Course(String name, String subject, int chapters, String type, String learnMode) {
        this.name = name;
        this.subject = subject;
        this.chapters = chapters;
        this.type = type;
        this.learnMode = learnMode;
    }

    // Getters and setters
}
