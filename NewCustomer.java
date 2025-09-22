package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class NewCustomer extends JFrame implements ActionListener {

    JComboBox<String> comboBox, needDriverBox;
    JTextField textFieldNumber, TextName, TextCountry, TextDeposite;
    JRadioButton r1, r2;
    Choice c1, carChoice;
    JLabel date, labelCar;
    JButton add, back;

    public NewCustomer() {

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 840, 600);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        // Customer image
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/customer.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        JLabel imgLabel = new JLabel(new ImageIcon(image));
        imgLabel.setBounds(550, 150, 200, 200);
        panel.add(imgLabel);

        // Title
        JLabel labelName = new JLabel("NEW CUSTOMER FORM");
        labelName.setBounds(118, 11, 260, 53);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelName.setForeground(Color.WHITE);
        panel.add(labelName);

        // ID
        JLabel labelID = new JLabel("ID :");
        labelID.setBounds(35, 76, 200, 14);
        labelID.setForeground(Color.WHITE);
        labelID.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelID);

        comboBox = new JComboBox<>(new String[]{"Passport", "Aadhar Card", "Voter Id", "Driving License"});
        comboBox.setBounds(271, 73, 150, 20);
        comboBox.setBackground(new Color(3, 45, 48));
        comboBox.setForeground(Color.WHITE);
        panel.add(comboBox);

        // Contact
        JLabel labelNumber = new JLabel("Contact :");
        labelNumber.setBounds(35, 111, 200, 14);
        labelNumber.setForeground(Color.WHITE);
        labelNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271, 111, 150, 20);
        panel.add(textFieldNumber);

        // Name
        JLabel labelNameField = new JLabel("Name :");
        labelNameField.setBounds(35, 151, 200, 14);
        labelNameField.setForeground(Color.WHITE);
        labelNameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelNameField);

        TextName = new JTextField();
        TextName.setBounds(271, 151, 150, 20);
        panel.add(TextName);

        // Gender
        JLabel labelGender = new JLabel("Gender :");
        labelGender.setBounds(35, 191, 200, 14);
        labelGender.setForeground(Color.WHITE);
        labelGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setForeground(Color.WHITE);
        r1.setBackground(new Color(3, 45, 48));
        r1.setBounds(271, 191, 80, 20);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setForeground(Color.WHITE);
        r2.setBackground(new Color(3, 45, 48));
        r2.setBounds(350, 191, 80, 20);
        panel.add(r2);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        // Country
        JLabel labelCountry = new JLabel("Country :");
        labelCountry.setBounds(35, 231, 200, 14);
        labelCountry.setForeground(Color.WHITE);
        panel.add(labelCountry);

        TextCountry = new JTextField();
        TextCountry.setBounds(271, 231, 150, 20);
        panel.add(TextCountry);

        // Room choice
        JLabel labelRoom = new JLabel("Allocated Room Number :");
        labelRoom.setBounds(35, 274, 200, 14);
        labelRoom.setForeground(Color.WHITE);
        panel.add(labelRoom);

        c1 = new Choice();
        try {
            connection c = new connection();
            ResultSet rs = c.getStatement().executeQuery("select * from room where availability='Available'");
            while (rs.next()) {
                c1.add(rs.getString("roomnumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        c1.setBounds(271, 274, 150, 20);
        panel.add(c1);

        // Check-in date
        JLabel labelCIS = new JLabel("Checked-In :");
        labelCIS.setBounds(35, 316, 200, 14);
        labelCIS.setForeground(Color.WHITE);
        panel.add(labelCIS);

        Date date1 = new Date();
        date = new JLabel("" + date1);
        date.setBounds(271, 316, 200, 14);
        date.setForeground(Color.WHITE);
        panel.add(date);

        // Deposit
        JLabel labelDeposit = new JLabel("Deposit :");
        labelDeposit.setBounds(35, 359, 200, 14);
        labelDeposit.setForeground(Color.WHITE);
        panel.add(labelDeposit);

        TextDeposite = new JTextField();
        TextDeposite.setBounds(271, 359, 150, 20);
        panel.add(TextDeposite);

        // Need Driver
        JLabel labelDriver = new JLabel("Need Driver :");
        labelDriver.setBounds(35, 400, 200, 14);
        labelDriver.setForeground(Color.WHITE);
        panel.add(labelDriver);

        needDriverBox = new JComboBox<>(new String[]{"No", "Yes"});
        needDriverBox.setBounds(271, 400, 150, 20);
        panel.add(needDriverBox);

        // Car model
        labelCar = new JLabel("Select Car :");
        labelCar.setBounds(35, 440, 200, 14);
        labelCar.setForeground(Color.WHITE);
        panel.add(labelCar);

        carChoice = new Choice();
        carChoice.setBounds(271, 440, 250, 20);
        panel.add(carChoice);

        labelCar.setVisible(false);
        carChoice.setVisible(false);

        // Load available drivers when user selects "Yes"
        needDriverBox.addActionListener(ev -> {
            if (needDriverBox.getSelectedItem().equals("Yes")) {
                labelCar.setVisible(true);
                carChoice.setVisible(true);
                carChoice.removeAll();
                try {
                    connection c = new connection();
                    ResultSet rs = c.getStatement().executeQuery("select * from driver where available='Yes'");
                    while (rs.next()) {
                        carChoice.add(rs.getString("car_company") + " " + rs.getString("car_name") + " - " + rs.getString("name"));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                labelCar.setVisible(false);
                carChoice.setVisible(false);
            }
        });

        add = new JButton("ADD");
        add.setBounds(100, 500, 120, 30);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(this);
        panel.add(add);

        back = new JButton("BACK");
        back.setBounds(260, 500, 120, 30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        panel.add(back);

        setLayout(null);
        setLocation(500, 150);
        setSize(850, 600);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            connection c = new connection();
            String gender = r1.isSelected() ? "Male" : r2.isSelected() ? "Female" : null;
            String idType = (String) comboBox.getSelectedItem();
            String contact = textFieldNumber.getText();
            String name = TextName.getText();
            String country = TextCountry.getText();
            String room = c1.getSelectedItem();
            String checkin = date.getText();
            String deposit = TextDeposite.getText();
            String driverInfo = needDriverBox.getSelectedItem().equals("Yes") ? carChoice.getSelectedItem() : null;

            try {
                // Insert customer
                String q = "insert into customer (document, number, name, gender, country, room, checkintime, deposit, driver_assigned, vehicle_assigned) " +
                        "values ('" + idType + "', '" + contact + "','" + name + "','" + gender + "', '" + country + "', '" + room + "', '" + checkin + "', '" + deposit + "', '" + (driverInfo != null ? driverInfo.split(" - ")[1] : null) + "', '" + (driverInfo != null ? driverInfo.split(" - ")[0] : null) + "')";

                String q1 = "update room set availability='Occupied' where roomnumber='" + room + "'";
                c.getStatement().executeUpdate(q);
                c.getStatement().executeUpdate(q1);

                // If driver is assigned, mark as unavailable
                if (driverInfo != null) {
                    String driverName = driverInfo.split(" - ")[1];
                    String q2 = "update driver set available='No' where name='" + driverName + "'";
                    c.getStatement().executeUpdate(q2);
                }

                JOptionPane.showMessageDialog(null, "Customer Added Successfully");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new NewCustomer();
    }
}
