package me.hadji.input;
import me.hadji.exception.ExitToMainException;
import me.hadji.model.Assignment;

import java.time.LocalDate;

public class AssignmentUserInput extends AbstractUserInput{

    private static final String ADDING_NEW_ASSIGNMENT = "Adding new Assignmment";


    public Assignment scanDetails() throws ExitToMainException {
        Assignment assignment =new Assignment();
        System.out.println("Title: ");
        String title = scanText();
        assignment.setTitle(title);
        System.out.println("Description: ");
        String description = scanText();
        assignment.setDescription(description);
        System.out.println("Submission Date: ");
        LocalDate date = scanDate();
        assignment.setSubmissionDateTime(date);
        System.out.println("Oral Mark: ");
        int oralMark = scanInt();
        assignment.setOralMark(oralMark);
        System.out.println("Total Mark: ");
        int totalMark = scanInt();
        assignment.setTotalMark(totalMark);
        return  assignment;
    }


    @Override
    public void printUsage() {
        System.out.println(ADDING_NEW_ASSIGNMENT);
    }

}
