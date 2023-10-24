import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RadioButtonDemo extends CheckBoxDemo {
	private JRadioButton jrbRed = new JRadioButton("Red");
	private JRadioButton jrbGreen = new JRadioButton("Green");
	private JRadioButton jrbBlue = new JRadioButton("Blue");
	
  public RadioButtonDemo() {
  	// Create a panel to hold radio buttons
  	JPanel jpRadioButtons = new JPanel(new GridLayout(3, 1));
  	jpRadioButtons.add(jrbRed);
  	jpRadioButtons.add(jrbGreen);
  	jpRadioButtons.add(jrbBlue);
  	add(jpRadioButtons, BorderLayout.WEST);
  	
  	// Create a radio button group to group the 3 buttons
  	ButtonGroup group = new ButtonGroup();
  	group.add(jrbRed);
  	group.add(jrbGreen);
  	group.add(jrbBlue);
  	
  	// Set initial message color to blue
  	jrbBlue.setSelected(true);
  	setMessageColor(Color.BLUE);
  	
  	// set mnemonic keys
  	jrbRed.setMnemonic('R');
  	jrbGreen.setMnemonic('G');
  	jrbBlue.setMnemonic('U');
  	
  	// Register listeners for radio buttons
  	jrbRed.addActionListener(new ActionListener() {
  		public void actionPerformed(ActionEvent e) {
  			setMessageColor(Color.RED);
  		}
  	});
  	
  	jrbGreen.addActionListener(new ActionListener() {
  		public void actionPerformed(ActionEvent e) {
  			setMessageColor(Color.GREEN);
  		}
  	});
  	
  	jrbBlue.addActionListener(new ActionListener() {
  		public void actionPerformed(ActionEvent e) {
  			setMessageColor(Color.BLUE);
  		}
  	});
  }
    
  public static void main(String[] args) {
  	RadioButtonDemo frame = new RadioButtonDemo();
  	frame.setTitle("Radio Button Demo");
  	frame.pack();
  	frame.setLocationRelativeTo(null);
  	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  	frame.setVisible(true);
  } 
}