package com.lloydestrada.cruddemo;

import com.lloydestrada.cruddemo.dao.StudentDAO;
import com.lloydestrada.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		//lambda expression
		return runner ->

				//createStudent(studentDAO);

				//createMultipleStudents(studentDAO);

				//readStudent(studentDAO);

				queryForStudents(studentDAO);
		}

	//Query of objects (READ)
	private void queryForStudents(StudentDAO studentDAO) {

		//get list of students
		List<Student> theStudents = studentDAO.findAll();

		//display list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	//RETRIEVE OR READ
	private void readStudent(StudentDAO studentDAO) {

		//create a student object
		System.out.println("Creating a new student...");
		Student tempStudent = new Student("Mickey", "Mouse", "mickeymouse@gmail.com", 24);

		//save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Student Saved\nGenerated ID: " + theId);

		//retrieve student based on the id (primary key)
		System.out.println("Retrieving student with the ID: " + theId);
		Student myStudent = studentDAO.findById(theId);

		//display student
		System.out.println("Student Found: " + myStudent);
	}

	//CREATE BUT IN MULTIPLE STUDENTS
	private void createMultipleStudents(StudentDAO studentDAO) {

		//create multiple students
		System.out.println("Creating 3 new student...");
		Student tempStudent1 = new Student("Lloyd", "Estrada", "lloydestrada@gmail.com", 22);
		Student tempStudent2 = new Student("John", "Amarga", "johnamarga@gmail.com", 19);
		Student tempStudent3 = new Student("Tohi", "Doe", "tohidoe@gmail.com", 22);

		//save the student objects
		System.out.println("Saving 3 students....");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	//CREATE
	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Creating new student...");
		Student tempStudent = new Student("Lloyd", "Estrada", "lloydestrada@gmail.com", 23);

		//save the student object
		System.out.println("Saving student....");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved Student. Generated id: " + tempStudent.getId());
	}
}
