
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class CheckBoxDemo extends JFrame {
    private JLabel jlblMessage = new JLabel("Hello", JLabel.CENTER);
    private JCheckBox jchkBold = new JCheckBox("Bold");
    private JCheckBox jchkItalic = new JCheckBox("Italic");
    private JTextField jtfMessage = new JTextField(10);

    public CheckBoxDemo() {
        jlblMessage.setBorder(new LineBorder(Color.BLACK, 2));
        add(jlblMessage, BorderLayout.CENTER);

        JPanel jpCheckBoxes = new JPanel();
        jpCheckBoxes.setLayout(new GridLayout(2, 1));
        jpCheckBoxes.add(jchkBold);
        jpCheckBoxes.add(jchkItalic);
        add(jpCheckBoxes, BorderLayout.EAST);

        JPanel jpTextField = new JPanel();
        jpTextField.setLayout(new BorderLayout(5, 0));
        jpTextField.add(new JLabel("Enter a new message"), BorderLayout.WEST);
        jpTextField.add(jtfMessage, BorderLayout.CENTER);
        jtfMessage.setHorizontalAlignment(JTextField.RIGHT);
        add(jpTextField, BorderLayout.NORTH);

        jchkBold.setMnemonic('B');
        jchkItalic.setMnemonic('I');

        jchkBold.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setNewFont();
            }
        });

        jchkItalic.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setNewFont();
            }
        });

        jtfMessage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jlblMessage.setText(jtfMessage.getText());
                jtfMessage.requestFocusInWindow();
            }
        });
    }

    private void setNewFont() {
        int fontStyle = Font.PLAIN;
        fontStyle += (jchkBold.isSelected() ? Font.BOLD : Font.PLAIN);
        fontStyle += (jchkItalic.isSelected() ? Font.ITALIC : Font.PLAIN);

        Font font = jlblMessage.getFont();
        jlblMessage.setFont(new Font(font.getName(), fontStyle, font.getSize()));
    }

    protected void setMessageColor(Color color) {
        jlblMessage.setForeground(color);
    }

    public static void main(String[] args) {
        CheckBoxDemo frame = new CheckBoxDemo();
        frame.pack();
        frame.setTitle("CheckBoxDemo");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}