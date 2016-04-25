package ryhma50;

import references.Book;
import references.EntryType;
import ryhma50.data_access.DAO;
import ryhma50.data_access.StubDAO;
import ryhma50.io.IO;

public class StubUserInterface {

    private IO io;
    private DAO dao;

    public StubUserInterface(IO io) {
        this.io = io;
        this.dao = new StubDAO();
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
//        System.out.println("First choose a command by typing 'add' or 'get' \n"
//                + "Then choose an entry type by typing 'article', 'book' \n"
//                + "Add-command will ask you to fill field types \n"
//                + "and 'get' will print all the references.\n"
//                + "Type nothing and press enter to exit.");
        System.out.println("Add a reference by typing 'add'. \n"
                + "Choose an entry type by typing 'book' or 'article' \n"
                + "and fill the asked field types. \n"
                + "Type nothing and press enter to exit.");
    }

    private void runCommand(String command) {
        String entryType = io.readLine("Write entry type:");
        if (!validateEntryType(entryType)) {
            io.print("Invalid entry type");
        } else if (command.equalsIgnoreCase("add")) {
            runCommandAdd(entryType);
        } else {
            runCommandGet(entryType);
        }
    }

    private void runCommandAdd(String entryType) {
//        if (entryType.equalsIgnoreCase("book")) {
//            //ask field types and write them to book file
//            addBook();
//        } else {
//            //ask field types and write them to article file
//        }
        // onko entrytype kirjoitettu väärin -tarkistus
        for (EntryType entrytype : dao.listAll()) {
            if (entrytype.getEntryType().equals(entryType)) {
                addEntry(entrytype);
                io.print("New entry added");
            }
        }
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

    private void addEntry(EntryType entry) {
//        Book book = new Book();

        io.print("Give us the information about the entry.");

        for (String header : entry.returnNecessaryHeaders()) {
            String answer = io.readLine(header + "?");
            while (answer.isEmpty()) {
                io.print("You must fill this field!");
                answer = io.readLine(header + "?");
                entry.addHeaderValue(header, answer);
            }
        }

        io.print("Following fields are optional.");

        for (String header : entry.returnOptionalHeaders()) {
            String answer = io.readLine(header.toString() + "?");
            entry.addHeaderValue(header, answer);
        }
        
        dao.add(entry);
    }

}
