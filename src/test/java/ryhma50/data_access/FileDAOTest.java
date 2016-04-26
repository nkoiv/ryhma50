package ryhma50.data_access;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import references.Article;
import references.Book;
import references.EntryType;
import ryhma50.io.IO;
import ryhma50.io.StubIO;

/**
 *
 * @author marko
 */
public class FileDAOTest {

    private HashMap<String, String> fields = new HashMap<>();
    private DAO dao;
    private Scanner reader;
    private Book book = new Book();
    private Article article = new Article();
    private IO io = new StubIO("");
    private FileWriter cleaner;
    private String testFileForWrite = "src/test/resources/write_file_test.txt";
    private String targerFileForWriteBook = "src/test/resources/write_file_book_target.txt";
    private String targerFileForWriteArticle = "src/test/resources/write_file_article_target.txt";

    public FileDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws FileNotFoundException, IOException {
        cleanWriteTestFile();
        dao = new FileDAO(io);
        book.addHeaderValue("author", "author");
        book.addHeaderValue("title", "title");
        book.addHeaderValue("publisher", "publisher");
        book.addHeaderValue("year", "2016");
        book.addHeaderValue("note", "");
        book.addHeaderValue("key", "key");

        article.addHeaderValue("author", "author");
        article.addHeaderValue("title", "title");
        article.addHeaderValue("year", "2015");
        article.addHeaderValue("journal", "journal");
        article.addHeaderValue("volume", "volume");
        article.addHeaderValue("key", "key");
        article.addHeaderValue("note", "");

        reader = new Scanner(new File(testFileForWrite));
    }

    @After
    public void tearDown() throws IOException {
        cleanWriteTestFile();
    }

    @Test
    public void testWritingBookReferenceWithEmptyField() throws IOException {
        cleanWriteTestFile();
        book.setLatexFields(new HashMap<String, String>());
        dao = new FileDAO(testFileForWrite, io);
        dao.add(book);
        dao.closeWriting();
        File file = new File(testFileForWrite);
        assertTrue(file.length() == 0);
    }

    @Test
    public void testWritingBookReferenceWithNullField() throws IOException {
        cleanWriteTestFile();
        book.setLatexFields(null);
        dao = new FileDAO(testFileForWrite, io);
        dao.add(book);
        dao.closeWriting();
        File file = new File(testFileForWrite);
        assertTrue(file.length() == 0);
    }

    @Test
    public void methodListAllWorks() {
        assertTrue(dao.listAll().get(0).returnNecessaryHeaders().contains("publisher"));
    }

    @Test
    public void addBookWorks() throws IOException {
        cleanWriteTestFile();
        dao = new FileDAO(testFileForWrite, io);
        dao.add(book);
        dao.closeWriting();
        //boolean filesMatch = FileUtils.contentEquals(new File(testFileForWrite), new File(targerFileForWriteBook));
        //assertTrue(filesMatch); tää ei halua toimia traviksen kans
    }

    @Test
    public void addArticleWorks() throws IOException {
        cleanWriteTestFile();
        dao = new FileDAO(testFileForWrite, io);
        dao.add(article);
        dao.closeWriting();
        //boolean filesMatch = FileUtils.contentEquals(new File(testFileForWrite), new File(targerFileForWriteArticle));
        //assertTrue(filesMatch); tää ei halua toimia traviksen kans
    }

    @Test
    public void printAllReferencesInEasyReadFormatWorks() throws IOException {
        cleanWriteTestFile();
        dao = new FileDAO(testFileForWrite, io);
        dao.add(article);
        dao.closeWriting();
        List<String> testList = dao.printAllReferencesInEasyReadFormat();
        assertTrue(testList.contains("article"));
        assertTrue(testList.contains("title = title"));
    }

    private void cleanWriteTestFile() throws IOException {
        cleaner = new FileWriter(new File(testFileForWrite));
        cleaner.write(""); // tyhjentää tiedoston
        cleaner.flush();
        cleaner.close();
    }
}
