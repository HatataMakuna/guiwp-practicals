package ui;

import control.MaintainProgramme;
import domain.Programme;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
public class ProgrammeFrame extends JFrame {
    private MaintainProgramme progControl = new MaintainProgramme();
    private ArrayList<Programme> list = progControl.getAll();
    private JTextField jtfName = new JTextField();
    private JTextField jtfFaculty = new JTextField();
    private JComboBox choice = new JComboBox();
    
    public ProgrammeFrame() {
        jtfName.setEditable(false);
        jtfFaculty.setEditable(false);
        list.forEach((lists) -> {
            choice.addItem(lists.getCode());
        });
        add(choice, BorderLayout.NORTH);
        
        JPanel jpCenter = new JPanel(new GridLayout(2,2));
        jpCenter.add(new JLabel("Programme name"));
        jpCenter.add(jtfName);
        jpCenter.add(new JLabel("Faculty"));
        jpCenter.add(jtfFaculty);
        add(jpCenter, BorderLayout.CENTER);
        
        choice.addItemListener(new ChoiceListener());
    }
    
    public class ChoiceListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent ie) {
            Programme currecord = progControl.selectRecord((String)choice.getSelectedItem());
            jtfName.setText(currecord.getName());
            jtfFaculty.setText(currecord.getFaculty());
        }
    }
    
    public static void main(String[] args) {
        ProgrammeFrame frame = new ProgrammeFrame();
        frame.pack();
        frame.setTitle("Search Programme");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
