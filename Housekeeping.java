package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;

public class Housekeeping extends JFrame {

    Housekeeping() {
        setTitle("Housekeeping");

        JLabel heading = new JLabel("Housekeeping Section");
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        heading.setBounds(100, 50, 300, 30);
        add(heading);

        // Example: Add housekeeping task button
        JButton addTask = new JButton("Add Task");
        addTask.setBounds(100, 120, 150, 30);
        add(addTask);

        // Example: View housekeeping status
        JButton viewStatus = new JButton("View Status");
        viewStatus.setBounds(100, 170, 150, 30);
        add(viewStatus);

        getContentPane().setBackground(new Color(230, 240, 250));
        setLayout(null);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Housekeeping();
    }
}
