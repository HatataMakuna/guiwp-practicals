/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author harch
 */
// Practical 1 Question 3
import javax.swing.*;
import java.awt.GridLayout;
// import java.awt.FlowLayout;
public class StudentInfoFrame extends JFrame {
    private JButton jbtSubmit = new JButton("Submit");
    public StudentInfoFrame() {
        setLayout(new GridLayout());
        // setLayout(new FlowLayout());
        // OR etLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
        
        // Label and text fields
        add(new JLabel("Registration number: "));
        add(new JTextField(8));
        add(new JLabel("Name: "));
        add(new JTextField(8));
        add(new JLabel("Programme code: "));
        add(new JTextField(8));
        
        add(jbtSubmit);
        
        // Configuration
        setTitle("Student Information");
        //setSize(350, 350);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        StudentInfoFrame myFrame = new StudentInfoFrame();
    }
}