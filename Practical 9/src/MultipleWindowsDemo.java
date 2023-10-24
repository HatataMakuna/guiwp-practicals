import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MultipleWindowsDemo extends JFrame {
  private JTextArea jta;
  private JButton jbtShowVowelCount = new JButton("Show Vowel Count");

  private JFrame vowelCountFrame = new JFrame();
  //private JPanel vowelCountPanel;

  public MultipleWindowsDemo() {
    // Store text area in a scroll pane
    JScrollPane scrollPane = new JScrollPane(jta = new JTextArea());
    scrollPane.setPreferredSize(new Dimension(300, 200));
    jta.setWrapStyleWord(true);
    jta.setLineWrap(true);

    // Place scroll pane and button in the frame
    add(scrollPane, BorderLayout.CENTER);
    add(jbtShowVowelCount, BorderLayout.SOUTH);

    // Register listener
    jbtShowVowelCount.addActionListener(new ActionListener() {
      /** Handle the button action */
      public void actionPerformed(ActionEvent e) {
      	// Get contents from the text area
    		String text = jta.getText();
    
        VowelCountPanel vowelCountPanel = new VowelCountPanel(text);
    		vowelCountFrame.add(vowelCountPanel, BorderLayout.CENTER);
				vowelCountFrame.setTitle("Vowel Count");
				vowelCountFrame.setSize(300, 400);

        // Show the frame
        vowelCountFrame.setVisible(true);
      }
    });
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }



  public static void main(String[] args) {
    MultipleWindowsDemo frame = new MultipleWindowsDemo();
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("MultipleWindowsDemo");
    frame.pack();
    frame.setVisible(true);
  }
}
