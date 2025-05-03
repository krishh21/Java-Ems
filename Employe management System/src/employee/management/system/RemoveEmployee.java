package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class RemoveEmployee extends JFrame implements ActionListener {


    Choice choiceempid;

    JButton delete, back;

    RemoveEmployee() {

        JLabel lable = new JLabel("Employee Id");
        lable.setBounds(50, 50, 100, 30);
        lable.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lable);

        choiceempid = new Choice();
        choiceempid.setBounds(200, 50, 150, 30);
        add(choiceempid);

        try {
            Conn conn = new Conn();
            String Query = "select * from employee";
            ResultSet resultSet = conn.statement.executeQuery(Query);
            while (resultSet.next()) {
                choiceempid.add(resultSet.getString("empid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lableName = new JLabel("Name");
        lableName.setBounds(50, 100, 100, 30);
        lableName.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lableName);
        JLabel textName = new JLabel();
        textName.setBounds(200, 100, 100, 30);
        add(textName);

        JLabel lablePhone = new JLabel("Phone");
        lablePhone.setBounds(50, 150, 100, 30);
        lablePhone.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lablePhone);
        JLabel textPhone = new JLabel();
        textPhone.setBounds(200, 150, 100, 30);
        add(textPhone);

        JLabel lableEmail = new JLabel("Email");
        lableEmail.setBounds(50, 200, 100, 30);
        lableEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lableEmail);
        JLabel textEmail = new JLabel();
        textEmail.setBounds(200, 200, 100, 30);
        add(textEmail);

        try {
            Conn conn = new Conn();
            ResultSet resultSet = conn.statement.executeQuery("select * from employee where empid = '" + choiceempid.getSelectedItem() + "'");
            while (resultSet.next()) {
                textName.setText(resultSet.getString("name"));
                textPhone.setText(resultSet.getString("phone"));
                textEmail.setText(resultSet.getString("email"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        choiceempid.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    Conn conn = new Conn();
                    ResultSet resultSet = conn.statement.executeQuery("Select * from employee where empid = '" + choiceempid.getSelectedItem() + "'");
                    while (resultSet.next()) {
                        textName.setText(resultSet.getString("name"));
                        textPhone.setText(resultSet.getString("phone"));
                        textEmail.setText(resultSet.getString("email"));
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        delete = new JButton("Delete");
        delete.setBounds(80, 300, 100, 30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(220, 300, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(700, 80, 200, 200);
        add(img);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/rback.jpg"));
        Image i22 = i11.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imgg = new JLabel(i33);
        imgg.setBounds(0, 0, 1120, 630);
        add(imgg);

        setSize(1000, 400);
        setLocation(200, 100);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==delete) {
            try{
                Conn conn = new Conn();
                String query = "delete from employee where empid = '"+choiceempid.getSelectedItem()+"'";
                conn.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Record Deleted Succesfully.");
                setVisible(false);
                new Main_class();
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
