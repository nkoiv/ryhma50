
package viittaukset;

import java.util.HashMap;

/**
 *
 * @author Studies
 */
public class Book extends EntryType {
    private final String PUBLISHER = "publisher";

    public Book() {
        super();
        super.latexFields.put("publisher","");
    }

    @Override
    public void saveAll(HashMap<String, String> fields) {
        super.saveAll(fields);
        super.latexFields.put(PUBLISHER, fields.get(PUBLISHER));
    }
    
    
    
   
}
