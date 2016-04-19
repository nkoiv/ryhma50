package ryhma50;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marko
 */
public class WriteFile {

    private FileWriter writer;
    private HashMap<String, String> fields;
    private final static String FILE = "BibTexFiles/bibtex.txt";

    public WriteFile(String fileName, HashMap<String, String> fields) {
        try {
            this.writer = new FileWriter(fileName, true);
            this.fields = fields;
        } catch (IOException ex) {
            System.out.println("Error " + ex);
        }
    }

    public WriteFile(HashMap<String, String> fields) {
        this(FILE, fields);
    }

    public void add() {
        try {
            writer.write("@book{\n");
            for (String s : fields.keySet()) {
                String userInput = fields.get(s);
                if (!userInput.isEmpty()) {
                    writer.write(s + " = {" + userInput + "},\n");
                }
            }
            writer.write("}\n");
            writer.close();
        } catch (IOException ex) {
            System.out.println("Error " + ex);
        }
    }

}
