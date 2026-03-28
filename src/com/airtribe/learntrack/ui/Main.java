package com.airtribe.learntrack.ui;
import java.util.Scanner;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.util.IdGenerator;



public class Main {

	public static void main(String[] args) {
		System.out.println("Hello LearnTrack");
		
		StudentService studentService = new StudentService();
		CourseService courseService = new CourseService();
		EnrollmentService enrollmentService = new EnrollmentService(studentService, courseService);

		Scanner scanner = new Scanner(System.in);
		while (true) {

		    System.out.println("\n===== LearnTrack Menu =====");
		    System.out.println("1. Add Student");
		    System.out.println("2. View Students");
		    System.out.println("3. Add Course");
		    System.out.println("4. View Courses");
		    System.out.println("5. Enroll Student");
		    System.out.println("6. View Enrollments by Student");
		    System.out.println("7. Exit");

		    System.out.print("Enter choice: ");
		    int choice = scanner.nextInt();
		    scanner.nextLine(); 
		    switch (choice) {

		    case 1:
		        System.out.print("First Name: ");
		        String fn = scanner.nextLine();

		        System.out.print("Last Name: ");
		        String ln = scanner.nextLine();

		        System.out.print("Email: ");
		        String email = scanner.nextLine();

		        System.out.print("Batch: ");
		        String batch = scanner.nextLine();

		        Student s = new Student(
		                IdGenerator.getNextStudentId(),
		                fn, ln, email, batch, true
		        );

		        studentService.addStudent(s);
		        break;

		    case 2:
		        studentService.viewAllStudents();
		        break;

		    case 3:
		        System.out.print("Course Name: ");
		        String cname = scanner.nextLine();

		        System.out.print("Description: ");
		        String desc = scanner.nextLine();

		        System.out.print("Duration (weeks): ");
		        int dur = scanner.nextInt();

		        Course c = new Course(
		                IdGenerator.getNextCourseId(),
		                cname, desc, dur, true
		        );

		        courseService.addCourse(c);
		        break;

		    case 4:
		        courseService.viewAllCourses();
		        break;

		    case 5:
		        System.out.print("Student ID: ");
		        int sid = scanner.nextInt();

		        System.out.print("Course ID: ");
		        int cid = scanner.nextInt();

		        Enrollment e = new Enrollment(
		                IdGenerator.getNextEnrollmentId(),
		                sid, cid, "2026-01-01", "ACTIVE"
		        );

		        enrollmentService.enrollStudent(e);
		        break;

		    case 6:
		        System.out.print("Student ID: ");
		        int studentId = scanner.nextInt();
		        enrollmentService.viewEnrollmentsByStudent(studentId);
		        break;

		    case 7:
		        System.out.println("Exiting...");
		        return;

		    default:
		        System.out.println(" Invalid choice.");
		}
		}
		
		
	}

}
