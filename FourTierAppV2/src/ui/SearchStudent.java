package ui;


import da.StudentTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;
import javax.swing.*;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;

public class SearchStudent extends JFrame {
    static final String DATABASE_URL = "jdbc:derby://localhost:1527/collegedb";
    static final String USERNAME = "nbuser";
    static final String PASSWORD = "nbuser";
    static final String DEFAULT_QUERY = "SELECT * FROM Student";
    
    private StudentTableModel tableModel;
    private JTable resultTable;
    private TableRowSorter<TableModel> sorter;
    
    private JTextArea queryArea;
    private JTextField filterText = new JTextField();
    private JButton filterButton = new JButton("Apply Filter");
     
    public SearchStudent() {
        try {
            tableModel = new StudentTableModel(DATABASE_URL, USERNAME, PASSWORD, DEFAULT_QUERY);
            resultTable = new JTable(tableModel);
            
            queryArea = new JTextArea(DEFAULT_QUERY, 3, 100);
            queryArea.setWrapStyleWord(true);
            queryArea.setLineWrap(true);

            Box boxNorth = Box.createHorizontalBox();
            boxNorth.add(filterText);
            boxNorth.add(filterButton);
            filterButton.addActionListener(new FilterButtonListener());
            
            add(boxNorth, BorderLayout.NORTH);
            add(new JScrollPane(resultTable), BorderLayout.CENTER);

            sorter = new TableRowSorter<TableModel>(tableModel);
            resultTable.setRowSorter(sorter);

            // ensure database connection is closed when user quits application
            addWindowListener(new WindowCloseListener());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            tableModel.disconnectFromDatabase();
            System.exit(1);
        }
    }

    private class FilterButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String text = filterText.getText();
            if (text.length() == 0) {
                sorter.setRowFilter(null);
            } else {
                try {
                    sorter.setRowFilter(RowFilter.regexFilter(text));
                } catch (PatternSyntaxException pse) {
                    JOptionPane.showMessageDialog(null, "Bad regex pattern", "Bad regex pattern", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private class WindowCloseListener extends WindowAdapter {
        @Override
        public void windowClosed(WindowEvent event) {
            tableModel.disconnectFromDatabase();
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SearchStudent fra = new SearchStudent();
        fra.setTitle("Student Information");
        fra.setSize(500, 250);
        fra.setVisible(true);
        fra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
