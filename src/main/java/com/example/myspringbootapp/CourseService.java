package com.example.myspringbootapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long courseId) {
        return courseRepository.findById(courseId);
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Long courseId, Course updatedCourse) {
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        if (optionalCourse.isPresent()) {
            Course existingCourse = optionalCourse.get();
            existingCourse.setName(updatedCourse.getName());
            existingCourse.setSubject(updatedCourse.getSubject());
            existingCourse.setChapters(updatedCourse.getChapters());
            existingCourse.setType(updatedCourse.getType());
            existingCourse.setLearnMode(updatedCourse.getLearnMode());
            return courseRepository.save(existingCourse);
        } else {
            // Handle the case where the course with courseId is not found
            // You can throw an exception or handle it based on your application's logic.
            return null;
        }
    }

    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }
}
