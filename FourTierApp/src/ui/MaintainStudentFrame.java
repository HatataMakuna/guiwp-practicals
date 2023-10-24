package ui;

import control.MaintainStudentControl;
import domain.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MaintainStudentFrame extends JFrame {
    private MaintainStudentControl stdControl;
    private JTextField jtfStudentID = new JTextField();
    private JTextField jtfStudentIC = new JTextField();
    private JTextField jtfStudentName = new JTextField();
    private JTextField jtfLevel = new JTextField();
    private JTextField jtfProgrammeCode = new JTextField();
    private JTextField jtfYear = new JTextField();
    private JButton jbtAdd = new JButton("Create");
    private JButton jbtRetrieve = new JButton("Retrieve");
    private JButton jbtUpdate = new JButton("Update");
    private JButton jbtDelete = new JButton("Delete");

    public MaintainStudentFrame() {
        stdControl = new MaintainStudentControl();
        
        JPanel jpCenter = new JPanel(new GridLayout(6, 2));
        jpCenter.add(new JLabel("Student ID"));
        jpCenter.add(jtfStudentID);
        jpCenter.add(new JLabel("Student IC"));
        jpCenter.add(jtfStudentIC);
        jpCenter.add(new JLabel("Student Name"));
        jpCenter.add(jtfStudentName);
        jpCenter.add(new JLabel("Level"));
        jpCenter.add(jtfLevel);
        jpCenter.add(new JLabel("Programme Code"));
        jpCenter.add(jtfProgrammeCode);
        jpCenter.add(new JLabel("Year"));
        jpCenter.add(jtfYear);
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
        jtfStudentID.setText("");
        jtfStudentIC.setText("");
        jtfStudentName.setText("");
        jtfLevel.setText("");
        jtfProgrammeCode.setText("");
        jtfYear.setText("");
    }

    private class RetrieveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = jtfStudentID.getText();
            Student student = stdControl.selectRecord(id);
            if (student != null) {
                jtfStudentIC.setText(student.getIc());
                jtfStudentName.setText(student.getName());
                jtfLevel.setText(Character.toString(student.getLevel()));
                jtfProgrammeCode.setText(student.getProgrammeCode());
                jtfYear.setText(Integer.toString(student.getYear()));
            } else {
                JOptionPane.showMessageDialog(null, "No such student ID.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private class insertListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = jtfStudentID.getText();
            Student student = stdControl.selectRecord(id);

            if (student!=null) {
                JOptionPane.showMessageDialog(null, "This student ID already existed", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            else {
                student = new Student(id, jtfStudentIC.getText(), jtfStudentName.getText(), (jtfLevel.getText()).charAt(0),
                        new Programme(jtfProgrammeCode.getText()), Integer.parseInt(jtfYear.getText()));
                stdControl.addRecord(student);
                JOptionPane.showMessageDialog(null, "New student added.");
                clearTextField();
            }
        }
    }
    
    private class updateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = jtfStudentID.getText();
            Student student = stdControl.selectRecord(id);
            if (student!=null) {
                student = new Student(id, jtfStudentIC.getText(), jtfStudentName.getText(), (jtfLevel.getText()).charAt(0),
                        new Programme(jtfProgrammeCode.getText()), Integer.parseInt(jtfYear.getText()));
                stdControl.updateRecord(student);
                JOptionPane.showMessageDialog(null, "Record Updated.");
                clearTextField();
            }
            else {
                JOptionPane.showMessageDialog(null, "No such student ID.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private class deleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String code = jtfStudentID.getText();
            Student student = stdControl.selectRecord(code);
            if (student != null) {
                stdControl.deleteRecord(code);
                JOptionPane.showMessageDialog(null, "Record Deleted.");
                clearTextField();
            } else {
                JOptionPane.showMessageDialog(null, "No such student ID.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void stdframe() {
          MaintainStudentFrame frm=new MaintainStudentFrame();   
          frm.setTitle("Student CRUD");
          frm.setSize(600, 200);
          frm.setLocationRelativeTo(null);
          frm.setVisible(true);
    }
}