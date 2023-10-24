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
public class P1Q4 extends JFrame {
    public P1Q4() {
        JPanel p1 = new JPanel();
        p1.add(new JButton("Button 1"));
        p1.add(new JButton("Button 2"));
        
        JPanel p2 = new JPanel();
        p2.add(new JButton("Button 3"));
        p2.add(new JButton("Button 4"));
        
        add(p1);
        add(p2);
        
        setLayout(new FlowLayout());
        setTitle("Question 5");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        P1Q4 test = new P1Q4();
    }
}
