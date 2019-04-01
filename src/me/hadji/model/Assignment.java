package me.hadji.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Assignment {
    private String title;
    private String description;
    private LocalDate submissionDateTime;
    private int oralMark;
    private int totalMark;
    private String assignmentID;

    public Assignment(){
    }

    public Assignment(String title, String description, LocalDate submissionDateTime, int oralMark, int totalMark) {
        this.title = title;
        this.description = description;
        this.submissionDateTime = submissionDateTime;
        this.oralMark = oralMark;
        this.totalMark = totalMark;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getSubmissionDateTime() {
        return submissionDateTime;
    }

    public void setSubmissionDateTime(LocalDate submissionDateTime) {
        this.submissionDateTime = submissionDateTime;
    }

    public int getOralMark() {
        return oralMark;
    }

    public void setOralMark(int oralMark) {
        this.oralMark = oralMark;
    }

    public int getTotalMark() {
        return totalMark;
    }

    public String getAssignmentID() {
        return assignmentID;
    }

    public void setAssignmentID(String assignmentID) {
        this.assignmentID = assignmentID;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", submissionDateTime=" + submissionDateTime.format(DateTimeFormatter.ofPattern("d/MM/yyyy")) +
                ", oralMark=" + oralMark +
                ", totalMark=" + totalMark +
                ", assignmentID='" + assignmentID + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Assignment)) return false;
        Assignment that = (Assignment) o;
        return getAssignmentID().equals(that.getAssignmentID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAssignmentID());
    }
}