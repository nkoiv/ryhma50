/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryhma50.commands;

import references.Article;
import references.Book;
import references.EntryType;
import ryhma50.data_access.DAO;
import ryhma50.io.IO;

/**
 * (Console) command for adding new entries to the the system
 * @author nikok
 */
public class AddEntry implements Command {
    private IO io;
    private DAO dao;
    
    public AddEntry(IO io, DAO dao) {
        this.io = io;
        this.dao = dao;
    }
    
    @Override
    public void run(String args) {
        if ("book".equals(args)) {
            EntryType entry = new Book();
            addEntry(entry);
        } else if ("article".equals(args)) {
            EntryType entry = new Article();
            addEntry(entry);
        } else {
            io.print("Invalid arguments for Add");
        }
    }
    
     private void addEntry(EntryType entry) {
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
