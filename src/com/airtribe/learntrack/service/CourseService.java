package com.airtribe.learntrack.service;
import java.util.ArrayList;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import java.util.List;

import com.airtribe.learntrack.entity.Course;

public class CourseService {

    private List<Course> courses = new ArrayList<>();
    public void addCourse(Course course) {
        courses.add(course);
        System.out.println(" Course added successfully!");
    }
    public void viewAllCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }

        for (Course c : courses) {
            System.out.println(c);
        }
    }
    public Course findCourseById(int id) throws EntityNotFoundException {
        for (Course c : courses) {
            if (c.getId() == id) {
                return c;
            }
        }
        throw new EntityNotFoundException("Course not found with ID: " + id);
    }
    public void toggleCourseStatus(int id) {
        try {
            Course course = findCourseById(id);

            course.setActive(!course.isActive());
            System.out.println(" Course status updated.");

        } catch (EntityNotFoundException e) {
            System.out.println(" " + e.getMessage());
        }
    }
}
