package com.springAssignment.studentExampleAnnotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "com.springAssignment.studentExampleAnnotation")
public class StudentConfig {

//    @Bean
//    public Student makeStudent()
//    {
//        List<String> numbers = new ArrayList<>();
//        numbers.add("555-443-6789");
//        numbers.add("555-443-6789");
//        Address newAdd = makeAddress();
//        return new Student(24, "justin", numbers, newAdd);
//    }
//
//    @Bean
//    public Address makeAddress()
//    {
//        return new Address("Indianapolis","Indiana","USA");
//    }
}
