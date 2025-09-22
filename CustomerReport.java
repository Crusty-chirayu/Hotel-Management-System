package Hotel.Management.System;

import javax.swing.*;
import net.proteanit.sql.DbUtils; // rs2xml.jar needed
import java.awt.*;
import java.sql.*;

public class CustomerReport extends JFrame {

    JTable table;

    public CustomerReport() {
        setTitle("Customer Stay & Billing Report");
        setLayout(null);

        JLabel heading = new JLabel("Customer Stay & Billing Report");
        heading.setFont(new Font("Tahoma", Font.BOLD, 22));
        heading.setBounds(400, 20, 500, 40);
        add(heading);

        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        table.setRowHeight(25);

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20, 80, 1150, 500);
        add(sp);

        // Load data from DB
        loadCustomerData();

        JButton back = new JButton("Back");
        back.setBounds(500, 600, 120, 35);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        back.addActionListener(ae -> {
            setVisible(false);
            new Reception();  // return to Reception
        });

        getContentPane().setBackground(Color.WHITE);
        setBounds(300, 100, 1200, 700);
        setVisible(true);
    }

    private void loadCustomerData() {
        try {
            connection c = new connection(); // your DB helper

            String query =
                    "SELECT " +
                            "  c.customer_id AS ID, " +
                            "  c.name AS Name, " +
                            "  c.room AS Room, " +
                            "  c.checkintime AS CheckIn, " +
                            "  IFNULL(c.checkouttime, '-') AS CheckOut, " +
                            "  r.price AS RoomPrice, " +
                            "  IFNULL(c.deposit, 0) AS Deposit, " +
                            "  IFNULL(c.total_amount, 0) AS TotalAmount, " +
                            "  c.payment_status AS PaymentStatus " +
                            "FROM customer c " +
                            "JOIN room r ON c.room = r.roomnumber " +
                            "UNION ALL " +
                            "SELECT " +
                            "  ch.customer_id AS ID, " +
                            "  ch.name AS Name, " +
                            "  ch.room AS Room, " +
                            "  ch.checkintime AS CheckIn, " +
                            "  IFNULL(ch.checkouttime, '-') AS CheckOut, " +
                            "  r.price AS RoomPrice, " +
                            "  IFNULL(ch.deposit, 0) AS Deposit, " +
                            "  IFNULL(ch.total_amount, 0) AS TotalAmount, " +
                            "  ch.payment_status AS PaymentStatus " +
                            "FROM checkout_history ch " +
                            "JOIN room r ON ch.room = r.roomnumber " +
                            "ORDER BY ID";


            ResultSet rs = c.getStatement().executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to load customer data: " + e.getMessage());
        }
    }



    public static void main(String[] args) {
        new CustomerReport();
    }
}
