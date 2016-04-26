package references;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marko
 */
public class ArticleTest {

    private EntryType article;
    private final String TITLE = "title";
    private final String YEAR = "year";
    private final String AUTHOR = "author";
    private final String PUBLISHER = "publisher";
    private final String TITLETARGET = "herra hanurin sikailut";
    private final String YEARTARGET = "1993";
    private final String AUTHORTARGET = "loladin";
    private final String PUBLISHERTARGET = "Iso B";

    @Before
    public void setUp() {
        article = new Article();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void hasCorrectNeccesaryHeaders() {
        assertTrue("Does't contain correct headers", (article.returnAllHeaders().contains(TITLE)
                || article.returnAllHeaders().contains(AUTHOR))
                || article.returnAllHeaders().contains(TITLE)
                || article.returnAllHeaders().contains(YEAR));

        assertEquals(article.returnNecessaryHeaders().size(), 5);
    }

    @Test
    public void hasCorrectOptionalHeaders() {
        assertEquals(article.returnOptionalHeaders().size(), 5);
    }

    @Test
    public void getEntryTypeReturnsCorrectType() {
        assertEquals("article", article.getEntryType());
    }
}
