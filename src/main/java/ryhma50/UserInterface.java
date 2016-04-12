package ryhma50;

import java.util.Scanner;
import ryhma50.io.ConsoleIO;
import ryhma50.io.IO;

/**
 *
 * @author marko
 */
public class UserInterface {

    private IO io;

    public UserInterface() {

        io = new ConsoleIO();
    }

    public void run() {
        printHelp();
        while (true) {
            String command = io.readString(">");
            if (command.isEmpty()) {
                io.print("Until we meet again");
                break;
            } else if (!validateCommand(command)) {
                System.out.println("Invalid command type");
                continue;
            } else {
                runCommand(command);
            }
        }
    }

    private void printHelp() {
        System.out.println("First choose command by typing 'add' or 'get' \n"
                + "Then choose entry type by typing 'article', 'book' \n"
                + "After that add-command will ask you to fill field types \n"
                + "and get will print all the references");
    }

    private void runCommand(String command) {
        String entryType = io.readString("Write entry type: ");
        if (!validateEntryType(entryType)) {
            System.out.println("Invalid entry type");
        } else if (command.equalsIgnoreCase("add")) {
            runCommandAdd(entryType);
        } else {
            runCommandGet(entryType);
        }
    }

    private void runCommandAdd(String entryType) {
        if (entryType.equalsIgnoreCase("book")) {
            //ask field types and write them to book file
        } else {
            //ask field types and write them to article file
        }
        io.print("New entry added");
    }

    private void runCommandGet(String entryType) {
        if (entryType.equalsIgnoreCase("book")) {
            //return list of book references
        } else {
            //return list of article references
        }
    }

    private boolean validateCommand(String command) {
        return command.equalsIgnoreCase("add") || command.equalsIgnoreCase("get");
    }

    private boolean validateEntryType(String entryType) {
        return entryType.equalsIgnoreCase("book") || entryType.equalsIgnoreCase("article");
    }
}
