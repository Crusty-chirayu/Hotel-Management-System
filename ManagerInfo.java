package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class ManagerInfo extends JFrame {
    ManagerInfo() {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,34,980,450);
        table.setForeground(Color.WHITE);
        table.setBackground(new Color(3,45,48));
        panel.add(table);

        // --- FIXED DATABASE CONNECTION ---
        try {
            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/HotelMS", "chirayu", "chirayu");
            Statement stmt = c.createStatement();
            String q = "SELECT * FROM employee WHERE job = 'Manager'";
            ResultSet resultSet = stmt.executeQuery(q);

            DefaultTableModel model = new DefaultTableModel(
                    new Object[]{"Name","Age","Gender","Job","Salary","Phone","Aadhar","Email"}, 0);

            while(resultSet.next()) {
                model.addRow(new Object[]{
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("gender"),
                        resultSet.getString("job"),
                        resultSet.getInt("salary"),
                        resultSet.getString("phone"),
                        resultSet.getString("aadhar"),
                        resultSet.getString("email")
                });
            }
            table.setModel(model);

        } catch(Exception e) {
            e.printStackTrace();
        }

        JButton back = new JButton("BACK");
        back.setBounds(350,500,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JLabel name = new JLabel("Name");
        name.setBounds(41,11,70,19);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(name);

        JLabel Age = new JLabel("Age");
        Age.setBounds(159,11,70,19);
        Age.setForeground(Color.WHITE);
        Age.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(Age);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(273,11,70,19);
        gender.setForeground(Color.WHITE);
        gender.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(gender);

        JLabel job = new JLabel("Job");
        job.setBounds(416,11,70,19);
        job.setForeground(Color.WHITE);
        job.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(job);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(536,11,70,19);
        salary.setForeground(Color.WHITE);
        salary.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(salary);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(656,11,70,19);
        phone.setForeground(Color.WHITE);
        phone.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(phone);

        JLabel gmail = new JLabel("Gmail");
        gmail.setBounds(786,11,70,19);
        gmail.setForeground(Color.WHITE);
        gmail.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(gmail);

        JLabel aadhar = new JLabel("Aadhar");
        aadhar.setBounds(896,11,70,19);
        aadhar.setForeground(Color.WHITE);
        aadhar.setFont(new Font("Tahoma", Font.BOLD,14));
        panel.add(aadhar);

        setUndecorated(true);
        setLayout(null);
        setLocation(430,100);
        setSize(1000,600);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ManagerInfo();
    }
}
