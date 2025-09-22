package Hotel.Management.System;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.util.Timer;
import java.util.TimerTask;

public class UpdateRoom extends JFrame {

    JTable table;
    DefaultTableModel model;

    UpdateRoom() {
        setTitle("Room Status Dashboard");
        setLayout(null);

        JLabel heading = new JLabel("Room Status Dashboard");
        heading.setFont(new Font("Tahoma", Font.BOLD, 22));
        heading.setBounds(350, 20, 400, 30);
        add(heading);

        // Table setup
        String[] columns = {"Room Number", "Status", "Customer ID"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(50, 70, 900, 400);
        add(sp);

        // Manual override buttons
        JButton refreshBtn = new JButton("Refresh");
        refreshBtn.setBounds(50, 500, 120, 30);
        refreshBtn.setBackground(Color.BLACK);
        refreshBtn.setForeground(Color.WHITE);
        add(refreshBtn);

        JButton setMaintenanceBtn = new JButton("Set Maintenance");
        setMaintenanceBtn.setBounds(200, 500, 150, 30);
        setMaintenanceBtn.setBackground(Color.BLACK);
        setMaintenanceBtn.setForeground(Color.WHITE);
        add(setMaintenanceBtn);

        JButton setAvailableBtn = new JButton("Set Available");
        setAvailableBtn.setBounds(380, 500, 150, 30);
        setAvailableBtn.setBackground(Color.BLACK);
        setAvailableBtn.setForeground(Color.WHITE);
        add(setAvailableBtn);

        // Load room data
        Runnable loadRooms = () -> {
            try {
                connection con = new connection();
                ResultSet rs = con.statement.executeQuery(
                        "SELECT r.RoomNumber, r.Ava, c.number FROM room r LEFT JOIN customer c ON r.RoomNumber = c.room");
                model.setRowCount(0);
                while (rs.next()) {
                    String roomNum = rs.getString("RoomNumber");
                    String status = rs.getString("Ava");
                    String custId = rs.getString("number");
                    if (custId == null) custId = "-";
                    model.addRow(new Object[]{roomNum, status, custId});
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        // Initial load
        loadRooms.run();

        // Refresh every 5 seconds automatically
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                loadRooms.run();
            }
        }, 0, 5000);

        // Refresh button
        refreshBtn.addActionListener(e -> loadRooms.run());

        // Manual override buttons
        setMaintenanceBtn.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                String room = (String) table.getValueAt(selectedRow, 0);
                try {
                    connection con = new connection();
                    con.statement.executeUpdate("UPDATE room SET Ava = 'Maintenance' WHERE RoomNumber = '" + room + "'");
                    loadRooms.run();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        setAvailableBtn.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                String room = (String) table.getValueAt(selectedRow, 0);
                try {
                    connection con = new connection();
                    con.statement.executeUpdate("UPDATE room SET Ava = 'Available' WHERE RoomNumber = '" + room + "'");
                    loadRooms.run();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        getContentPane().setBackground(new Color(3, 45, 48));
        setSize(1000, 600);
        setLocation(300, 100);
        setVisible(true);
    }

    public static void main(String[] args) {
        new UpdateRoom();
    }
}
