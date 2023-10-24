package Q3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Q3 extends JFrame {
    private SoftwareCollection softwares = new SoftwareCollection();
    // display software and programme names
    private String[] softwareNames;

    // text fields and buttons
    private JTextField jtfName = new JTextField();
    private JTextField jtfID = new JTextField();
    private JButton jbtConfirm = new JButton("Confirm");
    private JButton jbtClear = new JButton("Clear");
    private JButton jbtExit = new JButton("Exit");
    
    // selecting softwares and radio buttons
    private JList jlstSoftware;
    private ButtonGroup group = new ButtonGroup();
    private JRadioButton jrbdia = new JRadioButton("DIA2", false);
    private JRadioButton jrbdib = new JRadioButton("DIB2", false);
    private JRadioButton jrbdit = new JRadioButton("DIT2", false);
    private JRadioButton jrbdst = new JRadioButton("DST2", false);
    
    public Q3() {
        JPanel jpNorth = new JPanel(new GridLayout(2,2));
        jpNorth.add(new JLabel("Name"));
        jpNorth.add(jtfName);
        jpNorth.add(new JLabel("ID"));
        jpNorth.add(jtfID);
        add(jpNorth, BorderLayout.NORTH);

        JPanel jpWest = new JPanel(new GridLayout(5,1));
        jpWest.add(new JLabel("Programme"));
        group.add(jrbdia);
        group.add(jrbdib);
        group.add(jrbdit);
        group.add(jrbdst);
        jpWest.add(jrbdia);
        jpWest.add(jrbdib);
        jpWest.add(jrbdit);
        jpWest.add(jrbdst);
        add(jpWest, BorderLayout.WEST);
        
        softwareNames = softwares.getSoftwareNames();
        jlstSoftware = new JList(softwareNames);
        JPanel jpEast = new JPanel(new GridLayout(2,1));
        jpEast.add(new JLabel("Software"));
        jpEast.add(jlstSoftware);
        add(jpEast, BorderLayout.EAST);
        
        JPanel jpSouth = new JPanel(new FlowLayout());
        jpSouth.add(jbtConfirm);
        jpSouth.add(jbtClear);
        jpSouth.add(jbtExit);
        add(jpSouth, BorderLayout.SOUTH);
        
        // register button listeners
        jbtConfirm.addActionListener(new ConfirmListener());
        jbtClear.addActionListener(new ClearListener());
        jbtExit.addActionListener(e -> {
            dispose(); // exit the frame
        });
    }
    
    // Check Information Frame
    private class ConfirmListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // get text from selected radio button
            JRadioButton selected = null;
            String selectedText;
            if (jrbdia.isSelected()) {
                selected = jrbdia;
            } else if (jrbdib.isSelected()) {
                selected = jrbdib;
            } else if (jrbdit.isSelected()) {
                selected = jrbdit;
            } else if (jrbdst.isSelected()) {
                selected = jrbdst;
            }
            if (selected == null) {
                selectedText = "null"; // display null if no radio buttons selected
            } else {
                selectedText = selected.getText();
            }
            
            if (e.getActionCommand().equals("Confirm")) {
                String name = jtfName.getText();
                String id = jtfID.getText();
                int choose = JOptionPane.showConfirmDialog(null,
                        "Name: " + name +
                        "\nID: " + id +
                        "\nProgramme: " + selectedText +
                        "\nSoftware selected: " + jlstSoftware.getSelectedValuesList(),
                        "Check Information",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
                );
                if (choose == JOptionPane.YES_OPTION) {
                    // display thank you message
                    JOptionPane.showMessageDialog(null, "Thank you");
                }
            }
        }
    }
    
    // Clear the input
    private class ClearListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            jtfName.setText("");
            jtfID.setText("");
            group.clearSelection();
            jlstSoftware.clearSelection();
        }
    }
    
    public static void main(String[] args) {
        Q3 frame = new Q3();
        frame.pack();
        frame.setTitle("CheckOutSystem");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
