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

public class Department extends JFrame {

    Department() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(3, 45, 48));
        panel.setBounds(5, 5, 690, 490);
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(0, 40, 700, 350);
        table.setBackground(new Color(4, 45, 48));
        table.setForeground(Color.WHITE);
        panel.add(table);

        // --- DATABASE CONNECTION FIX ---
        try {
            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/HotelMS", "chirayu", "chirayu");
            Statement stmt = c.createStatement();
            String departmentInfo = "SELECT * FROM department";
            ResultSet resultSet = stmt.executeQuery(departmentInfo);

            DefaultTableModel model = new DefaultTableModel(
                    new Object[]{"Department", "Budget"}, 0);
            while (resultSet.next()) {
                model.addRow(new Object[]{
                        resultSet.getString("Department"),
                        resultSet.getInt("Budget")
                });
            }
            table.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton back = new JButton("BACK");
        back.setBounds(400, 410, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JLabel label1 = new JLabel("Department");
        label1.setBounds(145, 11, 105, 20);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label1);

        JLabel label2 = new JLabel("Budget");
        label2.setBounds(431, 11, 105, 20);
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label2);

        setUndecorated(true);
        setLayout(null);
        setLocation(550, 150);
        setSize(700, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Department();
    }
}
