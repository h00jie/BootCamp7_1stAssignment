package me.hadji.input;

import me.hadji.exception.ExitToMainException;
import me.hadji.init.School;
import me.hadji.managers.AssignmentManager;
import me.hadji.managers.CourseManager;
import me.hadji.managers.StudentManager;
import me.hadji.managers.TrainerManager;
import me.hadji.model.Assignment;
import me.hadji.model.Course;
import me.hadji.model.Student;
import me.hadji.model.Trainer;

import java.util.List;

public class CourseUserInput extends AbstractUserInput{

    private static final String ADDING_NEW_COURSE = "Adding new Course";
    private static final String ADDING_STUDENT_TO_COURSE = "Adding student to Course";
    private static final String ADDING_ASSIGNMENT_TO_COURSE = "Adding assignment to Course";
    private static final String ADDING_TRAINER_TO_COURSE = "Adding trainer to Course";

    private School school;
    private StudentManager studentManager;
    private CourseManager courseManager;
    private AssignmentManager assignmentManager;
    private TrainerManager trainerManager;

    public CourseUserInput(School school) {
        this.school = school;
        this.studentManager = school.getStudentManager();
        this.courseManager = school.getCourseManager();
        this.assignmentManager = school.getAssignmentManager();
        this.trainerManager =  school.getTrainerManager();
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

    public void addTrainersToCourse() throws ExitToMainException{
        System.out.println("Please provide the CourseID that u want to add the trainer");
        String courseIDs = scanText();
        Course existingCourset = courseManager.getCourseById(courseIDs);
        if (existingCourset == null) {
            System.out.println("Course not found: "+ courseIDs);
            addTrainersToCourse();
        } else {
            System.out.println(existingCourset.toString());
        }
        insertTrainer(existingCourset);
    }
    private void insertTrainer(Course existingCourset) throws ExitToMainException{
        System.out.println("Please give me Trainer's ID that you want\n"+
                "to be added into this Course.");
        String trainersIds = scanText();
        List<Integer> trainersIdsInt = getIdsFromString(trainersIds);
        System.out.println(trainersIdsInt);
        for (Integer trainerId : trainersIdsInt){
            Trainer trainer = trainerManager.getTrainerById(trainerId);
            if (trainer == null) {
                System.out.println("Trainer not found: " + trainerId);
            } else {
                existingCourset.getTrainers().add(trainer);
                System.out.println(trainer.toString());
            }
        }
    }

    public void addAssignmentsToCourse() throws  ExitToMainException{
        System.out.println("Please provide the CourseID that u want to add the Assignment");
        String courseIDs = scanText();
        Course existingCourse = courseManager.getCourseById(courseIDs);
        if (existingCourse == null) {
            System.out.println("Course not found: "+ courseIDs);
            addAssignmentsToCourse();
        } else {
            System.out.println(existingCourse.toString());
        }
        insertAssignment(existingCourse);
    }

    private void insertAssignment(Course existingCourse) throws  ExitToMainException {
        System.out.println("Please give me Assignment's ID that you want\n"+
                "to be added into this Course.");
        String assignmentIds = scanText();
        List<String> assignmentIdsInt = getStringIdsFromStringArray(assignmentIds);
        System.out.println(assignmentIdsInt);
        for (String assignmentId : assignmentIdsInt){
            Assignment assignment= assignmentManager.getAssignmentById(assignmentId);
            if (assignment == null) {
                System.out.println("Assignment not found: " + assignmentId);
            } else {
                existingCourse.getAssignments().add(assignment);
                System.out.println(assignment.toString());
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
