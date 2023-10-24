/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author harch
 */
// P2Q4
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
public class MaintainStudentsFrame extends JFrame {
    // declare array list object
    private ArrayList<String> students = new ArrayList<>();
    // declare all buttons in private variable
    private JButton createBtn = new JButton("Create");
    private JButton retrieveBtn = new JButton("Retrieve");
    private JButton updateBtn = new JButton("Update");
    private JButton deleteBtn = new JButton("Delete");
    public MaintainStudentsFrame() {
        // create main frame
        setLayout(new FlowLayout());
        
        // add 4 buttons to the frame
        add(createBtn);
        add(retrieveBtn);
        add(updateBtn);
        add(deleteBtn);
        
        // register listeners
        createBtn.addActionListener(new Create());
        retrieveBtn.addActionListener(new Retrieve());
        updateBtn.addActionListener(new Update());
        deleteBtn.addActionListener(new Delete());
        
        // use the 5 elements of frame
        setTitle("Maintain Students");
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    // main method
    public static void main(String[] args) {
        new MaintainStudentsFrame();
    }
    
    // create all listeners (any); Recommended: individual class for each button to avoid confusion
    private class Create implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = JOptionPane.showInputDialog("Enter new student's name:");
            if (name != null) {
                students.add(name);
            }
        }
    }
    private class Retrieve implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            StringBuilder stud = new StringBuilder();
            if (students.size() == 0) {
                JOptionPane.showMessageDialog(null, "No student in system");
            }
            else {
                for (int i = 0; i < students.size(); i++) {
                    stud.append(i).append(1).append(". ").append(students.get(i)).append("\n");
                }
                JOptionPane.showMessageDialog(null, stud);
            }
        }
    }
    private class Update implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // ask for student name
            String name = JOptionPane.showInputDialog("Enter name: ");

            if (name != null) {
                int selected = getStudent(name);

                if (selected == -1) {
                    JOptionPane.showMessageDialog(null, "Can't find " + name,
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    // ask for new student name
                    String newName = JOptionPane.showInputDialog("Enter new name: ");
                    // change name
                    students.set(selected, newName);
                    // display change
                    JOptionPane.showMessageDialog(null,
                            name + " changed to " + newName, "Confirmation",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }
    private int getStudent(String name) {
        int selected = -1;
        if (students.size() == 0) {
            return -1;
        }
        for (int i = 0; i < students.size(); i++) {
            if (name.equals(students.get(i))) {
                selected = i;
                break;
            }
        }
        return selected;
    }
    private class Delete implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // ask for student name
            String name = JOptionPane.showInputDialog("Enter name: ");
            int stud = getStudent(name);

            if (name == null) {
                return;
            }

            if (stud == -1) {
                JOptionPane.showMessageDialog(null, "Can't find " + name,
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                students.remove(stud);
            }
        }
    }
}
