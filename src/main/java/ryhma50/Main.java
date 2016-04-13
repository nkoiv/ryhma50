package ryhma50;

import ryhma50.io.ConsoleIO;
import ryhma50.io.IO;

public class Main {

    public static void main(String[] args) {
        IO io = new ConsoleIO();
        UserInterface ui = new UserInterface(io);
        ui.run();
    }
}
