package ui;

import entity.Coffee;
import entity.Sale;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Cashier extends javax.swing.JFrame {

  private Coffee[] coffeeArr = {new Coffee("Cappucino", 7.50),
    new Coffee("Expresso", 5.50),
    new Coffee("Caffe Latte", 6.50),
    new Coffee("Caffe Mocha", 8.50)};
  private ArrayList<Sale> sales;
  private Sale sale;

  public Cashier() {
    initComponents();
    for (int i = 0; i < coffeeArr.length; ++i) {
      jcbCoffee.addItem(coffeeArr[i].getName());
      // jcbCoffee.add(coffeeArr[i], i);
    }
    sales = new ArrayList<Sale>();
    createSale();
  }

  public void clear() {
    jtfQuantity.setText("");
    jtfTotalAmount.setText("");
    jtfAmountReceived.setText("");
    jtfBalanceDue.setText("");
    jcbCoffee.setSelectedIndex(0);
    jcbCoffee.grabFocus();
  }

  public void createSale() {
    sale = new Sale();
    jtfSaleID.setText("" + sale.getSaleID());
    Calendar date = sale.getDate();
    jtfDate.setText(date.get(Calendar.DATE) + " "
            + date.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.ENGLISH)
            + " " + date.get(Calendar.YEAR));

  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jtfSaleID = new javax.swing.JTextField();
    jtfDate = new javax.swing.JTextField();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jcbCoffee = new javax.swing.JComboBox();
    jLabel5 = new javax.swing.JLabel();
    jtfQuantity = new javax.swing.JTextField();
    jbtCalculate = new javax.swing.JButton();
    jbtNewSale = new javax.swing.JButton();
    jbtBack = new javax.swing.JButton();
    jLabel6 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    jLabel8 = new javax.swing.JLabel();
    jtfTotalAmount = new javax.swing.JTextField();
    jtfAmountReceived = new javax.swing.JTextField();
    jtfBalanceDue = new javax.swing.JTextField();
    jMenuBar1 = new javax.swing.JMenuBar();
    jMenu1 = new javax.swing.JMenu();
    jmiShowSummary = new javax.swing.JMenuItem();
    jbtClear = new javax.swing.JMenuItem();
    jMenu2 = new javax.swing.JMenu();
    jmiBack = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jLabel1.setFont(new java.awt.Font("Cambria", 1, 30));
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Coffee King Cafe");

    jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
    jLabel2.setText("Sale ID");

    jtfSaleID.setEditable(false);
    jtfSaleID.setFont(new java.awt.Font("Tahoma", 1, 14));
    jtfSaleID.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jtfSaleIDActionPerformed(evt);
      }
    });

    jtfDate.setFont(new java.awt.Font("Tahoma", 1, 14));

    jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14));
    jLabel3.setText("Coffee Type");

    jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14));
    jLabel4.setText("Date");

    jcbCoffee.setFont(new java.awt.Font("Tahoma", 0, 14));

    jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14));
    jLabel5.setText("Quantity");

    jtfQuantity.setFont(new java.awt.Font("Tahoma", 1, 14));
    jtfQuantity.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    jtfQuantity.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jtfQuantityActionPerformed(evt);
      }
    });

    jbtCalculate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jbtCalculate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Calculator.JPG"))); // NOI18N
    jbtCalculate.setMnemonic('C');
    jbtCalculate.setText("Calculate");
    jbtCalculate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbtCalculateActionPerformed(evt);
      }
    });

    jbtNewSale.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jbtNewSale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Sale.jpg"))); // NOI18N
    jbtNewSale.setMnemonic('N');
    jbtNewSale.setText("New");
    jbtNewSale.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbtNewSaleActionPerformed(evt);
      }
    });

    jbtBack.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jbtBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Back.JPG"))); // NOI18N
    jbtBack.setMnemonic('B');
    jbtBack.setText("Back");
    jbtBack.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbtBackActionPerformed(evt);
      }
    });

    jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14));
    jLabel6.setText("Total Amount (RM)");

    jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14));
    jLabel7.setText("Amount Received (RM)");

    jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14));
    jLabel8.setText("Balance Due (RM)");

    jtfTotalAmount.setFont(new java.awt.Font("Tahoma", 1, 14));
    jtfTotalAmount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    jtfTotalAmount.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jtfTotalAmountActionPerformed(evt);
      }
    });

    jtfAmountReceived.setFont(new java.awt.Font("Tahoma", 1, 14));
    jtfAmountReceived.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    jtfAmountReceived.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jtfAmountReceivedActionPerformed(evt);
      }
    });

    jtfBalanceDue.setFont(new java.awt.Font("Tahoma", 1, 14));
    jtfBalanceDue.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    jtfBalanceDue.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jtfBalanceDueActionPerformed(evt);
      }
    });

    jMenu1.setText("Function");

    jmiShowSummary.setMnemonic('S');
    jmiShowSummary.setText("Show Summary");
    jmiShowSummary.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jmiShowSummaryActionPerformed(evt);
      }
    });
    jMenu1.add(jmiShowSummary);

    jbtClear.setMnemonic('L');
    jbtClear.setText("Clear");
    jbtClear.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbtClearActionPerformed(evt);
      }
    });
    jMenu1.add(jbtClear);

    jMenuBar1.add(jMenu1);

    jMenu2.setText("Navigation");

    jmiBack.setMnemonic('B');
    jmiBack.setText("Back");
    jmiBack.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jmiBackActionPerformed(evt);
      }
    });
    jMenu2.add(jmiBack);

    jMenuBar1.add(jMenu2);

    setJMenuBar(jMenuBar1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jtfSaleID, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(111, 111, 111)
            .addComponent(jLabel4)
            .addGap(27, 27, 27)
            .addComponent(jtfDate, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
          .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel3)
              .addComponent(jLabel5))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 204, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jtfQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
              .addComponent(jcbCoffee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
        .addContainerGap())
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jbtBack, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(34, 34, 34)
        .addComponent(jbtNewSale, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(31, 31, 31)
        .addComponent(jbtCalculate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGap(19, 19, 19))
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel8)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
        .addComponent(jtfBalanceDue, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel6)
          .addComponent(jLabel7))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jtfTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jtfAmountReceived, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jLabel1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jtfSaleID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jtfDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel4))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jcbCoffee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel3))
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jtfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jbtBack)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jbtNewSale)
            .addComponent(jbtCalculate)))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jtfTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jtfAmountReceived, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jtfBalanceDue, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void jtfSaleIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSaleIDActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_jtfSaleIDActionPerformed

    private void jtfQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfQuantityActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_jtfQuantityActionPerformed

    private void jtfTotalAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfTotalAmountActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_jtfTotalAmountActionPerformed

    private void jtfAmountReceivedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfAmountReceivedActionPerformed
      double amountReceived = Double.parseDouble(jtfAmountReceived.getText());
      double balance = amountReceived - sale.getTotal();
      jtfBalanceDue.setText(String.format("%.2f", balance));
      sales.add(sale);
    }//GEN-LAST:event_jtfAmountReceivedActionPerformed

    private void jtfBalanceDueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfBalanceDueActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_jtfBalanceDueActionPerformed

    private void jbtNewSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtNewSaleActionPerformed
      clear();
      createSale();
    }//GEN-LAST:event_jbtNewSaleActionPerformed

    private void jbtBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtBackActionPerformed
      this.dispose();
    }//GEN-LAST:event_jbtBackActionPerformed

    private void jbtCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCalculateActionPerformed
      int selectedIndex = jcbCoffee.getSelectedIndex();
      sale.setCoffee(coffeeArr[selectedIndex]);
      sale.setQuantity(Integer.parseInt(jtfQuantity.getText()));
      jtfTotalAmount.setText(String.format("%.2f", sale.getTotal()));
    }//GEN-LAST:event_jbtCalculateActionPerformed

    private void jmiShowSummaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiShowSummaryActionPerformed
      Calendar date = new GregorianCalendar();
      String dateStr = date.get(Calendar.DATE) + " "
              + date.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH)
              + " " + date.get(Calendar.YEAR);
      String output = "SALES SUMMARY FOR " + dateStr + "\n\n";
      output += String.format("%-5s %-10s %-20s %-10s %-12s\n", "No", "Sale ID", "Coffee", "Quantity", "Amount(RM)");
      double total = 0.0;
      for (int i = 0; i < sales.size(); ++i) {
        Sale s = sales.get(i);
        output += String.format("%-6s %-12d %-25s %-15d %-12.2f\n", (i+1), s.getSaleID(), s.getCoffee().getName(), s.getQuantity(), s.getTotal());
        total += sales.get(i).getTotal();
      }
      output += "\n\n";
      output += String.format("%-65s %-20.2f\n", "Daily Sales Total: ", total);
      new SalesSummary(output).setVisible(true);
    }//GEN-LAST:event_jmiShowSummaryActionPerformed

    private void jbtClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtClearActionPerformed
      clear();
    }//GEN-LAST:event_jbtClearActionPerformed

    private void jmiBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiBackActionPerformed
      dispose();
    }//GEN-LAST:event_jmiBackActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {

      public void run() {
        new Cashier().setVisible(true);
      }
    });
  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JMenu jMenu1;
  private javax.swing.JMenu jMenu2;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JButton jbtBack;
  private javax.swing.JButton jbtCalculate;
  private javax.swing.JMenuItem jbtClear;
  private javax.swing.JButton jbtNewSale;
  private javax.swing.JComboBox jcbCoffee;
  private javax.swing.JMenuItem jmiBack;
  private javax.swing.JMenuItem jmiShowSummary;
  private javax.swing.JTextField jtfAmountReceived;
  private javax.swing.JTextField jtfBalanceDue;
  private javax.swing.JTextField jtfDate;
  private javax.swing.JTextField jtfQuantity;
  private javax.swing.JTextField jtfSaleID;
  private javax.swing.JTextField jtfTotalAmount;
  // End of variables declaration//GEN-END:variables
}
