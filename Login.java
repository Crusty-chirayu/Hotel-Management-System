package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JTextField textField1;
    JPasswordField passwordField1;
    JButton b1, b2;

    Login() {
        JLabel label1 = new JLabel("Username");
        label1.setBounds(40,20,100,30);
        label1.setFont(new Font("Tahoma",Font.BOLD,16));
        label1.setForeground(Color.WHITE);
        add(label1);

        JLabel label2 = new JLabel("Password");
        label2.setBounds(40,70,100,30);
        label2.setFont(new Font("Tahoma",Font.BOLD,16));
        label2.setForeground(Color.WHITE);
        add(label2);

        textField1 = new JTextField();
        textField1.setBounds(150,20,150,30);
        textField1.setForeground(Color.WHITE);
        textField1.setFont(new Font("Tahoma",Font.PLAIN,15));
        textField1.setBackground(new Color(26,104,110));
        add(textField1);

        passwordField1 = new JPasswordField();
        passwordField1.setBounds(150,70,150,30);
        passwordField1.setForeground(Color.WHITE);
        passwordField1.setBackground(new Color(26,104,110));
        add(passwordField1);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/usernamewalathauma.gif"));
        Image i1 = imageIcon.getImage().getScaledInstance(255,300,Image.SCALE_DEFAULT);
        JLabel label = new JLabel(imageIcon);
        label.setBounds(315,30,255,200);
        add(label);

        b1 = new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("sherif", Font.BOLD,15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("sherif", Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(new Color(13, 59, 64));
        setLayout(null);
        setLocation(400,270);
        setSize(600,300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            try {
                // ✅ just use your fixed connection class
                connection c = new connection();

                String user = textField1.getText();
                String pass = new String(passwordField1.getPassword());

                String q = "SELECT * FROM login WHERE username='" + user + "' AND password='" + pass + "'";
                ResultSet resultSet = c.getStatement().executeQuery(q);

                if(resultSet.next()){
                    new Dashboard();  // redirects to the dashboard
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null,"Invalid username or password entered");
                }

            } catch(Exception ex) {
                ex.printStackTrace();
            }
        } else {
            System.exit(0);
        }
    }

    public static void main(String[] args){
        new Login();
    }
}
