/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author harch
 */
// P3Q3 modified file
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class loanCalculator extends JFrame {
    // declare private variables for textfields and button
    private JLabel LoanLabel = new JLabel("Loan Amount: ");
    private JLabel RateLabel = new JLabel("Interest Rate: ");
    private JLabel YearLabel = new JLabel("Year");
    private JLabel MonthlyLabel = new JLabel("Monthly Payment: ");
    private JLabel TotalLabel = new JLabel("Total Payment");
    private JTextField LoanTextField = new JTextField(10);
    private JTextField RateTextField = new JTextField(10);
    private JTextField YearTextField = new JTextField(10);
    private JTextField MonthlyTextField = new JTextField(10);
    private JTextField TotalTextField = new JTextField(10);
    private JButton ComputeBtn = new JButton("Compute");
    
    public loanCalculator(){
        // add panel with gridlayout 5 rows and 2 column
        JPanel p1 = new JPanel(new GridLayout(5,2));
        //to add the labels and texfields
        p1.add(LoanLabel);
        p1.add(LoanTextField);
        p1.add(RateLabel);
        p1.add(RateTextField);
        p1.add(YearLabel);
        p1.add(YearTextField);
        p1.add(MonthlyLabel);
        p1.add(MonthlyTextField);
        p1.add(TotalLabel);
        p1.add(TotalTextField);
        
        //add another panel for button with flowlayout 
        JPanel p2= new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p2.add(ComputeBtn);
        //add both panels to the frame using borderlayout, one at center and another at south
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);

        //register listener for the button
        ComputeBtn.addActionListener(new buttonListener());
        //5 elements to create frame
        setTitle("Loan Calculation");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    //create button listener
    class buttonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //catch the exception
            double amount =0.0;  
            double annualInterestRate = 0.0;
            int year = 0;
            try {
                amount = Double.parseDouble(LoanTextField.getText());
                annualInterestRate = Double.parseDouble(RateTextField.getText());
                year = Integer.parseInt(YearTextField.getText());
                Loan loan = new Loan(annualInterestRate, year, amount);
    
                //get formula by using method name
                MonthlyTextField.setText(String.format("%.2f", loan.getMonthlyPayment()));
                TotalTextField.setText(String.format("%.2f",loan.getTotalPayment()));
            } catch(IllegalArgumentException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args){
          new loanCalculator();
    }
}