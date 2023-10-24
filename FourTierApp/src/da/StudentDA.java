package da;

import domain.*;
import java.sql.*;
import javax.swing.*;
public class StudentDA {
    private String host = "jdbc:derby://localhost:1527/collegedb";
    private String user = "nbuser";
    private String password = "123";
    private String tableName = "student";
    private Connection conn;
    private PreparedStatement stmt;
    
    public StudentDA() {
        createConnection();
    }
    
    public Student getRecord(String id) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE ID = ?";
        Student student = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                student = new Student(id, rs.getString("IC"), rs.getString("Name"), 
                        rs.getString("Level").charAt(0),
                        new Programme(rs.getString("Programmecode")),
                        rs.getInt("Yr"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return student;
    }
    
    public void addRecord(Student student){
        String insert = "INSERT INTO " + tableName + " VALUES(?, ?, ?, ?, ?, ?)";
        try{
            stmt = conn.prepareStatement(insert);
            stmt.setString(1, student.getId());
            stmt.setString(2, student.getIc());
            stmt.setString(3, student.getName());
            stmt.setString(4, Character.toString(student.getLevel()));
            stmt.setString(5, student.getProgrammeCode());
            stmt.setString(6, Integer.toString(student.getYear()));
            stmt.executeUpdate();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateRecord(Student student) {
        String update = "UPDATE " + tableName + " SET IC = ?, Name = ?, Level = ?, Programmecode = ?, Yr = ? WHERE ID = ?";
        try {
            stmt = conn.prepareStatement(update);
            stmt.setString(1, student.getIc());
            stmt.setString(2, student.getName());
            stmt.setString(3, Character.toString(student.getLevel()));
            stmt.setString(4, student.getProgrammeCode());
            stmt.setString(5, Integer.toString(student.getYear()));
            stmt.setString(6, student.getId());
            stmt.executeUpdate();
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void deleteRecord(String id) {
        String delete = "DELETE FROM " + tableName + " WHERE ID = ?";
        try {
            stmt = conn.prepareStatement(delete);
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void shutDown() {
        if (conn != null)
            try {
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
