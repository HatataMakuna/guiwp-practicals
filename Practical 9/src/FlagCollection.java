
import javax.swing.*;

public class FlagCollection {

    private Flag[] flagArr;

    public FlagCollection() {
        flagArr = initializeFlags();
    }

    // method that hardcodes creation of flag objects for testing purposes 
    public Flag[] initializeFlags() {
        Flag[] flagArr = {new Flag("Canada", new ImageIcon(getClass().getResource("images/canada.gif")), "The Canadian national flag ... "),
            new Flag("China", new ImageIcon(getClass().getResource("images/china.gif")), "Description for China ... "),
            new Flag("Denmark", new ImageIcon(getClass().getResource("images/denmark.gif")), "Description for Denmark ... "),
            new Flag("France", new ImageIcon(getClass().getResource("images/france.gif")), "Description for France ... "),
            new Flag("Germany", new ImageIcon(getClass().getResource("images/germany.gif")), "Description for Germany ... "),
            new Flag("India", new ImageIcon(getClass().getResource("images/india.gif")), "Description for India ... "),
            new Flag("Malaysia", new ImageIcon(getClass().getResource("images/malaysia.gif")), "Description for Malaysia ... "),
            new Flag("Norway", new ImageIcon(getClass().getResource("images/norway.gif")), "Description for Norway ... "),
            new Flag("United Kingdom", new ImageIcon(getClass().getResource("images/uk.gif")), "Description for UK ... "),
            new Flag("United States of America", new ImageIcon(getClass().getResource("images/us.gif")), "Description for US ... ")};
        return flagArr;
    }

    public String[] getFlagNames() {
        String[] flagNames = new String[flagArr.length];
        for (int i = 0; i < flagArr.length; ++i) {
            flagNames[i] = flagArr[i].getName();
        }
        return flagNames;
    }

    public Flag get(int index) {
        return flagArr[index];
    }
}