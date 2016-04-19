package ryhma50.data_access;

import java.util.HashMap;
import java.util.List;
import references.EntryType;

/**
 *
 * @author marko
 */
public interface DAO {

    List<EntryType> listAll();

    void add(String type, HashMap<String, String> fields);

}
