package da;

import domain.Programme;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

public class ProgrammeDA {

    private String host = "jdbc:derby://localhost:1527/collegedb";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "programme";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private String sqlQueryStr = "SELECT * FROM " + tableName;
    
    public ProgrammeDA() {
        createConnection();
    }
    
    public ArrayList<Programme> getProgrammes() {
        ArrayList<Programme> programmes = new ArrayList<Programme>();
        try {
            stmt = conn.prepareStatement(sqlQueryStr);
            rs = stmt.executeQuery();
            while (rs.next()) {
                programmes.add(getCurrentRecord());
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return programmes;
    }
    
    public Programme getCurrentRecord() {
        Programme programme = null;
        try {
            programme = new Programme(rs.getString(1), rs.getString(2), rs.getString(3));
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return programme;
    }
    
    public Programme getRecord(String code) {
        Programme p = null;
        try {
            stmt = conn.prepareStatement(sqlQueryStr);
            rs = stmt.executeQuery();
            boolean found = false;
            while (!found && rs.next()) {
                if (code.equals(rs.getString("Code"))) {
                    found = true;
                }
            }
            if (found)
                p = new Programme(code, rs.getString("Name"), rs.getString("Faculty"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return p;
    }

    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void shutDown() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
