package ryhma50.data_access;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
import ryhma50.io.IO;

/**
 *
 * @author marko
 */
public class FileDAO implements DAO {

    private Scanner scanner;
    private BufferedWriter writer;
    private IO io;
    private HashMap<String, String> fields;
    private final static String FILENAME = "BibTexFiles/bibtex.tex";
    private String file;
    private EntryType entry;

    public FileDAO(String fileName, IO io) {
        this.file = fileName;
        this.io = io;
        try {
            try {
                writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8"));

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

    public FileDAO(IO io) {
        this(FILENAME, io);
    }

    @Override
    public List<EntryType> listAll() {
        List<EntryType> entryTypes = new ArrayList<EntryType>();
        entryTypes.add(new Book());
        entryTypes.add(new Article());
        return entryTypes;
    }

    @Override
    public void add(EntryType entry) {
        this.entry = entry;
        if (entry.getLatexFields() == null || entry.getLatexFields().isEmpty()) {
            io.print("Fields can't be empty or null");
        } else {
            if (entry instanceof Book) {
                addBook();
            } else if (entry instanceof Article) {
                addArticle();
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
            for (Object s : entry.returnAllHeaders()) {
                String userInput = this.entry.getValueFromHeader((String) s);
                if (!userInput.isEmpty()) {
                    writer.write(s + " = {" + userInput + "},\n");
                }
            }
            writer.write("}\n\n");
            writer.flush();
        } catch (IOException ex) {
            System.exit(-1);
        }
    }

    private void addArticle() {
        try {
            writer.write("@article{\n");
            for (Object s : entry.returnAllHeaders()) {
                String userInput = this.entry.getValueFromHeader((String) s);
                if (!userInput.isEmpty()) {
                    writer.write(s + " = {" + userInput + "},\n");
                }
            }
            writer.write("}\n\n");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.exit(-1);
        }
    }

    @Override
    public List<String> printAllReferencesInEasyReadFormat() {
        scanner = createScanner();
        List<String> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("}")) {
                continue;
            }
            line = line.replace("@", "");
            line = line.replace("{", "");
            line = line.replace("}", "");
            line = line.replace(",", "");
            io.print(line);
            list.add(line);
        }
        scanner.close();
        return list;
    }

    private Scanner createScanner() {
        try {
            scanner = new Scanner(new File(file));
        } catch (FileNotFoundException ex) {
            System.out.println("Error " + ex);
            System.exit(-1);
        }
        return scanner;
    }

    @Override
    public void closeWriting() {
        try {
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.exit(-1);
        }
    }

}
