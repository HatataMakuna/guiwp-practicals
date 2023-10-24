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

public class TestPanels extends JFrame {
    public TestPanels() {
        JPanel buttonPanel = new JPanel();

        buttonPanel.setLayout(new GridLayout(4, 3));
        for (int i = 1; i <= 9; i++) {
            buttonPanel.add(new JButton("" + i));
        }

        buttonPanel.add(new JButton("0"));
        buttonPanel.add(new JButton("Start"));
        buttonPanel.add(new JButton("Stop"));

        JPanel controlPanel = new JPanel(new BorderLayout());
        controlPanel.add(new JTextField("Time to be displayed here"),BorderLayout.NORTH);

        controlPanel.add(buttonPanel, BorderLayout.CENTER);

        add(controlPanel, BorderLayout.EAST);
        add(new JButton("Food to be placed here"), BorderLayout.CENTER);

        setTitle("The Front View of a Microwave Oven");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        TestPanels frame = new TestPanels();
    }
}