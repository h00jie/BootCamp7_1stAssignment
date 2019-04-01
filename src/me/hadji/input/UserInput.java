package me.hadji.input;

import me.hadji.exception.ExitToMainException;
import me.hadji.init.School;
import me.hadji.model.Assignment;
import me.hadji.model.Course;
import me.hadji.model.Student;
import me.hadji.model.Trainer;

import java.util.Scanner;

public class UserInput {


    Scanner input;
    School school;
    StudentUserInput studentUserInput;
    TrainerUserInput trainerUserInput;
    CourseUserInput courseUserInput;
    AssignmentUserInput assignmentUserInput;

    private static final String BASIC_USAGE = "Wellcome to School Admin. Please select an action by keying in a number:\n" +
            "0) add student\n" +
            "1) print students\n" +
            "2) add Trainer\n" +
            "3) print trainers\n"+
            "4) add course \n"+
            "5) print courses\n"+
            "6) add assignments\n"+
            "7) print assignments\n"+
            "8) add student to course\n"+
            "9) add trainer to course\n"+
            "";


    public UserInput(School school) {
        this.input = new Scanner(System.in);
        this.school = school;
        this.studentUserInput = new StudentUserInput();
        this.trainerUserInput = new TrainerUserInput();
        this.courseUserInput = new CourseUserInput(school);
        this.assignmentUserInput = new AssignmentUserInput();
    }

    /*
     * Wellcome to School Admin
     *
     * 0) print students
     * 1) add student
     * */
    public void printUsage() {
        System.out.println(BASIC_USAGE);
    }

    public void scanUsage() {
        try {
            int choice = Integer.parseInt(input.next());
            if (choice == 0) {
                studentUserInput.printUsage();
                Student newStudent = studentUserInput.scanDetails();
                school.getStudentManager().addStudent(newStudent);
            } else if (choice == 1) {
                System.out.println(school.getStudentManager().getStudents().toString());
            } else if (choice == 2) {
                trainerUserInput.printUsage();
                Trainer newTrainer = trainerUserInput.scanDetails();
                school.getTrainerManager().addTrainer(newTrainer);
            } else if (choice == 3) {
                System.out.println(school.getTrainerManager().getTrainers().toString());
            } else if (choice == 4) {
                courseUserInput.printUsage();
                Course newCourse = courseUserInput.scanDetails();
                school.getCourseManager().newCource(newCourse);
            } else if (choice == 5) {
                System.out.println(school.getCourseManager().getCourses().toString());
            } else if (choice == 6) {
                assignmentUserInput.printUsage();
                Assignment newAssignment = assignmentUserInput.scanDetails();
                school.getAssignmentManager().addAssignment(newAssignment);
            } else if (choice == 7) {
                System.out.println(school.getAssignmentManager().getAssignments().toString());
            } else if (choice == 8) {
                System.out.println("please give me course id");
                courseUserInput.addStudentsToCourse();
//            String courseidnrs = input.next();
//            Course existingCourse = school.getCourseManager().getCourseById(courseidnrs);
//            System.out.println(existingCourse.toString());
//            courseUserInput.printUsageStudent();
//            courseUserInput.addStudentsToCourse();
            } else if (choice == 9) {

            } else {
                printFalseOption();
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Must be a number");
            printUsage();
            scanUsage();
        } catch (ExitToMainException exit) {
            printUsage();
            scanUsage();
        }
    }



    private void printFalseOption() {
        System.out.println("Invalid Choice");
    }

}
