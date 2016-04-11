
package viittaukset;

import java.util.HashMap;

/**
 *
 * @author Studies
 */
public class Kirja extends Viittaus {
    private final String PUBLISHER = "publisher";

    public Kirja() {
        super();
        super.latexFields.put("publisher","");
    }

    @Override
    public void saveAll(HashMap<String, String> fields) {
        super.saveAll(fields);
        super.latexFields.put(PUBLISHER, fields.get(PUBLISHER));
    }
    
    
    
   
}
