package me.hadji.input;

import com.sun.javaws.exceptions.ExitException;
import me.hadji.Main;
import me.hadji.exception.ExitToMainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public abstract class AbstractUserInput {

    Scanner input;

    final String BASIC_USAGE = "Abstract Usage";

    public AbstractUserInput () {
        input = new Scanner(System.in);
    }

    public void printUsage() {
        System.out.println(BASIC_USAGE);
    }

    public void scanUsage() {
    }

    protected void printFalseOption() {
        System.out.println("Invalid Choice");
    }

    protected LocalDate scanDate() throws ExitToMainException{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        System.out.println("Formated like this DD/MM/YYYY");
        String date = scanText();
        LocalDate localDate = LocalDate.now();
        try {
            localDate = LocalDate.parse(date, formatter);
        } catch (DateTimeParseException dtpe) {
            System.out.println("Invalid date format");
            this.scanDate();
        }

        return  localDate;
    }

    protected String scanText() throws ExitToMainException{
        String info = input.next();
        if (info.equals("exit") || (info.equals("EXIT"))) {
            throw new ExitToMainException();
        }
        return info;
    }

    protected int scanInt() {
        int result = 0;
        try {
            result = Integer.parseInt(input.next());
        } catch (NumberFormatException e) {
            System.out.println("Must be a number");
            scanInt();
        }
        return result;
    }

    protected List<Integer> getIdsFromString(String studentIds) {
        String[] stringIds = studentIds.split(",");
        List<Integer> integers = new ArrayList<>();

        for (String stringId : stringIds) {
            try {
                integers.add(Integer.valueOf(stringId.trim()));
            } catch (NumberFormatException e) {
                System.out.println(stringId + " is not a number");
            }
        }
        return integers;
    }

    protected List<String> getStringIdsFromStringArray(String stringIDS) {
        String[] stringIds = stringIDS.split(",");
        List<String> strings = new ArrayList<>();

        for (String stringID : stringIds) {
            try {
                strings.add(stringID.trim());
            } catch (NumberFormatException e) {
                System.out.println(stringID + " is not a number");
            }
        }
        return strings;
    }



}
