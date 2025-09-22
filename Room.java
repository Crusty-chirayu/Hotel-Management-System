package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Room extends JFrame {

    JTable table;
    JButton back;

    Room() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(3, 45, 48));
        panel.setLayout(null);
        add(panel);

        // Room image
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/roomm.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        JLabel label = new JLabel(new ImageIcon(image));
        label.setBounds(600, 200, 200, 200);
        panel.add(label);

        // Table
        table = new JTable();
        table.setBounds(10, 40, 550, 400);
        table.setBackground(new Color(3, 45, 48));
        table.setForeground(Color.WHITE);
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        table.setRowHeight(25);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 40, 550, 400);
        panel.add(scrollPane);

        // --- DATABASE CONNECTION ---
        try {
            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/HotelMS", "chirayu", "chirayu");
            Statement stmt = c.createStatement();

            // Correct column order with aliases
            String RoomInfo = "SELECT roomnumber AS 'Room No.', " +
                    "availability AS 'Availability', " +
                    "cleaningstatus AS 'Clean Status', " +
                    "price AS 'Price', " +
                    "bedtype AS 'Bed Type' " +
                    "FROM room";

            ResultSet resultSet = stmt.executeQuery(RoomInfo);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Back button
        back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200, 500, 120, 30);
        panel.add(back);
        back.addActionListener(e -> setVisible(false));

        // Frame settings
        setUndecorated(true);
        setLayout(null);
        setLocation(500, 100);
        setSize(900, 600);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Room();
    }
}
