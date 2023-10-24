package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MaintainInformation extends JFrame {
    private MaintainProgrammeFrame mpf = new MaintainProgrammeFrame();
    private MaintainStudentFrame msf = new MaintainStudentFrame();
    private JButton jbtProgramme = new JButton("Maintain Programme");
    private JButton jbtStudent = new JButton("Maintain Student");
    
    public MaintainInformation() {
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.add(jbtProgramme);
        panel.add(jbtStudent);
        add(panel);
        
        jbtProgramme.addActionListener(new programmeListener());
        jbtStudent.addActionListener(new studentListener());
    }
    
    private class programmeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mpf.prgFrame();
        }
    }
    
    private class studentListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            msf.stdframe();
        }
    }
    
    public static void main(String[] args) {
        MaintainInformation mi = new MaintainInformation();
        mi.setTitle("Maintain Information");
        mi.pack();
        mi.setLocationRelativeTo(null);
        mi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mi.setVisible(true);
    }
}
