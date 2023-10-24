package practical8;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Q2 extends JFrame {
    private JLabel jlb1 = new JLabel("Enter loan amount, interest rate and year");
    private JTextField jtf1 = new JTextField();
    private JTextField jtf2 = new JTextField();
    private JTextField jtf3 = new JTextField();
    private JTextField jtf4 = new JTextField();
    private JTextField jtf5 = new JTextField();
    private JButton jbt = new JButton("Compute Payment");
    
    public Q2() {
        jtf4.setEditable(false);
        jtf5.setEditable(false);
        
        jlb1.setHorizontalTextPosition(SwingConstants.LEFT);
        add(jlb1, BorderLayout.NORTH);
        
        JPanel jp = new JPanel(new GridLayout(5, 2));
        jp.add(new JLabel("Annual Interest Rate"));
        jp.add(jtf1);
        jp.add(new JLabel("Number of Years"));
        jp.add(jtf2);
        jp.add(new JLabel("Loan Amount"));
        jp.add(jtf3);
        jp.add(new JLabel("Monthly Payment"));
        jp.add(jtf4);
        jp.add(new JLabel("Total Payment"));
        jp.add(jtf5);
        add(jp, BorderLayout.CENTER);
        
        JPanel jpFlow = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        jpFlow.add(jbt);
        add(jpFlow, BorderLayout.SOUTH);
        
        jbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double interestRate = Double.parseDouble(jtf1.getText());
                int noofyears = Integer.parseInt(jtf2.getText());
                double loanAmt = Double.parseDouble(jtf3.getText());
                Loan loan = new Loan(interestRate, noofyears, loanAmt);
                jtf4.setText(Double.toString(loan.getMonthlyPayment()));
                jtf5.setText(Double.toString(loan.getTotalPayment()));
            }
        });
    }
    
    public void Q2Frame() {
        Q2 frame = new Q2();
        frame.setTitle("LoanCalculator");
        frame.pack();
        frame.setLocationRelativeTo(null);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
