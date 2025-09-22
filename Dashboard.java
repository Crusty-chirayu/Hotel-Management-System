package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {

    JButton add, rec;

    Dashboard() {
        super("HOTEL MANAGEMENT SYSTEM by: Team CHIKALAX");

        // Reception button
        rec = new JButton("RECEPTION");
        rec.setBounds(425, 510, 140, 30);
        rec.setFont(new Font("Tahoma", Font.BOLD, 15));
        rec.setBackground(new Color(255, 98, 0));
        rec.setForeground(Color.WHITE);
        rec.addActionListener(this);
        add(rec);

        // Admin button
        add = new JButton("ADMIN");
        add.setBounds(800, 510, 140, 30);
        add.setFont(new Font("Tahoma", Font.BOLD, 15));
        add.setBackground(new Color(255, 98, 0));
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        // Admin icon
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/boss.png"));
        Image i2 = i11.getImage().getScaledInstance(200, 195, Image.SCALE_DEFAULT);
        JLabel label1 = new JLabel(new ImageIcon(i2));
        label1.setBounds(770, 300, 200, 195);
        add(label1);

        // Reception icon
        ImageIcon i111 = new ImageIcon(ClassLoader.getSystemResource("icon/Reception.png"));
        Image i22 = i111.getImage().getScaledInstance(200, 195, Image.SCALE_DEFAULT);
        JLabel label11 = new JLabel(new ImageIcon(i22));
        label11.setBounds(390, 300, 200, 195);
        add(label11);

        // Background image
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Dashboard.gif"));
        Image i1 = imageIcon.getImage().getScaledInstance(1950, 1090, Image.SCALE_DEFAULT);
        JLabel label = new JLabel(new ImageIcon(i1));
        label.setBounds(0, 0, 1950, 1090);
        add(label);

        // Frame settings
        setLayout(null);
        setSize(1950, 1090);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rec) {
            new Reception(); // for reception
        } else if (e.getSource() == add) {
            setVisible(false); // hide dashboard
            new Login2(); // open admin login
        }
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
