package me.hadji.input;

import me.hadji.exception.ExitToMainException;
import me.hadji.model.Trainer;

public class TrainerUserInput extends AbstractUserInput{

    private static final String ADDING_NEW_TRAINER = "Adding new Trainer";

    public Trainer scanDetails() throws ExitToMainException {
        Trainer trainer = new Trainer();
        System.out.println("First Name:");
        String name = scanText();
        trainer.setFirstName(name);
        System.out.println("Last Name:");
        String lastName = scanText();
        trainer.setLastName(lastName);
        System.out.println("Subject:\n"+
        "What is your field: JAVA or C#");
        String subject = input.next();
        if(subject.equals("JAVA")){

        }
        trainer.setSubject(subject);

        return trainer;
    }

    @Override
    public void printUsage() {
        System.out.println(ADDING_NEW_TRAINER);
    }

}
