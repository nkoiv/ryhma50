
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ryhma50.data_access.DAO;
import ryhma50.data_access.FileDAO;
import ryhma50.data_access.StubDAO;

/**
 *
 * @author marko
 */
public class FileDAOTest {

    private HashMap<String, String> fields = new HashMap<>();
    private StubDAO dao;

    public FileDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        fields.put("author", "pentti");
        fields.put("title", "best book");
        fields.put("publisher", "yolo");
        fields.put("year", "2016");
        fields.put("key", "");
        dao = new StubDAO();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testWritingBookReference() {
        dao.add("book", fields);
    }

    @Test
    public void testWritingReferenceWithWrongType() {
        dao.add("eer", fields);
    }

    @Test
    public void testWritingBookReferenceWithEmptyField() {
        dao.add("book", new HashMap<String, String>());
    }

    @Test
    public void testWritingBookReferenceWithNullField() {
        dao.add("book", null);
    }
}
