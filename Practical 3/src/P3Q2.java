/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author harch
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
public class P3Q2 extends JFrame {
    private JLabel label1 = new JLabel("Array Index ");
    private JLabel label2 = new JLabel("Array Element ");
    private JButton button = new JButton("Show Element");
    private JTextField tf1 = new JTextField(10);
    private JTextField tf2 = new JTextField(10);
    
    public P3Q2() {
        // p1 -> textfield and tables (grid layout)
        JPanel p1 = new JPanel(new GridLayout(2,2));
        p1.add(label1);
        p1.add(tf1);
        p1.add(label2);
        p1.add(tf2);
        
        // p2 -> button (border layout)
        JPanel p2 = new JPanel(new BorderLayout());
        p2.add(button, BorderLayout.CENTER);
        
        // register the listener
        button.addActionListener(new P3Q2.buttonListener());
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
        tf2.setEditable(false);
        setTitle("Display: Show Bounds Error");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new P3Q2();
    }
    
    // create listener class for button
    class buttonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Random rand = new Random();
            int length = 101;
            int[] array = new int[length];
            int min = 1000;
            int max = 9999;
            for (int index = 0; index < length; index++) {
                array[index] = rand.nextInt(max - min) + min;
            }
            try {
                int arrayIndex = Integer.parseInt(tf1.getText());
                if (e.getSource() == button) {
                    tf2.setText(array[arrayIndex] + "");
                    }
            } catch(ArrayIndexOutOfBoundsException ex) {
                tf2.setText("Out of Bounds");
            }
        }
    }
}
