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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class P2Q2 extends JFrame {
    private JButton red = new JButton("Red");
    private JButton green = new JButton("Green");
    private JButton blue = new JButton("Blue");
    private JLabel color = new JLabel("COLOR");
    private JPanel button = new JPanel(new FlowLayout());
    public P2Q2() {
        ColorChanger change = new ColorChanger();
        color.setHorizontalAlignment(JLabel.CENTER);
        color.setFont(new Font("Cambria", Font.BOLD, 20));
        add(color, BorderLayout.NORTH);
        button.add(red);
        button.add(green);
        button.add(blue);
        add(button, BorderLayout.CENTER);
        
        // listeners
        red.addActionListener(change);
        green.addActionListener(change);
        blue.addActionListener(change);
    }
    
    public static void main(String[] args) {
        P2Q2 frame = new P2Q2();
        frame.setTitle("Primary Colors");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    private class ColorChanger implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == red) {
                color.setForeground(Color.RED);
            } else if (e.getSource() == green) {
                color.setForeground(Color.GREEN);
            } else if (e.getSource() == blue) {
                color.setForeground(Color.BLUE);
            }
        }
    }
}
