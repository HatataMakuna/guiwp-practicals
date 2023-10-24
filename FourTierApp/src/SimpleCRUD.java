/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author harch
 */
// P4Q1
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class SimpleCRUD extends JFrame {
    private String host = "jdbc:derby://localhost:1527/collegedb3";
    private String user = "nbuser";
    private String password = "123";
    private String tableName = "Programme";
    private Connection conn;
    private PreparedStatement stmt;
    
    private JTextField jtfCode = new JTextField();
    private JTextField jtfName = new JTextField();
    private JTextField jtfFaculty = new JTextField();
    private JButton jbtAdd = new JButton("Create");
    private JButton jbtRetrieve = new JButton("Retrieve");
    private JButton jbtUpdate = new JButton("Update");
    private JButton jbtDelete = new JButton("Delete");
    
    public SimpleCRUD() {
        JPanel jpCenter = new JPanel(new GridLayout(3, 2));
        jpCenter.add(new JLabel("Programme Code"));
        jpCenter.add(jtfCode);
        jpCenter.add(new JLabel("Programme Name"));
        jpCenter.add(jtfName);
        jpCenter.add(new JLabel("Faculty"));
        jpCenter.add(jtfFaculty);
        add(jpCenter);
        JPanel jpSouth = new JPanel();
        jpSouth.add(jbtAdd);
        jpSouth.add(jbtRetrieve);
        jpSouth.add(jbtUpdate);
        jpSouth.add(jbtDelete);
        add(jpSouth, BorderLayout.SOUTH);
        jbtRetrieve.addActionListener(new RetrieveListener());
        jbtAdd.addActionListener(new insertListener ());

        jbtUpdate.addActionListener(new updateListener());
        jbtDelete.addActionListener(new deleteListener());
        createConnection();
    }
    
    public void clearTextField(){
        jtfCode.setText("");
        jtfName.setText("");
        jtfFaculty.setText("");
    }
    public ResultSet selectRecord(String code) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE Code = ?";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, code);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR",
            JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }
    
    private class RetrieveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String code = jtfCode.getText();
                ResultSet rs = selectRecord(code);
                if (rs.next()) {
                    jtfName.setText(rs.getString("Name"));
                    jtfFaculty.setText(rs.getString("Faculty"));
                }
                else {
                    JOptionPane.showMessageDialog(null, "No such programme code.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR",
                JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private class insertListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String code = jtfCode.getText();
            ResultSet rs = selectRecord(code);
            try {
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "This code already existed", "ERROR",JOptionPane.ERROR_MESSAGE);
                }
                else {
                    String insert = "INSERT INTO " + tableName + " VALUES(?, ?, ?)";
                    stmt = conn.prepareStatement(insert);
                    stmt.setString(1, code);
                    stmt.setString(2, jtfName.getText());
                    stmt.setString(3, jtfFaculty.getText());
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "New code added.");
                    clearTextField();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private class updateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String code = jtfCode.getText();
                ResultSet rs = selectRecord(code);
                if (rs.next()) {
                    String updateR = "UPDATE " + tableName + " SET Name = ?, Faculty = ? WHERE Code = ?";

                    stmt = conn.prepareStatement(updateR);
                    stmt.setString(1, jtfName.getText());
                    stmt.setString(2, jtfFaculty.getText());
                    stmt.setString(3, code);
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Updated.");
                    clearTextField();
                }
                else {
                    JOptionPane.showMessageDialog(null, "This code already existed", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR",
                JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private class deleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String code = jtfCode.getText();
                ResultSet rs = selectRecord(code);
                if (rs.next()) {
                    int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?");
                    if(option == JOptionPane.YES_OPTION){
                        String deleteR = "DELETE FROM " + tableName + " WHERE Code = ?";
                        stmt = conn.prepareStatement(deleteR );
                        stmt.setString(1, code);
                        stmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Record Delete.");
                        clearTextField();
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "This code already existed", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR",
                JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR",
            JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void shutDown() {
        if (conn != null)
        try {
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR",
            JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        SimpleCRUD frm = new SimpleCRUD();
        frm.setTitle("Programme CRUD");
        frm.setSize(600, 200);
        frm.setLocationRelativeTo(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
}
