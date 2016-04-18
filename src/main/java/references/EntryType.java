package references;

import java.util.*;

/**
 *
 * @author Studies
 */
public abstract class EntryType {

    protected final HashMap<String, String> latexFields;
    protected final ArrayList<String> necessaryHeaders;
    protected final ArrayList<String> optionalHeaders;
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
        this.latexFields = new HashMap<>();
        addFieldsToHashMap(latexFields, TITLE, AUTHORS, YEAR, PUBLISHER, VOLUME, SERIES, ADDRESS, EDITION, MONTH, NOTE, KEY);
        this.necessaryHeaders = new ArrayList<>();
        addFieldsToArrayList(necessaryHeaders, TITLE, AUTHORS, YEAR);
        this.optionalHeaders = new ArrayList<>();
    }

    public Map returnFields() {
        return this.latexFields;
    }

    public Set returnAllHeaders() {
        return this.latexFields.keySet();
    }

    public ArrayList<String> returnNecessaryHeaders() {
        return this.necessaryHeaders;
    }

    public ArrayList<String> returnOptionalHeaders() {
        return this.optionalHeaders;
    }

    public void saveAll(HashMap<String, String> fields) {
//        for (String header : nec) {
//
//        }
        this.latexFields.put(TITLE, fields.get(TITLE));
        this.latexFields.put(AUTHORS, fields.get(AUTHORS));
        this.latexFields.put(YEAR, fields.get(YEAR));
    }

    protected void addFieldsToArrayList(ArrayList<String> fields, String... headers) {
        for (String header : headers) {
            fields.add(header);
        }
    }

    protected void addFieldsToHashMap(HashMap<String, String> fields, String... headers) {
        for (String header : headers) {
            fields.put(header, "");
        }
    }

}
