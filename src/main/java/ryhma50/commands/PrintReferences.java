/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryhma50.commands;

import ryhma50.data_access.DAO;
import ryhma50.io.IO;

/**
 * (Console)command to print tell the DAO to print all references
 * @author nikok
 */
public class PrintReferences implements Command {
    private IO io;
    private DAO dao;
    
    public PrintReferences(IO io, DAO dao) {
        this.io = io;
        this.dao = dao;
    }
    
    @Override
    public void run(String args) {
        dao.printAllReferencesInEasyReadFormat();
    }
    
}
