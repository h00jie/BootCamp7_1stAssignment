package me.hadji.input;

import me.hadji.exception.ExitToMainException;
import me.hadji.model.Student;

public class StudentUserInput extends AbstractUserInput{

    private static final String ADDING_NEW_STUDENT = "Adding new Student";

    public Student scanDetails() throws ExitToMainException {
        Student student = new Student();
        System.out.println("First Name:");
        String name = scanText();
        student.setFirstName(name);
        System.out.println("Last Name:");
        String lastName = scanText();
        student.setLastName(lastName);
        System.out.println("Date of Birth: ");
        student.setDateOfBirth(scanDate());
        return student;
    }

    @Override
    public void printUsage() {
        System.out.println(ADDING_NEW_STUDENT);
    }

}
