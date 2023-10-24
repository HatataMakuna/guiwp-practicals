package practical8;
import javax.swing.*;
import java.awt.*;
public class Q1 extends JFrame {
    private JButton jbt1;
    private JButton jbt2;
    private JButton jbt3;
    private JButton jbt4;
    private JButton jbt5;
    private JButton jbt6;
    
    public Q1() {
        ImageIcon grapeIcon = new ImageIcon(getClass().getResource("/images/grapes.gif"));
        JPanel jp = new JPanel(new GridLayout(2,3));
        
        jbt1 = new JButton("Grapes", grapeIcon);
        jbt2 = new JButton("Grapes", grapeIcon);
        jbt3 = new JButton("Grapes", grapeIcon);
        jbt4 = new JButton("Grapes", grapeIcon);
        jbt5 = new JButton("Grapes", grapeIcon);
        jbt6 = new JButton("Grapes", grapeIcon);
        
        // 1(a)
        jbt1.setHorizontalAlignment(SwingConstants.LEFT);
        jbt2.setHorizontalAlignment(SwingConstants.RIGHT);
        jbt3.setHorizontalAlignment(SwingConstants.CENTER);
        jbt4.setVerticalAlignment(SwingConstants.TOP);
        jbt5.setVerticalAlignment(SwingConstants.CENTER);
        jbt6.setVerticalAlignment(SwingConstants.BOTTOM);
        
        // 1(b)
        //jbt1.setHorizontalTextPosition(SwingConstants.LEFT);
        //jbt2.setHorizontalTextPosition(SwingConstants.CENTER);
        //jbt3.setHorizontalTextPosition(SwingConstants.RIGHT);
        //jbt4.setVerticalTextPosition(SwingConstants.TOP);
        //jbt5.setVerticalTextPosition(SwingConstants.CENTER);
        //jbt6.setVerticalTextPosition(SwingConstants.BOTTOM);
        jp.add(jbt1);
        jp.add(jbt2);
        jp.add(jbt3);
        jp.add(jbt4);
        jp.add(jbt5);
        jp.add(jbt6);
        add(jp);
    }

    public static void main(String[] args) {
        Q1 frame=new Q1();
        frame.setTitle("Frames");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
