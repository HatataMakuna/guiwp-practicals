/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author harch
 */
// Practical 1 Question 2
import javax.swing.*;
public class OneFrame extends JFrame {
    public OneFrame() {
        setTitle("One Frame");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        OneFrame myFrame = new OneFrame(); // OR new OneFrame();
    }
}
