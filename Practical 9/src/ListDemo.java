
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListDemo extends JFrame {

    private FlagCollection flags = new FlagCollection();
    // Declare an array of Strings for flag titles
    private String[] flagTitles;
    // The list for selecting countries
    private JList jlst;
    // Arrays of labels for displaying images
    private JLabel[] jlblImageViewer;

    public static void main(String[] args) {
        ListDemo frame = new ListDemo();
        frame.setSize(650, 500);
        frame.setTitle("ListDemo");
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public ListDemo() {
        flagTitles = flags.getFlagNames();
        jlst = new JList(flagTitles);
        jlblImageViewer = new JLabel[flagTitles.length];

        // Create a panel to hold nine labels
        JPanel p = new JPanel(new GridLayout(3, 3, 5, 5));

        for (int i = 0; i < flagTitles.length; i++) {
            p.add(jlblImageViewer[i] = new JLabel());
            jlblImageViewer[i].setHorizontalAlignment(SwingConstants.CENTER);
        }

        // Add p and the list to the frame
        add(p, BorderLayout.CENTER);
        add(new JScrollPane(jlst), BorderLayout.WEST);

        // Register listeners
        jlst.addListSelectionListener(new ListSelectionListener() {
            /**
             * Handle list selection
             */
            public void valueChanged(ListSelectionEvent e) {
                // Get selected indices
                int[] indices = jlst.getSelectedIndices();

                int i;
                // Set icons in the labels
                for (i = 0; i < indices.length; i++) {
                    jlblImageViewer[i].setIcon(flags.get(indices[i]).getImageIcon());
                }

                // Remove icons from the rest of the labels
                for (; i < flagTitles.length; i++) {
                    jlblImageViewer[i].setIcon(null);
                }
            }
        });
    }
}
