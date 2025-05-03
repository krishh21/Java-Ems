package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateEmployee extends JFrame implements ActionListener {

    JTextField teducation, tfname, taddress, tphone, taadhar, tsalary, tdesignation, temail;
    JLabel tempid;
    JButton add, back;

    String number;

    UpdateEmployee(String number) {

        this.number = number;
        getContentPane().setBackground(new Color(163, 183, 255));


        JLabel heading = new JLabel("ADD EMOLPYEE DETAIL.");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 22));
        add(heading);


        //<----------TEXTFIELD FOR NAME---------->

        JLabel name = new JLabel("Name:");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(name);
        JLabel tname = new JLabel();
        tname.setBounds(200, 150, 150, 30);
        tname.setBackground(new Color(177, 252, 197));
        add(tname);

        //<----------TEXTFIELD FOR FATHER NAME---------->

        JLabel fname = new JLabel("Father name:");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(fname);
        tfname = new JTextField();
        tfname.setBounds(600, 150, 150, 30);
        tfname.setBackground(new Color(177, 252, 197));
        add(tfname);

        //<----------TEXTFIELD FOR ADDRESS---------->


        JLabel address = new JLabel("Address:");
        address.setBounds(50, 200, 150, 30);
        address.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(address);
        taddress = new JTextField();
        taddress.setBounds(200, 200, 150, 30);
        taddress.setBackground(new Color(177, 252, 197));
        add(taddress);

        //<----------TEXTFIELD FOR PHONE---------->

        JLabel phone = new JLabel("Phone:");
        phone.setBounds(400, 200, 150, 30);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(phone);
        tphone = new JTextField();
        tphone.setBounds(600, 200, 150, 30);
        tphone.setBackground(new Color(177, 252, 197));
        add(tphone);

        //<----------TEXTFIELD FOR AADHAR---------->

        JLabel aadhar = new JLabel("Aadhar no.:");
        aadhar.setBounds(50, 250, 150, 30);
        aadhar.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(aadhar);
        JLabel taadhar = new JLabel();
        taadhar.setBounds(200, 250, 150, 30);
        taadhar.setBackground(new Color(177, 252, 197));
        add(taadhar);

        //<----------TEXTFIELD FOR DOB---------->

        JLabel dob = new JLabel("DOB:");
        dob.setBounds(400, 250, 150, 30);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(dob);
        JLabel tdob = new JLabel();
        tdob.setBounds(600, 250, 150, 30);
        tdob.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(tdob);

        //<----------TEXTFILED FOR SALARY---------->

        JLabel salary = new JLabel("Salary:");
        salary.setBounds(50, 300, 150, 30);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(salary);
        tsalary = new JTextField();
        tsalary.setBounds(200, 300, 150, 30);
        tsalary.setBackground(new Color(177, 252, 197));
        add(tsalary);

        //<----------TEXTFILED FOR DESIGNATION---------->

        JLabel desig = new JLabel("Designation:");
        desig.setBounds(400, 300, 150, 30);
        desig.setFont(new Font("SEN_SERIF", Font.BOLD, 20));
        add(desig);
        tdesignation = new JTextField();
        tdesignation.setBounds(600, 300, 150, 30);
        tdesignation.setBackground(new Color(177, 252, 197));
        add(tdesignation);

        //<----------TEXTFIELD FOR EMAIL---------->

        JLabel email = new JLabel("Email:");
        email.setBounds(50, 350, 150, 30);
        email.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(email);
        temail = new JTextField();
        temail.setBounds(200, 350, 150, 30);
        temail.setBackground(new Color(177, 252, 197));
        add(temail);

        //<----------TEXTFIELD FOR EDUCATION---------->

        JLabel education = new JLabel("Higghest Education:");
        education.setBounds(400, 350, 150, 30);
        education.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(education);
        teducation = new JTextField();
        teducation.setBounds(600, 350, 150, 30);
        teducation.setBackground(new Color(177, 252, 197));
        add(teducation);


        //<----------TEXTFIELD FOR EMPLOYEE ID---------->

        JLabel empid = new JLabel("Employee ID:");
        empid.setBounds(50, 400, 150, 30);
        empid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(empid);
        tempid = new JLabel();
        tempid.setBounds(240, 400, 150, 30);
        tempid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        tempid.setForeground(Color.red);
        add(tempid);

        try {
            Conn conn = new Conn();
            String query = "select * from employee where empid = '" + number + "'";
            ResultSet resultSet = conn.statement.executeQuery(query);
            while (resultSet.next()) {
                tname.setText(resultSet.getString("name"));
                tfname.setText(resultSet.getString("fname"));
                tdob.setText(resultSet.getString("dob"));
                taddress.setText(resultSet.getString("address"));
                tsalary.setText(resultSet.getString("salary"));
                tphone.setText(resultSet.getString("phone"));
                temail.setText(resultSet.getString("email"));
                teducation.setText(resultSet.getString("education"));
                taadhar.setText(resultSet.getString("aadhar"));
                tempid.setText(resultSet.getString("empid"));
                tname.setText(resultSet.getString("name"));
                tdesignation.setText(resultSet.getString("design"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //<----------BUTTONS---------->

        add = new JButton("UPDATE");
        add.setBounds(450, 500, 150, 40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(250, 500, 150, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        //<----------FIELD---------->

        setSize(900, 700);
        setLayout(null);
        setLocation(300, 50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == add) {
            String fname = tfname.getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = teducation.getText();
            String design = tdesignation.getText();

            try {
                Conn conn = new Conn();
                String query = "update employee set fname = '" + fname + "', salary = '" + salary + "', address = '" + address + "', phone = '" + phone + "', email = '" + email + "', education = '" + education + "', design = '" + design + "' where empid = '" + number + "'";
                conn.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated Successfully.");
//                setVisible(false);
                new Main_class();
                new ViewEmployee();
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
            new Main_class();
        }

    }

    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}