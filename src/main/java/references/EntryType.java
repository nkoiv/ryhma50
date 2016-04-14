
package references;

import java.util.*;

/**
 *
 * @author Studies
 */
public abstract class EntryType {
    protected final HashMap<String, String> latexFields;
    protected final String TITLE = "title";
    protected final String AUTHORS = "authors";
    protected final String YEAR= "year";
    
    public EntryType() {
        this.latexFields = new HashMap<>();
        this.latexFields.put(TITLE, "");
        this.latexFields.put(AUTHORS, "");
        this.latexFields.put(YEAR, "");
    }
    
    public Map returnFields() {
        return this.latexFields;
    }
    
    public Set returnHeaders() {
        return this.latexFields.keySet();
    }
    
    public void saveAll(HashMap<String, String> fields) {
        this.latexFields.put(TITLE, fields.get(TITLE));
        this.latexFields.put(AUTHORS, fields.get(AUTHORS));
        this.latexFields.put(YEAR, fields.get(YEAR));
    }
    
    public void writeToAFile() { // tarvii toteutuksen
        
    }
}
