package ui;

import control.MaintainProgrammeControl;
import domain.Programme;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MaintainProgrammeFrame extends JFrame {
    private MaintainProgrammeControl progControl;
    private JTextField jtfCode = new JTextField();
    private JTextField jtfName = new JTextField();
    private JTextField jtfFaculty = new JTextField();
    private JButton jbtAdd = new JButton("Create");
    private JButton jbtRetrieve = new JButton("Retrieve");
    private JButton jbtUpdate = new JButton("Update");
    private JButton jbtDelete = new JButton("Delete");

    public MaintainProgrammeFrame() {
        progControl = new MaintainProgrammeControl();
        
        JPanel jpCenter = new JPanel(new GridLayout(3, 2));
        jpCenter.add(new JLabel("Programme Code"));
        jpCenter.add(jtfCode);
        jpCenter.add(new JLabel("Programme Name"));
        jpCenter.add(jtfName);
        jpCenter.add(new JLabel("Faculty"));
        jpCenter.add(jtfFaculty);
        add(jpCenter);

        JPanel jpSouth = new JPanel();
        jpSouth.add(jbtAdd);
        jpSouth.add(jbtRetrieve);
        jpSouth.add(jbtUpdate);
        jpSouth.add(jbtDelete);
        add(jpSouth, BorderLayout.SOUTH);

        jbtRetrieve.addActionListener(new RetrieveListener());
        jbtAdd.addActionListener(new insertListener());
        jbtUpdate.addActionListener(new updateListener());
        jbtDelete.addActionListener(new deleteListener());
    }
    
    public void clearTextField(){
        jtfCode.setText("");
        jtfName.setText("");
        jtfFaculty.setText("");
    }

    private class RetrieveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String code = jtfCode.getText();
            Programme programme = progControl.selectRecord(code);
            if (programme != null) {
                jtfName.setText(programme.getName());
                jtfFaculty.setText(programme.getFaculty());
            } else {
                JOptionPane.showMessageDialog(null, "No such programme code.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private class insertListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String code = jtfCode.getText();
            Programme programme = progControl.selectRecord(code);

            if (programme!=null) {
                JOptionPane.showMessageDialog(null, "This code already existed", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            else {
                programme = new Programme(code, jtfName.getText(), jtfFaculty.getText());
                //to execute update
                progControl.addRecord(programme);
                JOptionPane.showMessageDialog(null, "New code added.");
                clearTextField();
            }
        }
    }
    
    private class updateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String code = jtfCode.getText();
            Programme programme = progControl.selectRecord(code);
            if (programme!=null) {
                programme = new Programme(code, jtfName.getText(), jtfFaculty.getText());
                progControl.updateRecord(programme);
                JOptionPane.showMessageDialog(null, "Record Updated.");
                clearTextField();
            }
            else {
                JOptionPane.showMessageDialog(null, "No such programme code.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private class deleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String code = jtfCode.getText();
            Programme programme = progControl.selectRecord(code);
            if (programme != null) {
                progControl.deleteRecord(code);
                JOptionPane.showMessageDialog(null, "Record Deleted.");
                clearTextField();
            } else {
                JOptionPane.showMessageDialog(null, "No such programme code.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void prgFrame() {
          MaintainProgrammeFrame frm=new MaintainProgrammeFrame();   
          frm.setTitle("Programme CRUD");
          frm.setSize(600, 200);
          frm.setLocationRelativeTo(null);
          frm.setVisible(true);
    }
}