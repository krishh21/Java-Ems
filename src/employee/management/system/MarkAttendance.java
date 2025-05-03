package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class MarkAttendance extends JFrame implements ActionListener {
    Choice choiceEmp;
    JButton markBtn, backBtn;
    JComboBox<String> statusCombo;
    JLabel dateLabel;

    MarkAttendance() {

        getContentPane().setBackground(new Color(255, 255, 255));
        setLayout(null);
        setLocation(200, 50);

        // Heading
        JLabel heading = new JLabel("Mark Employee Attendance");
        heading.setBounds(300, 20, 250, 40);
        heading.setFont(new Font("serif", Font.BOLD, 24));
        add(heading);

        // Employee ID Dropdown
        JLabel empLabel = new JLabel("Employee ID:");
        empLabel.setBounds(50, 100, 150, 30);
        empLabel.setFont(new Font("serif", Font.BOLD, 18));
        add(empLabel);

        choiceEmp = new Choice();
        choiceEmp.setBounds(200, 100, 150, 30);
        add(choiceEmp);

        try {
            Conn conn = new Conn();
            String query = "SELECT * FROM employee";
            ResultSet resultSet = conn.statement.executeQuery(query);
            while (resultSet.next()) {
                choiceEmp.add(resultSet.getString("empid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Attendance Status
        JLabel statusLabel = new JLabel("Status:");
        statusLabel.setBounds(50, 150, 150, 30);
        statusLabel.setFont(new Font("serif", Font.BOLD, 18));
        add(statusLabel);

        statusCombo = new JComboBox<>(new String[]{"Present", "Absent"});
        statusCombo.setBounds(200, 150, 150, 30);
        add(statusCombo);

        // Date Label
        dateLabel = new JLabel("Date: " + new java.text.SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        dateLabel.setBounds(400, 150, 200, 30);
        dateLabel.setFont(new Font("serif", Font.BOLD, 18));
        add(dateLabel);

        // Mark Button
        markBtn = new JButton("Mark Attendance");
        markBtn.setBounds(100, 200, 150, 30);
        markBtn.setBackground(Color.BLACK);
        markBtn.setForeground(Color.WHITE);
        markBtn.addActionListener(this);
        add(markBtn);

        // Back Button
        backBtn = new JButton("Back");
        backBtn.setBounds(300, 200, 150, 30);
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(this);
        add(backBtn);

        setSize(600, 300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == markBtn) {
//            String empId = choiceEmp.getSelectedItem();
//            String status = (String) statusCombo.getSelectedItem();
//            String date = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new Date());
//
//            try {
//                Conn conn = new Conn();
//
//                // Check if attendance for this employee already exists for today
//                String checkQuery = "SELECT * FROM attendance WHERE empid = '" + empId + "' AND date = '" + date + "'";
//                ResultSet rs = conn.statement.executeQuery(checkQuery);
//
//                if (rs.next()) {
//                    // If attendance already exists, update the status
//                    String updateQuery = "UPDATE attendance SET status = '" + status + "' WHERE empid = '" + empId + "' AND date = '" + date + "'";
//                    conn.statement.executeUpdate(updateQuery);
//                    JOptionPane.showMessageDialog(null, "Attendance updated!");
//                } else {
//                    // If attendance doesn't exist, insert a new record
//                    String insertQuery = "INSERT INTO attendance (empid, date, status) VALUES ('" + empId + "', '" + date + "', '" + status + "')";
//                    conn.statement.executeUpdate(insertQuery);
//                    JOptionPane.showMessageDialog(null, "Attendance marked!");
//                }
//
//            } catch (Exception ex) {
//                ex.printStackTrace();
//                JOptionPane.showMessageDialog(null, "Error marking attendance.");
//            }
//
//        } else if (e.getSource() == backBtn) {
//            setVisible(false);
//            new Main_class();  // Go back to the main window
//        }


        if (e.getSource() == markBtn) {
            String empId = choiceEmp.getSelectedItem();
            String status = (String) statusCombo.getSelectedItem();
            String date = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new Date());

            try {
                Conn conn = new Conn();

                // Log the check query
                String checkQuery = "SELECT * FROM attendance WHERE empid = '" + empId + "' AND date = '" + date + "'";
                System.out.println("Executing check query: " + checkQuery); // Log this query
                ResultSet rs = conn.statement.executeQuery(checkQuery);

                if (rs.next()) {
                    // If attendance already exists, update the status
                    String updateQuery = "UPDATE attendance SET status = '" + status + "' WHERE empid = '" + empId + "' AND date = '" + date + "'";
                    System.out.println("Executing update query: " + updateQuery); // Log this query
                    conn.statement.executeUpdate(updateQuery);
                    JOptionPane.showMessageDialog(null, "Attendance updated!");
                } else {
                    // If attendance doesn't exist, insert a new record
                    String insertQuery = "INSERT INTO attendance (empid, date, status) VALUES ('" + empId + "', '" + date + "', '" + status + "')";
                    System.out.println("Executing insert query: " + insertQuery); // Log this query
                    conn.statement.executeUpdate(insertQuery);
                    JOptionPane.showMessageDialog(null, "Attendance marked!");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error marking attendance.");
            }

        } else if (e.getSource() == backBtn) {
            setVisible(false);
            new Main_class();  // Go back to the main window
        }
    }


    public static void main(String[] args) {
        new MarkAttendance();
    }
}