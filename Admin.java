package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame implements ActionListener {

    JButton add_Employee, add_Room, add_Drivers, add_Housekeeping, logout, back;

    Admin() {

        // Add Employee button
        add_Employee = new JButton("ADD EMPLOYEE");
        add_Employee.setBounds(250, 230, 200, 30);
        styleButton(add_Employee);
        add_Employee.addActionListener(this);
        add(add_Employee);

        // Add Room button
        add_Room = new JButton("ADD ROOM");
        add_Room.setBounds(250, 380, 200, 30);
        styleButton(add_Room);
        add_Room.addActionListener(this);
        add(add_Room);

        // Add Drivers button
        add_Drivers = new JButton("ADD DRIVERS");
        add_Drivers.setBounds(250, 530, 200, 30);
        styleButton(add_Drivers);
        add_Drivers.addActionListener(this);
        add(add_Drivers);

        // Housekeeping button
        add_Housekeeping = new JButton("HOUSEKEEPING");
        add_Housekeeping.setBounds(250, 680, 200, 30);
        styleButton(add_Housekeeping);
        add_Housekeeping.addActionListener(this);
        add(add_Housekeeping);

        // Logout button
        logout = new JButton("Logout");
        logout.setBounds(10, 800, 95, 30);
        styleSmallButton(logout);
        logout.addActionListener(this);
        add(logout);

        // Back button
        back = new JButton("Back");
        back.setBounds(110, 800, 95, 30);
        styleSmallButton(back);
        back.addActionListener(this);
        add(back);

        // Employee Image
        setImageLabel("icon/employees.png", 70, 180, 120, 120);

        // Room Image
        setImageLabel("icon/room.png", 70, 340, 120, 120);

        // Driver Image
        setImageLabel("icon/driver.png", 70, 500, 120, 120);

        // Housekeeping Image
        setImageLabel("icon/housekeepiing.jpeg", 70, 650, 120, 120);

        // Admin page gif
        setImageLabel("icon/adminpagewalama.gif", 650, 10, 820, 820);

        // Frame settings
        getContentPane().setBackground(new Color(3, 45, 48));
        setLayout(null);
        setSize(1950, 1090);
        setVisible(true);
    }

    // Helper method to style main buttons
    private void styleButton(JButton btn) {
        btn.setBackground(Color.WHITE);
        btn.setForeground(Color.BLACK);
        btn.setFont(new Font("Tahoma", Font.BOLD, 15));
    }

    // Helper method to style small buttons (logout/back)
    private void styleSmallButton(JButton btn) {
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Tahoma", Font.BOLD, 15));
    }

    // Helper method to load and set image
    private void setImageLabel(String path, int x, int y, int w, int h) {
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource(path));
        Image img = icon.getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT);
        JLabel label = new JLabel(new ImageIcon(img));
        label.setBounds(x, y, w, h);
        add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add_Employee) {
            new AddEmployee();
        } else if (e.getSource() == add_Room) {
            new AddRoom();
        } else if (e.getSource() == add_Drivers) {
            new AddDriver();
        } else if (e.getSource() == add_Housekeeping) {
            new Housekeeping();   // <-- Will open your Housekeeping class
        } else if (e.getSource() == logout) {
            System.exit(0);
        } else if (e.getSource() == back) {
            new Dashboard();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Admin();
    }
}
