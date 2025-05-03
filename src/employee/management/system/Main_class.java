//view Attandance----->
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class extends JFrame {

    Main_class() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 1120, 630);
        add(img);

        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM.");
        heading.setBounds(340, 155, 400, 40);
        heading.setFont(new Font("Railway", Font.BOLD, 22));
        img.add(heading);

        //<----------BUTTONS---------->

        JButton add = new JButton("Add Employee");
        add.setBounds(335, 270, 150, 40);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEmployee();
            }
        });
        img.add(add);

        JButton view = new JButton("View Employee");
        view.setBounds(565, 270, 150, 40);
        view.setForeground(Color.WHITE);
        view.setBackground(Color.BLACK);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewEmployee();
                setVisible(false);
            }
        });
        img.add(view);

        JButton remove = new JButton("Remove Employee");
        remove.setBounds(340, 340, 150, 40);
        remove.setForeground(Color.WHITE);
        remove.setBackground(Color.BLACK);
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RemoveEmployee();
            }
        });
        img.add(remove);

        //<----------Attendance BUTTON---------->

        JButton attendance = new JButton("Mark Attendance");
        attendance.setBounds(570, 340, 150, 40);
        attendance.setForeground(Color.WHITE);
        attendance.setBackground(Color.BLACK);
        attendance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MarkAttendance();
            }
        });
        img.add(attendance);

        //<----------View Attendance BUTTON---------->

        JButton viewAttendance = new JButton("View Attendance");
        viewAttendance.setBounds(460, 400, 150, 40);
        viewAttendance.setForeground(Color.WHITE);
        viewAttendance.setBackground(Color.BLACK);
        viewAttendance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewAttendance(); // Make sure this class is implemented
            }
        });
        img.add(viewAttendance);

        setSize(1120, 630);
        setLocation(50, 10);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main_class();
    }
}
