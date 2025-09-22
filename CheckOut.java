package Hotel.Management.System;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class CheckOut extends JFrame {

    JComboBox<String> customerBox;
    JButton checkoutButton, backButton;
    JTable roomTable;
    DefaultTableModel tableModel;

    public CheckOut() {
        setTitle("Hotel Check-Out");
        setSize(850, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(3, 45, 48));

        // Label
        JLabel label = new JLabel("Select Customer:");
        label.setForeground(Color.WHITE);
        label.setBounds(50, 30, 150, 25);
        add(label);

        // Customer ComboBox
        customerBox = new JComboBox<>();
        customerBox.setBounds(200, 30, 300, 25);
        add(customerBox);

        // Checkout button
        checkoutButton = new JButton("Checkout");
        checkoutButton.setBounds(520, 30, 120, 30);
        checkoutButton.setForeground(Color.WHITE);
        checkoutButton.setBackground(Color.BLACK);
        checkoutButton.addActionListener(e -> checkoutCustomer());
        add(checkoutButton);

        // Back button
        backButton = new JButton("Back");
        backButton.setBounds(660, 30, 120, 30);
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.BLACK);
        backButton.addActionListener(e -> setVisible(false));
        add(backButton);

        // Room table
        tableModel = new DefaultTableModel();
        roomTable = new JTable(tableModel);
        roomTable.setRowHeight(25);
        roomTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(roomTable);
        scrollPane.setBounds(50, 80, 720, 360);
        add(scrollPane);

        // Load data
        loadCustomers();
        loadRoomData();

        setVisible(true);
    }

    private void loadCustomers() {
        try {
            customerBox.removeAllItems();
            connection c = new connection();
            ResultSet rs = c.getStatement().executeQuery("SELECT customer_id, name, room FROM customer");
            while (rs.next()) {
                int id = rs.getInt("customer_id");
                String name = rs.getString("name");
                String room = rs.getString("room");
                customerBox.addItem(id + " - " + name + " (Room: " + room + ")");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadRoomData() {
        try {
            connection c = new connection();
            ResultSet rs = c.getStatement().executeQuery(
                    "SELECT roomnumber AS 'Room Number', price AS 'Price', cleaningstatus AS 'Cleaning Status', availability AS 'Availability', bedtype AS 'Bed Type' FROM room"
            );

            tableModel.setRowCount(0);
            tableModel.setColumnCount(0);

            // Column names
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();
            for (int i = 1; i <= colCount; i++) {
                tableModel.addColumn(rsmd.getColumnLabel(i));
            }

            // Rows
            while (rs.next()) {
                Object[] row = new Object[colCount];
                for (int i = 0; i < colCount; i++) {
                    row[i] = rs.getObject(i + 1);
                }
                tableModel.addRow(row);
            }

            // Color availability
            roomTable.getColumn("Availability").setCellRenderer(new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value,
                                                               boolean isSelected, boolean hasFocus, int row, int column) {
                    Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    String status = (String) value;
                    if ("Available".equalsIgnoreCase(status)) {
                        c.setForeground(Color.GREEN.darker());
                    } else {
                        c.setForeground(Color.RED);
                    }
                    return c;
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void checkoutCustomer() {
        String selected = (String) customerBox.getSelectedItem();
        if (selected == null) {
            JOptionPane.showMessageDialog(null, "No customer selected");
            return;
        }

        int customerId = Integer.parseInt(selected.split(" - ")[0]);

        try {
            connection c = new connection();
            Statement stmt = c.getStatement();

            // 1️⃣ Update checkout info & total amount first
            String updateCustomer = "UPDATE customer c " +
                    "JOIN room r ON c.room = r.roomnumber " +
                    "SET checkouttime = NOW(), " +
                    "total_amount = (DATEDIFF(NOW(), STR_TO_DATE(c.checkintime, '%a %b %d %H:%i:%s IST %Y')) + 1) * r.price - CAST(c.deposit AS UNSIGNED), " +
                    "payment_status = 'Paid' " +
                    "WHERE c.customer_id = " + customerId;
            stmt.executeUpdate(updateCustomer);

            // 2️⃣ Move updated record to checkout_history (explicit column mapping)
            String moveToHistory =
                    "INSERT INTO checkout_history (customer_id, name, room, checkintime, checkouttime, deposit, total_amount, payment_status) " +
                            "SELECT customer_id, name, room, checkintime, checkouttime, deposit, total_amount, payment_status " +
                            "FROM customer WHERE customer_id = " + customerId;
            stmt.executeUpdate(moveToHistory);

            // 3️⃣ Update room status
            String updateRoom = "UPDATE room SET cleaningstatus='Dirty', availability='Available' " +
                    "WHERE roomnumber = (SELECT room FROM customer WHERE customer_id = " + customerId + ")";
            stmt.executeUpdate(updateRoom);

            // 4️⃣ Delete from active customer table
            stmt.executeUpdate("DELETE FROM customer WHERE customer_id = " + customerId);

            JOptionPane.showMessageDialog(null, "Checkout completed successfully!");

            // Refresh table and customer list
            loadRoomData();
            loadCustomers();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Checkout failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new CheckOut();
    }
}
