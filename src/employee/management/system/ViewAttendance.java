package employee.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class ViewAttendance extends JFrame {
    JTable table;
    JButton back;

    ViewAttendance() {
        getContentPane().setBackground(new Color(255, 131, 122));
        setLayout(null);

        JLabel search = new JLabel("Employee Attendance");
        search.setBounds(20, 20, 200, 20);
        add(search);

        table = new JTable();
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(0, 60, 900, 600);
        add(scroll);

        // Fetch attendance details
        try {
            String query = "SELECT * FROM attendance";
            Conn conn = new Conn();
            ResultSet resultSet = conn.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setBounds(400, 680, 100, 30);
        back.addActionListener(e -> setVisible(false));
        add(back);

        setSize(900, 700);
        setLocation(200, 50);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ViewAttendance();
    }
}