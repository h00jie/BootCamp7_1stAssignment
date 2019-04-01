package me.hadji.input;

import me.hadji.exception.ExitToMainException;
import me.hadji.init.School;
import me.hadji.managers.CourseManager;
import me.hadji.managers.StudentManager;
import me.hadji.model.Course;
import me.hadji.model.Student;

import java.util.ArrayList;
import java.util.List;

public class CourseUserInput extends AbstractUserInput{

    private static final String ADDING_NEW_COURSE = "Adding new Course";
    private static final String ADDING_STUDENT_TO_COURSE = "Adding student to Course";
    private static final String ADDING_ASSIGNMENT_TO_COURSE = "Adding assignment to Course";
    private static final String ADDING_TRAINER_TO_COURSE = "Adding trainer to Course";

    private School school;
    private StudentManager studentManager;
    private CourseManager courseManager;

    public CourseUserInput(School school) {
        this.school = school;
        this.studentManager = school.getStudentManager();
        this.courseManager = school.getCourseManager();
    }

    public Course scanDetails() throws ExitToMainException {
        Course course = new Course();
        System.out.println("Course Title:");
        String title = scanText();
        course.setTitle(title);
        System.out.println("Course Stream is JAVA or C#\n"+
                "Your input must be between these two");
        String stream = scanText();
        course.setStream(stream);
        System.out.println("Start Date :");
        course.setStartDate(scanDate());
        System.out.println("End Date :");
        course.setEndDate(scanDate());
        return course;
    }

    public void addStudentsToCourse() throws ExitToMainException{
        System.out.println("Please provide the CourseID that u want to add the students");
        String courseIDs = scanText();
        Course existingCourse = courseManager.getCourseById(courseIDs);
        if (existingCourse == null) {
            System.out.println("Course not found: "+ courseIDs);
            addStudentsToCourse();
        } else {
            System.out.println(existingCourse.toString());
        }
        insertStudent(existingCourse);
    }

    private void insertStudent(Course existingCourse) throws ExitToMainException{
        System.out.println("Please give me student's ID that you want\n"+
                "to be added into this Course.");
        String studentIds = scanText();
        List<Integer> studentIdInt = getIdsFromString(studentIds);
        System.out.println(studentIdInt);
        for (Integer studentId : studentIdInt){
            Student student = studentManager.getStudentById(studentId);
            if (student == null) {
                System.out.println("Student not found: " + studentId);
            } else {
                existingCourse.getStudents().add(student);
                System.out.println(student.toString());
            }
        }
    }

    @Override
    public void printUsage() {
        System.out.println(ADDING_NEW_COURSE);
    }

    public void printUsageStudent() {
        System.out.println(ADDING_STUDENT_TO_COURSE);
    }

    public void printUsageAssignment() {
        System.out.println(ADDING_ASSIGNMENT_TO_COURSE);
    }

    public void printUsageTrainer() { System.out.println(ADDING_TRAINER_TO_COURSE); }


}
