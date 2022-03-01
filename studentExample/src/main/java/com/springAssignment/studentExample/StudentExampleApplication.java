package com.springAssignment.studentExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class StudentExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentExampleApplication.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		Student testStudent = (Student) context.getBean("student");
		System.out.println(testStudent.toString());
	}
}
