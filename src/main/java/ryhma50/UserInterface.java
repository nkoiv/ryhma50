package ryhma50;

import java.util.HashMap;
import references.Book;
import ryhma50.io.IO;

/**
 *
 * @author marko
 */
public class UserInterface {

    private IO io;

    public UserInterface(IO io) {

        this.io = io;
    }

    public void run() {
        printHelp();
        while (true) {
            String command = io.readLine(">");
            if (command.isEmpty()) {
                io.print("Until we meet again");
                break;
            } else if (!validateCommand(command)) {
                io.print("Invalid command type");
                continue;
            } else {
                runCommand(command);
            }
        }
    }

    private void printHelp() {
        System.out.println("First choose a command by typing 'add' or 'get' \n"
                + "Then choose an entry type by typing 'article', 'book' \n"
                + "Add-command will ask you to fill field types \n"
                + "and 'get' will print all the references.\n"
                + "Type nothing and press enter to exit.");
    }

    private void runCommand(String command) {
        String entryType = io.readLine("Write entry type: ");
        if (!validateEntryType(entryType)) {
            io.print("Invalid entry type");
        } else if (command.equalsIgnoreCase("add")) {
            runCommandAdd(entryType);
        } else {
            runCommandGet(entryType);
        }
    }

    private void runCommandAdd(String entryType) {
        if (entryType.equalsIgnoreCase("book")) {
            //ask field types and write them to book file
            addBook();
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

    private void addBook() {
        Book book = new Book();
        HashMap<String, String> fields = new HashMap<String, String>();

        io.print("Give us the information about the book.");

        for (String header : book.returnNecessaryHeaders()) {
            String answer = io.readLine(header + "?");
            while (answer.isEmpty()) {
                io.print("You must fill this field!");
                answer = io.readLine(header + "?");
            }
            fields.put(header.toString(), answer);
        }

        io.print("Following fields are optional.");
        
        for (Object header : book.returnOptionalHeaders()) {
                String answer = io.readLine(header.toString() + "?");
                fields.put(header.toString(), answer);
        }

        book.saveAll(fields);
    }

}
