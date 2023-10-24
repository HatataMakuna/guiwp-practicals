/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author harch
 */
// P3Q1
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class simpleCalculator extends JFrame {
    private JLabel label1 = new JLabel("First number: ");
    private JLabel label2 = new JLabel("Second number: ");
    private JLabel label3 = new JLabel("Result: ");
    private JButton button1 = new JButton("Add");
    private JButton button2 = new JButton("Subtract");
    private JButton button3 = new JButton("Multiply");
    private JButton button4 = new JButton("Divide");
    private JTextField tf1 = new JTextField(10);
    private JTextField tf2 = new JTextField(10);
    private JTextField tf3 = new JTextField(10);
    
    public simpleCalculator() {
        tf3.setEditable(false);
        JPanel p1 = new JPanel(new GridLayout(3,2));
        p1.add(label1);
        p1.add(tf1);
        p1.add(label2);
        p1.add(tf2);
        p1.add(label3);
        p1.add(tf3);
        
        JPanel p2 = new JPanel();
        p2.add(button1);
        p2.add(button2);
        p2.add(button3);
        p2.add(button4);
        
        button1.addActionListener(new buttonListener());
        button2.addActionListener(new buttonListener());
        button3.addActionListener(new buttonListener());
        button4.addActionListener(new buttonListener());
        
        button1.setMnemonic('A');
        
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
        setTitle("Calculator");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new simpleCalculator();
    }
    
    public void clear() {
        tf1.setText("");
        tf2.setText("");
        tf3.setText("");
        tf1.grabFocus();
    }
    
    class buttonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double firstVal = Double.parseDouble(tf1.getText());
                double secVal = Double.parseDouble(tf2.getText());
                double result = 0;
                if (e.getSource() == button1) {
                    result = firstVal + secVal;
                } else if (e.getSource() == button2) {
                    result = firstVal - secVal;
                } else if (e.getSource() == button3) {
                    result = firstVal * secVal;
                } else if (e.getSource() == button4) {
                    result = firstVal / secVal;
                }
                tf3.setText(""+result);
            } catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Non-numeric value", "ERROR", JOptionPane.ERROR_MESSAGE);
                clear();
            }
        }
    }
}