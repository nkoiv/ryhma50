/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryhma50.commands;

/**
 * Help-text for the console interface
 * @author nikok
 */
public class PrintHelp implements Command {

    @Override
    public void run(String args) {
    System.out.println("Add a reference by typing 'add' or "
                + "print all excisting references by typing 'print'. \n"
                + "For 'add'-command choose an entry type by typing 'book' or 'article' \n"
                + "and fill the asked field types. \n"
                + "Type nothing and press enter to exit.");
    }
    
}
