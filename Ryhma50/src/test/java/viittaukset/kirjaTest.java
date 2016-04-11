package viittaukset;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ola
 */
public class kirjaTest {
    private Viittaus book;
    private final String TITLE = "title";
    private final String YEAR = "year";
    private final String AUTHOR = "author";
    private final String PUBLISHER = "publisher";
    private final String TITLETARGET = "herra hanurin sikailut";
    private final String YEARTARGET = "1993";
    private final String AUTHORTARGET = "loladin";
    private final String PUBLISHERTARGET = "Iso B";
    
    public kirjaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        book = new Kirja();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void hasCorrectHeaders() {
        assertTrue("Does't contain correct headers", (book.returnHeaders().contains(TITLE) ||
        book.returnHeaders().contains(AUTHOR)) ||
        book.returnHeaders().contains(PUBLISHER) ||
        book.returnHeaders().contains(YEAR));
        
        assertEquals("Additional headers", book.returnHeaders().size(), 4);
        
    }
    
    @Test
    public void savesAllAndNothingButNeeded() {
        HashMap<String, String> dataInput = new HashMap<>();
        dataInput.put(TITLE, TITLETARGET);
        dataInput.put(YEAR, YEARTARGET);
        dataInput.put(PUBLISHER, PUBLISHERTARGET);
        dataInput.put(AUTHOR, AUTHORTARGET);
        dataInput.put("ylimääräistä", "paskaa");
        book.saveAll(dataInput);
        Map<String,String> dataOutput = book.returnFields();
        assertEquals("Väärä otsikko", TITLETARGET, dataOutput.get(TITLE));
        assertEquals( "Väärä vuosi", YEARTARGET, dataOutput.get(YEAR));
        assertEquals("Väärä publisher", PUBLISHERTARGET, dataOutput.get(PUBLISHER));
        assertEquals("Väärä author", AUTHORTARGET, dataOutput.get(AUTHOR));
        assertEquals("Ylimääräistä tavaraa", null, dataOutput.get("ylimääräistä"));
        
       
    }
    
    @Test
    public void lol2() {
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
