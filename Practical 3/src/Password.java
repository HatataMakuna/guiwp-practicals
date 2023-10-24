// P3Q4
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Password extends JFrame {
    private JLabel enter = new JLabel("Enter your password: ");
    private JLabel empty = new JLabel("Invalid password: Password cannot be null or an empty string.");
    private JLabel letter = new JLabel("Your password should have at least 1 letter.");
    private JLabel digit = new JLabel("Your password should have at least 1 digit.");
    private JLabel alpha = new JLabel("Your password should have at least 7 alpha-numeric characters.");
    private JLabel valid = new JLabel("Congratulations! Your password is valid.");
    private JPasswordField input = new JPasswordField(10);
    private JButton submit = new JButton("Submit");
    private JPanel flow = new JPanel(new FlowLayout());
    private JPanel br = new JPanel();

    public Password() {
        enter.setHorizontalAlignment(JLabel.LEFT);
        empty.setForeground(Color.RED);
        letter.setForeground(Color.RED);
        digit.setForeground(Color.RED);
        alpha.setForeground(Color.RED);
        valid.setForeground(Color.BLUE);
        
        // frame content
        flow.add(enter);
        flow.add(input);
        add(flow, BorderLayout.NORTH);
        br.add(submit);
        add(br, BorderLayout.CENTER);
        
        // action listener
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = new String(input.getPassword());
                try {
                    validate(password);
                } catch (InvalidPasswordException ipe) {
                    JOptionPane.showMessageDialog(null, ipe.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    
    public static void main(String[] args) {
        Password frame = new Password();
        frame.setTitle("Set Password");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public void validate(String password) throws InvalidPasswordException {
        if (password.equals("")) {
            empty.setVisible(true);
            letter.setVisible(false);
            digit.setVisible(false);
            alpha.setVisible(false);
            valid.setVisible(false);
            add(empty);
            input.setText("");
        } else {
            int lettercount = 0, digitcount = 0, spc = 0;
            for (int i = 0; i < password.length(); i++) {
                if (Character.isLetter(password.charAt(i))) {
                    lettercount++;
                } if (Character.isDigit(password.charAt(i))) {
                    digitcount++;
                } else {
                    spc++;
                }
            }
            displayError(lettercount, digitcount, spc);
        }
        input.setText("");
    }
    
    public void displayError(int lettercount, int digitcount, int spc) {
        if (lettercount == 0 && digitcount == 0 && spc < 7) {
            empty.setVisible(false);
            letter.setVisible(true);
            digit.setVisible(true);
            alpha.setVisible(true);
            valid.setVisible(false);
            add(letter);
            add(digit);
            add(alpha);
        } else if (lettercount == 0 && spc < 7) {
            empty.setVisible(false);
            letter.setVisible(true);
            digit.setVisible(false);
            alpha.setVisible(true);
            valid.setVisible(false);
            add(letter);
            add(alpha);
        } else if (digitcount == 0 && spc < 7) {
            empty.setVisible(false);
            letter.setVisible(false);
            digit.setVisible(true);
            alpha.setVisible(true);
            valid.setVisible(false);
            add(digit);
            add(alpha);
        } else if (lettercount == 0 && digitcount == 0) {
            empty.setVisible(false);
            letter.setVisible(true);
            digit.setVisible(true);
            alpha.setVisible(false);
            valid.setVisible(false);
            add(letter);
            add(digit);
        } else if (digitcount == 0) {
            empty.setVisible(false);
            letter.setVisible(false);
            digit.setVisible(true);
            alpha.setVisible(false);
            valid.setVisible(false);
            add(digit);
        } else if (spc < 7) {
            empty.setVisible(false);
            letter.setVisible(false);
            digit.setVisible(true);
            alpha.setVisible(false);
            valid.setVisible(false);
            add(alpha);
        } else if (lettercount == 0) {
            empty.setVisible(false);
            letter.setVisible(true);
            digit.setVisible(false);
            alpha.setVisible(false);
            valid.setVisible(false);
            add(letter);
        } else {
            empty.setVisible(false);
            letter.setVisible(false);
            digit.setVisible(false);
            alpha.setVisible(false);
            valid.setVisible(true);
            add(valid);
        }
    }
    
    private class InvalidPasswordException extends Exception {  
        public InvalidPasswordException(String str) {
            super(str);
        }
    }
}