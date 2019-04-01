package me.hadji.init;

import me.hadji.input.CourseUserInput;
import me.hadji.managers.AssignmentManager;
import me.hadji.managers.CourseManager;
import me.hadji.managers.StudentManager;
import me.hadji.managers.TrainerManager;
import me.hadji.model.Course;

public class School {

    private StudentManager studentManager;
    private TrainerManager trainerManager;
    private CourseManager courseManager;
    private AssignmentManager assignmentManager;

    public School() {
        studentManager = new StudentManager();
        trainerManager = new TrainerManager();
        courseManager = new CourseManager(this);
        assignmentManager = new AssignmentManager();

    }

    public StudentManager getStudentManager() {
        return studentManager;
    }

    public TrainerManager getTrainerManager() {
        return trainerManager;
    }

    public CourseManager getCourseManager() { return  courseManager; }

    public AssignmentManager getAssignmentManager() { return  assignmentManager; }
}
