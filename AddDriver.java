package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener {
    JTextField t1, t2, t3, t4, t5;
    JComboBox<String> comboBox, comboBox2;
    JButton b1, b2;

    AddDriver() {
        JPanel contentPane = new JPanel();
        contentPane.setBounds(5, 5, 840, 490);
        contentPane.setBackground(new Color(3, 45, 48));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel l10 = new JLabel("Add Driver");
        l10.setFont(new Font("Tahoma", Font.BOLD, 20));
        l10.setBounds(150, 10, 200, 30);
        l10.setForeground(Color.WHITE);
        contentPane.add(l10);

        JLabel l1 = new JLabel("Name");
        l1.setForeground(Color.WHITE);
        l1.setBounds(60, 60, 120, 30);
        contentPane.add(l1);

        t1 = new JTextField();
        t1.setBounds(200, 60, 150, 30);
        contentPane.add(t1);

        JLabel l2 = new JLabel("Age");
        l2.setForeground(Color.WHITE);
        l2.setBounds(60, 110, 120, 30);
        contentPane.add(l2);

        t2 = new JTextField();
        t2.setBounds(200, 110, 150, 30);
        contentPane.add(t2);

        JLabel l3 = new JLabel("Gender");
        l3.setForeground(Color.WHITE);
        l3.setBounds(60, 160, 120, 30);
        contentPane.add(l3);

        comboBox = new JComboBox<>(new String[]{"Male", "Female"});
        comboBox.setBounds(200, 160, 150, 30);
        contentPane.add(comboBox);

        JLabel l4 = new JLabel("Car Company");
        l4.setForeground(Color.WHITE);
        l4.setBounds(60, 210, 120, 30);
        contentPane.add(l4);

        t3 = new JTextField();
        t3.setBounds(200, 210, 150, 30);
        contentPane.add(t3);

        JLabel l5 = new JLabel("Car Name");
        l5.setForeground(Color.WHITE);
        l5.setBounds(60, 260, 120, 30);
        contentPane.add(l5);

        t4 = new JTextField();
        t4.setBounds(200, 260, 150, 30);
        contentPane.add(t4);

        JLabel l6 = new JLabel("Available");
        l6.setForeground(Color.WHITE);
        l6.setBounds(60, 310, 120, 30);
        contentPane.add(l6);

        comboBox2 = new JComboBox<>(new String[]{"Yes", "No"});
        comboBox2.setBounds(200, 310, 150, 30);
        contentPane.add(comboBox2);

        JLabel l7 = new JLabel("Location");
        l7.setForeground(Color.WHITE);
        l7.setBounds(60, 360, 120, 30);
        contentPane.add(l7);

        t5 = new JTextField();
        t5.setBounds(200, 360, 150, 30);
        contentPane.add(t5);

        b1 = new JButton("Add Driver");
        b1.setBounds(60, 420, 130, 30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        contentPane.add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(220, 420, 130, 30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        contentPane.add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/driver.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        JLabel l8 = new JLabel(new ImageIcon(i2));
        l8.setBounds(480, 60, 300, 300);
        contentPane.add(l8);

        setLayout(null);
        setBounds(300, 200, 850, 500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String name = t1.getText();
            String age = t2.getText();
            String gender = (String) comboBox.getSelectedItem();
            String car_company = t3.getText();
            String car_name = t4.getText();
            String available = (String) comboBox2.getSelectedItem();
            String location = t5.getText();

            try {
                connection c = new connection();
                // ✅ exclude driver_id since it's AUTO_INCREMENT
                String str = "INSERT INTO driver (name, age, gender, car_company, car_name, available, location) " +
                        "VALUES('" + name + "', '" + age + "', '" + gender + "', '" + car_company + "', '" + car_name + "', '" + available + "', '" + location + "')";
                c.statement.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Driver Added Successfully");
                this.setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == b2) {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddDriver();
    }
}
