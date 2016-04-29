package ryhma50;

import java.util.HashMap;
import references.Article;
import references.Book;
import references.EntryType;
import ryhma50.commands.AddEntry;
import ryhma50.commands.Command;
import ryhma50.commands.PrintHelp;
import ryhma50.commands.PrintReferences;
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
    private HashMap<String, Command> commands;
    
    
    public UserInterface(IO io, DAO dao) {
        this.io = io;
        this.dao = dao;
        this.commands = new HashMap<>();
        generateCommands();
    }
    
    private void generateCommands() {
        commands.put("add", new AddEntry(this.io, this.dao));
        commands.put("print", new PrintReferences(this.io, this.dao));
        commands.put("help", new PrintHelp());
    }

    public void run() {
        printHelp();
        while (true) {
            String command = io.readLine(">");
            if (command.isEmpty()) {
                dao.closeWriting();
                io.print("Until we meet again");
                break;
            } else {
                runCommand(command);
            }
        }
    }

    private void printHelp() {
        this.commands.get("help").run(null);
    }

    private void runCommand(String command) {
        String c;
        String args;
        if (command.contains(" ")) {
            c = command.substring(0, command.indexOf(" "));
            args = command.substring(command.indexOf(" ")+1, command.length());
        } else {
            c = command;
            args = "";
        }
        if (this.commands.keySet().contains(c)) {
            Command com = this.commands.get(c);
            com.run(args);
        } else {
            System.out.println("Invalid command");
        }
    }
}
