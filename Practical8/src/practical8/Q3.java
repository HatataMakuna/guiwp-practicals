/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practical8;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Q3 extends JFrame {
    Q2 q2frame = new Q2();
    private JTextField jtf1 = new JTextField();
    private JPasswordField jtf2 = new JPasswordField();
    private JButton jbt1 = new JButton("Login");
    private JButton jbt2 = new JButton("Reset");
    
    public Q3() {
        JPanel jp = new JPanel(new GridLayout(2,2));
        jp.add(new JLabel("User name"));
        jp.add(jtf1);
        jp.add(new JLabel("Password"));
        jp.add(jtf2);
        jtf2.setEchoChar('*');
        add(jp, BorderLayout.CENTER);
        
        JPanel jpFlow = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        jpFlow.add(jbt1);
        jpFlow.add(jbt2);
        add(jpFlow, BorderLayout.SOUTH);
        
        // listener for login button
        jbt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = "nbuser";
                String password = "nbuser";
                String inputUsername = jtf1.getText();
                String inputPassword = jtf2.getText();
                
                if (inputUsername.equals(username) && inputPassword.equals(password)) {
                    JOptionPane.showMessageDialog(null, "You have successfully logged in", "Success", JOptionPane.INFORMATION_MESSAGE);
                    q2frame.Q2Frame();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        // listener for reset button
        jbt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtf1.setText("");
                jtf2.setText("");
            }
        });
    }
    
    public static void main(String[] args) {
        Q3 frame = new Q3();
        frame.setTitle("Login");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
