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
import javax.swing.*;
public class P1Q5 extends JFrame {
    public P1Q5() {
        JPanel p1 = new JPanel(new GridLayout(1, 2));
        p1.add(new JButton("Button 1"));
        p1.add(new JButton("Button 2"));
        
        JPanel p2 = new JPanel(new GridLayout(1, 2));
        p2.add(new JButton("Button 3"));
        p2.add(new JButton("Button 4"));
        
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
        
        setTitle("Question 5");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        P1Q5 test = new P1Q5();
    }
}
