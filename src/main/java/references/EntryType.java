package references;

import java.util.*;

/**
 *
 * @author Studies
 */
public abstract class EntryType {

    protected final HashMap<String, String> allHeaders;
    protected final HashMap<String, String> necessaryHeaders;
    protected final HashMap<String, String> optionalHeaders;
    protected final String TITLE = "title";
    protected final String AUTHORS = "authors";
    protected final String YEAR = "year";
    protected final String PUBLISHER = "publisher";
    protected final String VOLUME = "volume/number";
    protected final String SERIES = "series";
    protected final String ADDRESS = "address";
    protected final String EDITION = "edition";
    protected final String MONTH = "month";
    protected final String NOTE = "note";
    protected final String KEY = "key";

    public EntryType() {
        this.allHeaders = new HashMap<>();
        addFieldsToHashMap(allHeaders, TITLE, AUTHORS, YEAR, PUBLISHER, VOLUME, SERIES, ADDRESS, EDITION, MONTH, NOTE, KEY);
        this.necessaryHeaders = new HashMap<>();
        addFieldsToHashMap(necessaryHeaders, TITLE, AUTHORS, YEAR);
        this.optionalHeaders = new HashMap<>();
    }

    public Map returnFields() {
        return this.allHeaders;
    }

    public Set returnAllHeaders() {
        return this.allHeaders.keySet();
    }
    
    public Set returnNecessaryHeaders() {
        return this.necessaryHeaders.keySet();
    }
    
    public Set returnOptionalHeaders() {
        return this.optionalHeaders.keySet();
    }

    public void saveAll(HashMap<String, String> fields) {
        this.allHeaders.put(TITLE, fields.get(TITLE));
        this.allHeaders.put(AUTHORS, fields.get(AUTHORS));
        this.allHeaders.put(YEAR, fields.get(YEAR));
    }

    public void writeToAFile() { // tarvii toteutuksen
    }
    
    protected void addFieldsToHashMap(HashMap<String, String> fields, String... headers) {
        for (String header : headers) {
            fields.put(header, "");
        }
    }
}
