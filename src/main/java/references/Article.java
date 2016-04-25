package references;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Studies
 */
public class Article extends EntryType {

    /**
     * Add necessary and optional headers.
     */
    public Article() {
        super();
        addFieldsToArrayList(super.necessaryHeaders, PUBLISHER);
        addFieldsToArrayList(super.optionalHeaders, VOLUME, SERIES, ADDRESS, EDITION, MONTH, NOTE, KEY);
    }

//    @Override
//    public Set returnAllHeaders() {
//        return super.returnAllHeaders();
//    }


}
