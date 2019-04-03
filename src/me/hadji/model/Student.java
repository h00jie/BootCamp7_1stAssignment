package me.hadji.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private int tuitionFees=2500;
    private int studentId;
    private List<Assignment> assignmentsForStudent;

    public Student() {
        this.assignmentsForStudent = new ArrayList<>();
    }

    public Student(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId=studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public Student setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Student setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    public List<Assignment> getAssignmentsForStudent() {
        return assignmentsForStudent;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", date of birth='" + dateOfBirth.format(DateTimeFormatter.ofPattern("d/MM/yyyy")) + '\'' +
                ", tuition fees='" + tuitionFees + '\'' +
                ", student id='" + studentId + '\'' +
                '}';
    }


    public String toStrinAssignmentsPerStudent() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth.format(DateTimeFormatter.ofPattern("d/MM/yyyy")) + '\'' +
                ", tuitionFees=" + tuitionFees +
                ", studentId=" + studentId +
                ", assignmentsForStudent=" + assignmentsForStudent +
                '}';
    }
}
