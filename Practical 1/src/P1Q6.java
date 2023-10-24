/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author harch
 */
import javax.swing.*;
import java.awt.*;
public class P1Q6 extends JPanel {
    public P1Q6() {
        
    }
    public P1Q6(String button1, String button2) {
        setLayout(new GridLayout(1,2));
        add(new JButton(button1));
        add(new JButton(button2));
    }
}
