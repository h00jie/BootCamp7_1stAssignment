package me.hadji.managers;

import me.hadji.model.Assignment;
import me.hadji.model.Student;

import java.util.ArrayList;
import java.util.List;

public class AssignmentManager {

    private List<Assignment> assignments;
    private int assignmentIDSequence=10;
    public AssignmentManager(){
        this.assignments= new ArrayList<>();
    }

    public List<Assignment> getAssignments(){ return assignments; }

    public void addAssignment( Assignment assignment) {
        assignment.setAssignmentID(assignmentIDIncrementedConcatWithChar());
        assignments.add(assignment);
        System.out.printf("Assignment added :" + assignment.toString());
    }
    public String assignmentIDIncrementedConcatWithChar(){
        String assignmentID= "AS"+(assignmentIDSequence);
        assignmentIDSequence += 10;
        return assignmentID;
    }
    public Assignment getAssignmentById(String assignmentId) {
        for (Assignment assignment : getAssignments()) {
            if (assignment.getAssignmentID().equals(assignmentId)) {
                return assignment;
            }
        }
        return null;
    }

}
