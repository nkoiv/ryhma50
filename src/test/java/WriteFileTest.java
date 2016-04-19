
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ryhma50.WriteFile;

/**
 *
 * @author marko
 */
public class WriteFileTest {

    private String fileName = "src/test/resources/write_file_test.txt";
    private HashMap<String, String> fields = new HashMap<>();
    private WriteFile writer;

    public WriteFileTest() {

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
        writer = new WriteFile(fileName, fields);
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testWritingBookReference() {
        writer.add();
    }

    @Test
    public void testConstructorCatch() throws Exception {
    
    }
}
