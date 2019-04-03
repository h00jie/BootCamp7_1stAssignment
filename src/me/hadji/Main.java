package me.hadji;

import me.hadji.init.School;
import me.hadji.input.UserInput;

public class Main {

    public static void main(String[] args) {

        School school = new School();
        UserInput userInput = new UserInput(school);
        while (true) {
            userInput.printUsage();
            userInput.scanUsage();
            System.out.println("\n----------------------------------------------------------------------------------------------\n");
        }
    }
}
