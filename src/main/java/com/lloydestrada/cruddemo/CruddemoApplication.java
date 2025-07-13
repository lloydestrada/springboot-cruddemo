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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		//lambda expression
		return runner ->
				createStudent(studentDAO);
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
