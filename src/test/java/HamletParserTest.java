import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        Pattern pattern = Pattern.compile("Hamlet", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletText);

        hamletParser.changeHamletToLeon;


        Assert.assertFalse(matcher.find());
    }

    @Test
    public void testChangeHoratioToTariq() {
        Pattern pattern = Pattern.compile("Horatio", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletText);

        hamletParser.changeHoratioToTariq;

        Assert.assertFalse(matcher.find());
    }

    @Test
    public void testFindHoratio() {
        int expected = 158;

        int actual = hamletParser.findHoratio();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHamlet() {
        int expected = 472;

        int actual = hamletParser.findHamlet();

        Assert.assertEquals(expected, actual);
    }
}