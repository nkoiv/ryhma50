package ryhma50.data_access;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import references.Article;
import references.Book;
import references.EntryType;
import ryhma50.data_access.DAO;
import ryhma50.data_access.FileDAO;

/**
 *
 * @author marko
 */
public class StubDAO implements DAO {

    private Scanner sc;
    private BufferedWriter writer;
    private HashMap<String, String> fields;
    private final static String FILE = "src/test/resources/write_file_test.txt";

    public StubDAO() {
        try {
            try {
                writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILE, true), "UTF-8"));
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(FileDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(-1);
            }
            this.fields = new HashMap<>();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(-1);
        }
    }

    @Override
    public List<EntryType> listAll() { // onko tän tarkoitus toimia näin? tätä ennen heitti vain not supported yet -ilmoituksen
        // tehtiin tällainen testausta varten
        List<EntryType> entryTypes = new ArrayList<EntryType>();
        entryTypes.add(new Book());
         entryTypes.add(new Article());
        return entryTypes;
    }

    @Override
    public void add(EntryType entry) {
        this.fields = (HashMap) entry.getLatexFields();
        if (fields == null || fields.size() == 0) {
            System.out.println("Fields can't be empty or null");
        } else {
            setFields(fields);
            if (entry instanceof Book) {
                addBook();
            } else {
                System.out.println("wtf");
            }
        }
    }

    private void setFields(HashMap<String, String> fields) {
        this.fields = fields;
    }

    private void addBook() {
        try {
            writer.write("@book{\n");
            for (String s : fields.keySet()) {
                String userInput = fields.get(s);
                if (!userInput.isEmpty()) {
                    writer.write(s + " = {" + userInput + "},\n");
                }
            }
            writer.write("}\n");
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.exit(-1);
            
        }
    }
}
