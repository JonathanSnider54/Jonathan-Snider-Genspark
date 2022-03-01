package com.springAssignment.studentExampleAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Student {
    private int StudentID;
    private String name;
    private List<String> contactNumbers;
    @Autowired
    private Address add;

    public Student(int studentID, String name, List<String> contactNumbers, Address add) {
        StudentID = studentID;
        this.name = name;
        this.contactNumbers = contactNumbers;
        this.add = add;
    }

    public Student() {
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int studentID) {
        StudentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getContactNumbers() {
        return contactNumbers;
    }

    public void setContactNumbers(List<String> contactNumbers) {
        this.contactNumbers = contactNumbers;
    }

    public Address getAdd() {
        return add;
    }

    public void setAdd(Address add) {
        this.add = add;
    }

    @Override
    public String toString() {
        return "Student{" +
                "StudentID=" + StudentID +
                ", name='" + name + '\'' +
                ", contactNumbers=" + contactNumbers +
                ", add=" + add +
                '}';
    }

    public void rollCall()
    {
        System.out.println("hello I am a new student");
    }
}
