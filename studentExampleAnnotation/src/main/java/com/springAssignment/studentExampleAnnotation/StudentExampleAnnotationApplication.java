package com.springAssignment.studentExampleAnnotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class StudentExampleAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentExampleAnnotationApplication.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);
		Student testStudent=context.getBean(Student.class);
		testStudent.rollCall();
	}

}
