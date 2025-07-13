package com.lloydestrada.cruddemo;

import com.lloydestrada.cruddemo.dao.StudentDAO;
import com.lloydestrada.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

				createMultilpleStudents(studentDAO);
		}

	private void createMultilpleStudents(StudentDAO studentDAO) {

		//create multiple students
		System.out.println("Creating 3 new student...");
		Student tempStudent1 = new Student("Lloyd", "Estrada", "lloydestrada@gmail.com");
		Student tempStudent2 = new Student("John", "Amarga", "johnamarga@gmail.com");
		Student tempStudent3 = new Student("Tohi", "Doe", "tohidoe@gmail.com");

		//save the student objects
		System.out.println("Saving 3 students....");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Creating new student...");
		Student tempStudent = new Student("Lloyd", "Estrada", "lloydestrada@gmail.com");

		//save the student object
		System.out.println("Saving student....");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved Student. Generated id: " + tempStudent.getId());
	}
}
