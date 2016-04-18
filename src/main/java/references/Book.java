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
public class Book extends EntryType {


    public Book() {
        super();
        addFieldsToHashMap(necessaryHeaders, PUBLISHER);
        addFieldsToHashMap(optionalHeaders, VOLUME, SERIES, ADDRESS, EDITION, MONTH, NOTE, KEY);
    }

    public Set<String> necessaryFields() {
        return necessaryHeaders.keySet();
    }

    @Override
    public void saveAll(HashMap<String, String> fields) {
        super.saveAll(fields);
        super.allHeaders.put(PUBLISHER, fields.get(PUBLISHER));
        super.allHeaders.put(VOLUME, fields.get(VOLUME));
        super.allHeaders.put(SERIES, fields.get(SERIES));
        super.allHeaders.put(ADDRESS, fields.get(ADDRESS));
        super.allHeaders.put(EDITION, fields.get(EDITION));
        super.allHeaders.put(MONTH, fields.get(MONTH));
        super.allHeaders.put(NOTE, fields.get(NOTE));
        super.allHeaders.put(KEY, fields.get(KEY));
    }

    @Override
    public Set returnAllHeaders() {
        return super.returnAllHeaders();
    }

    public void printFields() { // testataan, tallentuiko tiedot kirjaan
        for (Object field : super.allHeaders.values()) {
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
