package employee.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewEmployee extends JFrame implements ActionListener {

    Choice choiceEmp;
    JTable table;
    JButton searchBtn, print, update, back;

    ViewEmployee() {

        getContentPane().setBackground(new Color(255, 131, 122));
        JLabel search = new JLabel("Search By Employee ID");
        search.setBounds(20, 20, 150, 20);
        add(search);

        choiceEmp = new Choice();
        choiceEmp.setBounds(180, 20, 150, 20);
        add(choiceEmp);

        try {
            Conn conn = new Conn();
            String query = "select * from employee";
            ResultSet resultSet = conn.statement.executeQuery(query);
            while (resultSet.next()) {
                choiceEmp.add(resultSet.getString("empid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();
        try {
            String query = "select * from employee";
            Conn conn = new Conn();
            ResultSet resultSet = conn.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(0, 100, 900, 600);
        add(scroll);


        //<-----SEARCH BUTTON----->

        searchBtn = new JButton("Search");
        searchBtn.setBounds(20, 70, 80, 20);
        searchBtn.addActionListener(this);
        add(searchBtn);


        //<-----UPDATE BUTTON----->

        update = new JButton("Update");
        update.setBounds(110, 70, 80, 20);
        update.addActionListener(this);
        add(update);


        //<-----PRINT BUTTON----->

        print = new JButton("Print");
        print.setBounds(200, 70, 80, 20);
        print.addActionListener(this);
        add(print);


        //<-----BACK BUTTON----->

        back = new JButton("Back");
        back.setBounds(290, 70, 80, 20);
        back.addActionListener(this);
        add(back);

        setSize(900, 700);
        setLayout(null);
        setLocation(200, 50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchBtn) {

            try {
                String query = "select * from employee where empid = '" + choiceEmp.getSelectedItem() + "'";
                Conn conn = new Conn();
                ResultSet resultSet = conn.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));

            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == print) {
            try {
                table.print();
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == update) {
            setVisible(false);
            new UpdateEmployee(choiceEmp.getSelectedItem());
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new ViewEmployee();
    }
}
