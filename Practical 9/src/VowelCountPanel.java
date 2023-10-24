import javax.swing.*;
import java.awt.*;

public class VowelCountPanel extends JPanel {
  // Count the occurrence of the vowels
  private int[] count = new int[5];;
  private char[] vowels = {'A', 'E', 'I', 'O', 'U'};
  private String text;
  private JLabel[] jlblVowels = new JLabel[12];
  

  /** Set the count and display histogram */
  public VowelCountPanel(String text) {
  	this.text = text;
  	count = countLetters();
  	setLayout(new GridLayout(6, 2, 5, 5));
  	Font font = new Font("Arial", Font.BOLD, 16);
  	setFont(font);
  	
  	jlblVowels[0] = new JLabel("Vowel");
  	jlblVowels[1] = new JLabel("Count");
  	int jlblIndex = 2;
  	for (int i = 0; i < vowels.length; ++i) {
  		jlblVowels[jlblIndex++] = new JLabel("" + vowels[i]);
  		jlblVowels[jlblIndex++] = new JLabel("" + count[i]);
  	}
  	
  	for (int i = 0; i < jlblVowels.length; ++i) {
  		jlblVowels[i].setHorizontalAlignment(SwingConstants.CENTER);
  		add(jlblVowels[i]);
  	}
  }
  
  /** Count the letters in the text area */
  public int[] countLetters() {
    // Count occurrence of each vowel (case insensitive)
    text = text.toUpperCase();
    for (int i = 0; i < text.length(); i++) {
      char character = text.charAt(i);
      switch(character) {
      	case 'A': count[0]++;
      						break;
      	case 'E': count[1]++;
      						break;					
      	case 'I': count[2]++;
      						break;
      	case 'O': count[3]++;
      						break;
      	case 'U': count[4]++;
      						break;
      }
    }

    return count; // Return the count array
  }
}