import javax.swing.*;
import java.awt.*;

public class TestButtonIcons extends JFrame {
    public TestButtonIcons() {
        ImageIcon usIcon = new ImageIcon(getClass().getResource("/images/usIcon.gif"));
        ImageIcon caIcon = new ImageIcon(getClass().getResource("/images/canadaIcon.gif"));
        ImageIcon ukIcon = new ImageIcon(getClass().getResource("/images/ukIcon.gif"));
        JButton jbt1 = new JButton("Click it", usIcon);
        jbt1.setPressedIcon(caIcon);
        jbt1.setRolloverIcon(ukIcon);
        add(jbt1);
        
                    
    }

    public static void main(String[] args) {
        TestButtonIcons frame=new TestButtonIcons();
        frame.setTitle("Button Icons");
        frame.setSize(250, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
