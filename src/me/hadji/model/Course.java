package me.hadji.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course {
    private List<Trainer> trainers;
    private List<Student> students;
    private List<Assignment> assignments;
    private String title;
    private String stream;
    private LocalDate startDate;
    private LocalDate endDate;
    private String courseId;

    public  Course(){}
//    public Course(List<Trainer> trainers, List<Student> students, List<Assignment> assignments, String title, String stream, LocalDate startDate, LocalDate endDate) {
//        this.trainers = trainers;
//        this.students = students;
//        this.assignments = assignments;
//        this.title = title;
//        this.stream = stream;
//        this.startDate = startDate;
//        this.endDate = endDate;
//    }

    public List getTrainers() {
        return trainers;
    }

    public List getStudents() {
        return students = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    @Override
    public String toString() {
        return "Course{" +
                "trainers=" + trainers +
                ", students=" + students +
                ", assignments=" + assignments +
                ", title='" + title + '\'' +
                ", stream='" + stream + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", courseId='" + courseId + '\'' +
                '}';
    }

    public String toStringStudents() {
        return "Course{" +
                ", students=" + students +
                ", title='" + title + '\'' +
                ", stream='" + stream + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", courseId='" + courseId + '\'' +
                '}';
    }
    public String toStringTrainers() {
        return "Course{" +
                "trainers=" + trainers +
                ", title='" + title + '\'' +
                ", stream='" + stream + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", courseId='" + courseId + '\'' +
                '}';
    }

    public String toStringAssignments() {
        return "Course{" +
                ", assignments=" + assignments +
                ", title='" + title + '\'' +
                ", stream='" + stream + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", courseId='" + courseId + '\'' +
                '}';
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return getCourseId().equals(course.getCourseId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCourseId());
    }
}
