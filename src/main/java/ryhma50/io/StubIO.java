package ryhma50.io;

import java.util.ArrayList;

/**
 *
 * @author marko
 */
public class StubIO implements IO {

    private String[] lines;
    private int i;
    private ArrayList<String> prints;

    public StubIO(String... values) {
        this.lines = values;
        prints = new ArrayList<>();
    }

    @Override
    public void print(String toPrint) {
        prints.add(toPrint);
    }

    @Override
    public int readInt(String prompt) {
        print(prompt);
        return Integer.parseInt(lines[i++]);
    }

    @Override
    public String readLine(String prompt) {
        print(prompt);
        if (i < lines.length) {
            return lines[i++];
        }
        return "";
    }

    public ArrayList<String> getPrints() {
        return prints;
    }

}
