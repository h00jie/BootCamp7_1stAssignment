package me.hadji.input;

import me.hadji.exception.ExitToMainException;
import me.hadji.init.School;
import me.hadji.model.Assignment;
import me.hadji.model.Student;

import java.util.List;

import static java.lang.Integer.parseInt;

public class StudentUserInput extends AbstractUserInput{

    private static final String ADDING_NEW_STUDENT = "Adding new Student";
    private School school;

    public StudentUserInput(School school){
        this.school= school;
    }
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

    public void addAssignmentsToStudent() throws  ExitToMainException{
        System.out.println("Please provide the StudentID that u want to add the Assignment");
        int studentIDs = scanInt();
        Student existingStudent = school.getStudentManager().getStudentById(studentIDs);
        if (existingStudent == null) {
            System.out.println("Course not found: "+ studentIDs);
            addAssignmentsToStudent();
        } else {
            System.out.println(existingStudent.toString());
        }
        insertAssignmentToStudent(existingStudent);
    }

    private void insertAssignmentToStudent(Student existingStudent) throws  ExitToMainException {
        System.out.println("Please give me Assignment's ID that you want\n"+
                "to be added into this Course.");
        String assignmentIds = scanText();
        List<String> assignmentIdsInt = getStringIdsFromStringArray(assignmentIds);
        System.out.println(assignmentIdsInt);
        for (String assignmentId : assignmentIdsInt){
            Assignment assignment= school.getAssignmentManager().getAssignmentById(assignmentId);
            if (assignment == null) {
                System.out.println("Assignment not found: " + assignmentId);
            } else {
                existingStudent.getAssignmentsForStudent().add(assignment);
                System.out.println(assignment.toString());
            }
        }
    }

    @Override
    public void printUsage() {
        System.out.println(ADDING_NEW_STUDENT);
    }

}
