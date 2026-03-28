package com.airtribe.learntrack.service;
import java.util.ArrayList;
import java.util.List;
import com.airtribe.learntrack.exception.EntityNotFoundException;

import com.airtribe.learntrack.entity.Enrollment;

public class EnrollmentService {

    private List<Enrollment> enrollments = new ArrayList<>();
    private StudentService studentService;
    private CourseService courseService;
    
	public EnrollmentService(StudentService studentService, CourseService courseService) {
		super();
		this.studentService = studentService;
		this.courseService = courseService;
	}

	public void enrollStudent(Enrollment enrollment) {

	    try {
	        
	        studentService.findStudentById(enrollment.getStudentId());

	        courseService.findCourseById(enrollment.getCourseId());

	        enrollments.add(enrollment);
	        System.out.println(" Student enrolled successfully!");

	    } catch (EntityNotFoundException e) {
	        System.out.println(" " + e.getMessage());
	    }
	}
	public void viewEnrollmentsByStudent(int studentId) {

	    boolean found = false;

	    for (Enrollment e : enrollments) {
	        if (e.getStudentId() == studentId) {
	            System.out.println(e);
	            found = true;
	        }
	    }

	    if (!found) {
	        System.out.println("No enrollments found for this student.");
	    }
	}
	public void updateEnrollmentStatus(int enrollmentId, String status) {

	    for (Enrollment e : enrollments) {
	        if (e.getId() == enrollmentId) {
	            e.setStatus(status);
	            System.out.println(" Enrollment status updated.");
	            return;
	        }
	    }

	    System.out.println(" Enrollment not found.");
	}
}
