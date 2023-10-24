/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author harch
 */
import javax.swing.JOptionPane;
public class P1Q1 {
    public static void main(String args[]) {
        int option = JOptionPane.YES_OPTION;
        do {
            String inputStr = JOptionPane.showInputDialog(null, "Enter a temperature in Fahrenheit: ");
            // convert string to double
            double fahrenheit = Double.parseDouble(inputStr);
            // convert fahrenheit to celsius using the formula
            double celsius = 5.0 / 9.0 * (fahrenheit - 32.0);
            JOptionPane.showMessageDialog(null, "Temperature converted to celsius: " + celsius);
            // add confirm dialog (part (b))
            option = JOptionPane.showConfirmDialog(null, "Enter another temperature?");
        } while(option == JOptionPane.YES_OPTION);
    }
}
