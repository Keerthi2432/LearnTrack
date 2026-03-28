package com.airtribe.learntrack.service;
import java.util.ArrayList;
import java.util.List;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;

public class StudentService {

    private List<Student> students = new ArrayList<>();
    
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }
    
    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student s : students) {
            System.out.println(s);
        }
    }
    
    public Student findStudentById(int id) throws EntityNotFoundException {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        throw new EntityNotFoundException("Student not found with ID: " + id);
    }
    
    public void deactivateStudent(int id) {
        try {
            Student student = findStudentById(id);

            student.setActive(false);
            System.out.println(" Student deactivated.");

        } catch (EntityNotFoundException e) {
            System.out.println(" " + e.getMessage());
        }
    }
    
    }
