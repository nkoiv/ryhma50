package references;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Studies
 */
public class Book extends EntryType {

    public Book() {
        super();
        addFieldsToArrayList(necessaryHeaders, PUBLISHER);
        addFieldsToArrayList(optionalHeaders, VOLUME, SERIES, ADDRESS, EDITION, MONTH, NOTE, KEY);
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
    public Set returnAllHeaders() {
        return super.returnAllHeaders();
    }
}
