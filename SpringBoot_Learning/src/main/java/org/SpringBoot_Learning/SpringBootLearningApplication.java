package org.SpringBoot_Learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

import org.SpringBoot_Learning.Entity.Student;
import org.SpringBoot_Learning.Interfaces.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

// @SpringBootApplication(scanBasePackages = { "org.util", "org.SpringBoot_Learning" })
@SpringBootApplication
public class SpringBootLearningApplication {

	@Autowired
	private StudentDAO studentDAO;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLearningApplication.class, args);
		System.out.println("Spring Boot Application Started");
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return runner -> {
			// createStudent();
			createMultipleStudents();
			// readStudent();
			// readAllStudents();
			// findByLastName();
			// updateStudent();
			// deleteStudent(11);
			// deleteAllStudents();
		};
	}

	private void deleteAllStudents() {
		int numberOfDeletedStudetns = studentDAO.deleteAll();
		System.out.println("Number of deleted students: " + numberOfDeletedStudetns);
	}

	private void deleteStudent(int id) {
		studentDAO.deleteStudent(id);

		List<Student> students = studentDAO.findAll();
		for (Student student1 : students) {
			System.out.println(student1);
		}
	}

	private void updateStudent() {
		Student student = studentDAO.findById(1);
		student.setFirstName("TEMP_FIRST_NAME");
		studentDAO.update(student);
		System.out.println(student);
	}

	private void findByLastName() {
		List<Student> students = studentDAO.findByLastName("RTY");
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void readAllStudents() {
		List<Student> students = studentDAO.findAll();
		System.out.println("Total number of students: " + students.size());
		for (Student student : students) {
			System.out.println(student);
		}
		System.out.println("All students read successfully");
	}

	private void readStudent() {
		// read the student with id = 1
		System.out.println("Reading student with id: 1");
		Student student = studentDAO.findById(1);
		System.out.println("Found student: " + student);

		// read the student with id = 2
		System.out.println("Reading student with id: 2");
		student = studentDAO.findById(2);
		System.out.println("Found student: " + student);
	}

	private void createMultipleStudents() {
		Student student1 = new Student("Pawan", "Perla", "perlapawan25@gmail.com");
		Student student2 = new Student("ABC", "DEF", "ABCDEF@gmail.com");
		Student student3 = new Student("QWE", "RTY", "QWERTY@gmail.com");

		System.out.println("Saving the students");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent() {
		// create the student object
		System.out.println("Creating new student object");
		Student student = new Student("John", "Doe", "johndoe@gmail.com");

		// save the student object
		System.out.println("Saving the student");
		studentDAO.save(student);

		// display the id of the saved student
		System.out.println("Saved student. Generated id: " + student.getId());
		System.out.println("Student created successfully");
	}

}
