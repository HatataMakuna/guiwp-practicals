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
public class HandleEvent extends JFrame {
    private JButton jbtOK = new JButton("OK");
    private JButton jbtCancel = new JButton("Cancel");
    public HandleEvent() {
        setLayout(new FlowLayout());
        add(jbtOK);
        add(jbtCancel);
        jbtOK.addActionListener(new OKListenerClass()); // new AllListenerClass
        jbtCancel.addActionListener(new CancelListenerClass()); // new AllListenerClass
    }
    public static void main(String[] args) {
        HandleEvent frame =new HandleEvent();
        frame.setTitle("Handle Event");
        frame.setSize(250, 100);
        frame.setLocation(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    /*private class AllListenerClass implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jbtOK) {
                JOptionPane.showMessageDialog(null, "OK button clicked");
            }
            else if (e.getSource() == jbtCancel) {
                JOptionPane.showMessageDialog(null, "Cancel button clicked");
            }
        }
    }*/
}
class OKListenerClass implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "OK button clicked");
    }
}
class CancelListenerClass implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Cancel button clicked.");
    }
}