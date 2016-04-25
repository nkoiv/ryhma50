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
        addFieldsToArrayList(super.necessaryHeaders, JOURNAL);
        addFieldsToArrayList(super.optionalHeaders, VOLUME, NUMBER, PAGES, MONTH, NOTE, KEY);
    }

//    @Override
//    public Set returnAllHeaders() {
//        return super.returnAllHeaders();
//    }

    @Override
    public String getEntryType() {
        return "article";
    }

}
