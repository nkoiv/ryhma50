package ryhma50;

import ryhma50.data_access.DAO;
import ryhma50.data_access.FileDAO;
import ryhma50.io.ConsoleIO;
import ryhma50.io.IO;

public class Main {

    public static void main(String[] args) {
        IO io = new ConsoleIO();
        DAO dao = new FileDAO(io);
        UserInterface ui = new UserInterface(io, dao);
        ui.run();
    }
}
