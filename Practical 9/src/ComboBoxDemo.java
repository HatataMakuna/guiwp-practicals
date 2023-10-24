
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComboBoxDemo extends JFrame {

    private String[] flagTitles = {"Canada", "China", "Denmark", "Malaysia"};
    private JComboBox jcbo = new JComboBox(flagTitles);
    private ImageIcon[] flagImage = {
        new ImageIcon(getClass().getResource("images/canada.gif")),
        new ImageIcon(getClass().getResource("images/china.gif")),
        new ImageIcon(getClass().getResource("images/denmark.gif")),
        new ImageIcon(getClass().getResource("images/malaysia.gif"))};
    private String[] desc = {
        "The Canadian national flag...",
        "Description for China ... ",
        "The Denmark national  flag ... ",
        "Malaysia national flag has  ... "};
    private JLabel jblImage = new JLabel();
    private JTextArea jtaDescription = new JTextArea();
   

    public ComboBoxDemo() {
        jtaDescription.setLineWrap(true);
        jtaDescription.setWrapStyleWord(true);
        jtaDescription.setEditable(false);
        // Create a scroll pane to hold the text area
        JScrollPane scrollPane = new JScrollPane(jtaDescription);
        
        JPanel p1= new JPanel(new BorderLayout());
        p1.add(jblImage, BorderLayout.WEST);
        p1.add(scrollPane, BorderLayout.CENTER);

        add(jcbo, BorderLayout.NORTH);
        add(p1, BorderLayout.CENTER);
        setDisplay(0);
        
        jcbo.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                setDisplay(jcbo.getSelectedIndex());
                
            }
        });

    }
     public void setDisplay(int index) {
        jblImage.setIcon(flagImage[index]);
        jtaDescription.setText(desc[index]);
    }
     
    public static void main(String[] args) {
        ComboBoxDemo frame = new ComboBoxDemo();
        frame.pack();
        frame.setTitle("ComboBoxDemo");
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
