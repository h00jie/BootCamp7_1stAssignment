package me.hadji.managers;

import me.hadji.init.School;
import me.hadji.model.Course;
import me.hadji.model.Student;

import java.util.ArrayList;
import java.util.List;

public class CourseManager {

    private List<Course> courses;
    private School school;
    private int courseIDSequence = 100;

    public CourseManager (School school) {
        this.courses = new ArrayList<>();
        this.school = school;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void newCource(Course course) {
        course.setCourseId(courseIDIncrementedConcatWithChar());
        courses.add(course);
        System.out.println("Course added: " + course.toString());
    }
    public String courseIDIncrementedConcatWithChar(){
        String courseID= "CR"+(courseIDSequence);
        courseIDSequence += 100;
        return courseID;
    }

    public Course getCourseById(String courseID) {
        for (Course course : getCourses()) {
            if (course.getCourseId().equals(courseID)) {
                return course;
            }
        }
        return null;
    }

}
