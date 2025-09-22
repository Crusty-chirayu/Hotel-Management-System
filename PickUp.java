package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PickUp extends JFrame {

    public PickUp() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(3, 45, 48));
        panel.setBounds(5, 5, 790, 590);
        panel.setLayout(null);
        add(panel);

        JLabel pus = new JLabel("Pick Up Service");
        pus.setBounds(90, 11, 160, 25);
        pus.setForeground(Color.WHITE);
        pus.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(pus);

        JLabel TOC = new JLabel("Type of Car");
        TOC.setBounds(32, 97, 89, 14);
        TOC.setForeground(Color.WHITE);
        TOC.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(TOC);

        Choice carChoice = new Choice();
        carChoice.setBounds(123, 94, 150, 25);
        panel.add(carChoice);

        try {
            connection c = new connection();
            String q = "SELECT DISTINCT car_name FROM driver";
            ResultSet rs = c.statement.executeQuery(q);
            while (rs.next()) {
                carChoice.add(rs.getString("car_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JTable table = new JTable();
        table.setBounds(10, 233, 760, 250);
        table.setBackground(new Color(3, 45, 48));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try {
            connection c = new connection();
            String q = "SELECT * FROM driver";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel name = new JLabel("Name");
        name.setBounds(24, 208, 46, 14);
        name.setForeground(Color.WHITE);
        panel.add(name);

        JLabel age = new JLabel("Age");
        age.setBounds(165, 208, 46, 14);
        age.setForeground(Color.WHITE);
        panel.add(age);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(264, 208, 46, 14);
        gender.setForeground(Color.WHITE);
        panel.add(gender);

        JLabel company = new JLabel("Company");
        company.setBounds(366, 208, 100, 14);
        company.setForeground(Color.WHITE);
        panel.add(company);

        JLabel carName = new JLabel("Car Name");
        carName.setBounds(486, 208, 100, 14);
        carName.setForeground(Color.WHITE);
        panel.add(carName);

        JLabel available = new JLabel("Available");
        available.setBounds(600, 208, 100, 14);
        available.setForeground(Color.WHITE);
        panel.add(available);

        JLabel location = new JLabel("Location");
        location.setBounds(700, 208, 100, 14);
        location.setForeground(Color.WHITE);
        panel.add(location);

        JButton display = new JButton("Display");
        display.setBounds(200, 500, 120, 30);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.WHITE);
        panel.add(display);

        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCar = carChoice.getSelectedItem();
                String query = "SELECT * FROM driver WHERE car_name = '" + selectedCar + "'";
                try {
                    connection c = new connection();
                    ResultSet resultSet = c.statement.executeQuery(query);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(420, 500, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setLayout(null);
        setSize(800, 600);
        setLocation(500, 100);
        setVisible(true);
    }

    public static void main(String[] args) {
        new PickUp();
    }
}
