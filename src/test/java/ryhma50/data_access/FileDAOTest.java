package ryhma50.data_access;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author marko
 */
public class FileDAOTest {

    private HashMap<String, String> fields = new HashMap<>();
    private StubDAO dao;
    private Scanner reader;

    public FileDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws FileNotFoundException {
        fields.put("author", "pentti");
        fields.put("title", "best book");
        fields.put("publisher", "yolo");
        fields.put("year", "2016");
        fields.put("key", "");
        dao = new StubDAO();
        reader = new Scanner(new File("src/test/resources/write_file_test.txt"));
    }

    @After
    public void tearDown() throws IOException {
        FileWriter writer = new FileWriter(new File("src/test/resources/write_file_test.txt"));
        writer.write(""); // tyhjentää tiedoston
        writer.close();
    }

    @Test
    public void testWritingBookReference() {
        dao.add("book", fields);
        String firstLine = reader.nextLine();
        String secondLine = reader.nextLine();
        assertEquals("@book{", firstLine);
        assertEquals("year = {2016},", secondLine);
    }

    @Test
    public void testWritingReferenceWithWrongType() {
        dao.add("eer", fields);
        File file = new File("src/test/resources/write_file_test.txt");
        assertTrue(file.length() == 0);
    }

    @Test
    public void testWritingBookReferenceWithEmptyField() {
        dao.add("book", new HashMap<String, String>());
        File file = new File("src/test/resources/write_file_test.txt");
        assertTrue(file.length() == 0);
    }

    @Test
    public void testWritingBookReferenceWithNullField() {
        dao.add("book", null);
        File file = new File("src/test/resources/write_file_test.txt");
        assertTrue(file.length() == 0);
    }
}
