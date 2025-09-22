package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;

public class Reception extends JFrame {

    Reception() {

        // Left panel with buttons
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5, 5, 270, 820);
        panel1.setBackground(new Color(3, 45, 48));
        add(panel1);

        // Main panel with background image
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(280, 5, 1238, 820);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        // Background GIF/Image
        ImageIcon i111 = new ImageIcon(ClassLoader.getSystemResource("icon/cccc.gif"));
        Image i22 = i111.getImage().getScaledInstance(1220, 820, Image.SCALE_DEFAULT);
        JLabel label11 = new JLabel(new ImageIcon(i22));
        label11.setBounds(10, 10, 1220, 820);
        panel.add(label11);

        // Side image in left panel
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/login.jpeg"));
        Image i2 = i11.getImage().getScaledInstance(250, 200, Image.SCALE_DEFAULT);
        JLabel label1 = new JLabel(new ImageIcon(i2));
        label1.setBounds(5, 530, 250, 250);
        panel1.add(label1);

        // BUTTONS
        JButton btnNCF = new JButton("New Customer Form");
        btnNCF.setBounds(30, 30, 200, 30);
        btnNCF.setBackground(Color.BLACK);
        btnNCF.setForeground(Color.WHITE);
        panel1.add(btnNCF);
        btnNCF.addActionListener(e -> new NewCustomer());

        JButton btnRoom = new JButton("Room");
        btnRoom.setBounds(30, 70, 200, 30);
        btnRoom.setBackground(Color.BLACK);
        btnRoom.setForeground(Color.WHITE);
        panel1.add(btnRoom);
        btnRoom.addActionListener(e -> new Room());

        JButton btnDepartment = new JButton("Department");
        btnDepartment.setBounds(30, 110, 200, 30);
        btnDepartment.setBackground(Color.BLACK);
        btnDepartment.setForeground(Color.WHITE);
        panel1.add(btnDepartment);
        btnDepartment.addActionListener(e -> new Department());

        JButton btnAEI = new JButton("All Employee Info");
        btnAEI.setBounds(30, 150, 200, 30);
        btnAEI.setBackground(Color.BLACK);
        btnAEI.setForeground(Color.WHITE);
        panel1.add(btnAEI);
        btnAEI.addActionListener(e -> new Employee());

        JButton btnCI = new JButton("Customer Info");
        btnCI.setBounds(30, 190, 200, 30);
        btnCI.setBackground(Color.BLACK);
        btnCI.setForeground(Color.WHITE);
        panel1.add(btnCI);
        btnCI.addActionListener(e -> new CustomerInfo());

        JButton btnMI = new JButton("Manager Info");
        btnMI.setBounds(30, 230, 200, 30);
        btnMI.setBackground(Color.BLACK);
        btnMI.setForeground(Color.WHITE);
        panel1.add(btnMI);
        btnMI.addActionListener(e -> new ManagerInfo());

        JButton btnCO = new JButton("Check Out");
        btnCO.setBounds(30, 270, 200, 30);
        btnCO.setBackground(Color.BLACK);
        btnCO.setForeground(Color.WHITE);
        panel1.add(btnCO);
        btnCO.addActionListener(e -> new CheckOut());

        JButton btnUC = new JButton("Update Check-In Details");
        btnUC.setBounds(30, 310, 200, 30);
        btnUC.setBackground(Color.BLACK);
        btnUC.setForeground(Color.WHITE);
        panel1.add(btnUC);
        btnUC.addActionListener(e -> new UpdateCheck());

        JButton btnURS = new JButton("Update Room Status");
        btnURS.setBounds(30, 350, 200, 30);
        btnURS.setBackground(Color.BLACK);
        btnURS.setForeground(Color.WHITE);
        panel1.add(btnURS);
        btnURS.addActionListener(e -> new UpdateRoom());

        JButton btnPUS = new JButton("Pick up Service");
        btnPUS.setBounds(30, 390, 200, 30);
        btnPUS.setBackground(Color.BLACK);
        btnPUS.setForeground(Color.WHITE);
        panel1.add(btnPUS);
        btnPUS.addActionListener(e -> new PickUp());

        JButton btnSR = new JButton("Search Room");
        btnSR.setBounds(30, 430, 200, 30);
        btnSR.setBackground(Color.BLACK);
        btnSR.setForeground(Color.WHITE);
        panel1.add(btnSR);
        btnSR.addActionListener(e -> new SearchRoom());

        JButton btnCR = new JButton("Customer Report");
        btnCR.setBounds(30, 470, 200, 30);
        btnCR.setBackground(Color.BLACK);
        btnCR.setForeground(Color.WHITE);
        panel1.add(btnCR);
        btnCR.addActionListener(e -> new CustomerReport());

        JButton logout = new JButton("Logout");
        logout.setBounds(30, 510, 95, 30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        panel1.add(logout);
        logout.addActionListener(e -> System.exit(0));

        JButton back = new JButton("Back");
        back.setBounds(140, 510, 95, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel1.add(back);
        back.addActionListener(e -> {
            setVisible(false);
            new Dashboard();
        });

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(1950, 1090);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Reception();
    }
}
