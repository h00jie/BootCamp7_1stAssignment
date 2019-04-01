package me.hadji.managers;

import me.hadji.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentManager {

    private List<Student> students;
    public int studentIDSequence =1000;
    public StudentManager() {
        this.students = new ArrayList<>();
//        students.add(new Student("Christos", "Goros"));
//        students.add(new Student("Panos", "Hadjikonstantinou"));
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        /* Every time i create a new student i increase the ID by one, initial value 1000*/
        student.setStudentId(++studentIDSequence);
        students.add(student);
        System.out.println("Student added: " + student.toString());
    }

    public Student getStudentById(int studentId) {
        for (Student student : getStudents()) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }
}
