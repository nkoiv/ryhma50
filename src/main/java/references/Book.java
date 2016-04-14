package references;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Studies
 */
public class Book extends EntryType implements Serializable {

    private final String PUBLISHER = "publisher";
    private final String VOLUME = "volume/number";
    private final String SERIES = "series";
    private final String ADDRESS = "address";
    private final String EDITION = "edition";
    private final String MONTH = "month";
    private final String NOTE = "note";
    private final String KEY = "key";

    public Book() {
        super();
        super.latexFields.put("publisher", "");
        super.latexFields.put("volume/number", "");
        super.latexFields.put("series", "");
        super.latexFields.put("address", "");
        super.latexFields.put("edition", "");
        super.latexFields.put("month", "");
        super.latexFields.put("note", "");
        super.latexFields.put("key", "");
    }

    public ArrayList<String> necessaryFields() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("authors");
        list.add("title");
        list.add("publisher");
        list.add("year");
        return list;
    }

    @Override
    public void saveAll(HashMap<String, String> fields) {
        super.saveAll(fields);
        super.latexFields.put(PUBLISHER, fields.get(PUBLISHER));
        super.latexFields.put(VOLUME, fields.get(VOLUME));
        super.latexFields.put(SERIES, fields.get(SERIES));
        super.latexFields.put(ADDRESS, fields.get(ADDRESS));
        super.latexFields.put(EDITION, fields.get(EDITION));
        super.latexFields.put(MONTH, fields.get(MONTH));
        super.latexFields.put(NOTE, fields.get(NOTE));
        super.latexFields.put(KEY, fields.get(KEY));
    }

    @Override
    public Set returnHeaders() {
        return super.returnHeaders();
    }

    public void printFields() { // testataan, tallentuiko tiedot kirjaan
        for (Object field : super.latexFields.values()) {
            System.out.println(field.toString());
        }
    }

    @Override
    public void writeToAFile() { // ei osattu saada tätä toimimaan, mut tällaisella metodilla yritettiin tallentaa kirja-olioita tiedostoon
        try {
            FileOutputStream fout = new FileOutputStream("books");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(this);
            oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
