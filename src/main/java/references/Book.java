package references;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Studies
 */
public class Book extends EntryType {

    /**
     * Add necessary and optional headers.
     */
    public Book() {
        super();
        addFieldsToArrayList(super.necessaryHeaders, PUBLISHER);
        addFieldsToArrayList(super.optionalHeaders, VOLUME, SERIES, ADDRESS, EDITION, MONTH, NOTE, KEY);
    }

//    @Override
//    public Set returnAllHeaders() {
//        return super.returnAllHeaders();
//    }

      
    @Override
    public String getEntryType() {
        return "book";
    }
}
