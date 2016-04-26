package ryhma50;

import java.util.HashMap;
import references.Article;
import references.Book;
import references.EntryType;
import ryhma50.data_access.DAO;
import ryhma50.data_access.FileDAO;
import ryhma50.io.IO;

/**
 *
 * @author marko
 */
public class UserInterface {

    private IO io;
    private DAO dao;

    public UserInterface(IO io, DAO dao) {
        this.io = io;
        this.dao = dao;
    }

    public void run() {
        printHelp();
        while (true) {
            String command = io.readLine(">");
            if (command.isEmpty()) {
                dao.closeWriting();
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
        System.out.println("Add a reference by typing 'add' or "
                + "print all excisting references by typing 'print'. \n"
                + "For 'add'-command choose an entry type by typing 'book' or 'article' \n"
                + "and fill the asked field types. \n"
                + "Type nothing and press enter to exit.");
    }

    private void runCommand(String command) {
        if (command.equalsIgnoreCase("print")) {
            runCommandPrint();
        } else {
            String entryType = io.readLine("Write entry type:");
            if (!validateEntryType(entryType)) {
                io.print("Invalid entry type");
            } else if (command.equalsIgnoreCase("add")) {
                runCommandAdd(entryType);
            }
        }
    }

    private void runCommandAdd(String entryType) {
//        if (entryType.equalsIgnoreCase("book")) {
//            //ask field types and write them to book file
//            addBook();
//        } else {
//            //ask field types and write them to article file
//        }
//        for (EntryType entrytype : dao.listAll()) {
//            if (entrytype.getEntryType().equals(entryType)) {
//                addEntry(entrytype);
//                io.print("New entry added");
//            }
//        }
        if (entryType.equals("book")) {
            EntryType entry = new Book();
            addEntry(entry);
        } else if (entryType.equals("article")) {
            EntryType entry = new Article();
            addEntry(entry);
        }
    }

    private void runCommandPrint() {
        dao.printAllReferencesInEasyReadFormat();
    }

    private boolean validateCommand(String command) {
        return command.equalsIgnoreCase("add") || command.equalsIgnoreCase("print");
    }

    private boolean validateEntryType(String entryType) {
        return entryType.equalsIgnoreCase("book") || entryType.equalsIgnoreCase("article");
    }

    private void addEntry(EntryType entry) {
//        Book book = new Book();
        io.print("Give us the information about the entry.");

        for (String header : entry.returnNecessaryHeaders()) {
            String answer = io.readLine(header + "?");
            while (answer.isEmpty()) {
                io.print("You must fill this field!");
                answer = io.readLine(header + "?");
            }
            entry.addHeaderValue(header, answer);

        }

        io.print("Following fields are optional.");

        for (String header : entry.returnOptionalHeaders()) {
            String answer = io.readLine(header.toString() + "?");
            entry.addHeaderValue(header, answer);
        }

        dao.add(entry);
        io.print("New entry added");
    }

}
