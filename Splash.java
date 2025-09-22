package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {

    private float alpha = 0f; // transparency for fade-in
    private JLabel titleLabel;
    private JLabel loadingLabel;

    Splash() {
        // Load background PNG
        ImageIcon originalIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Splash.png"));
        Image image = originalIcon.getImage().getScaledInstance(875, 700, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        JLabel bgLabel = new JLabel(scaledIcon);
        bgLabel.setBounds(0, 0, 858, 680);

        // Project Title
        titleLabel = new JLabel(" Hotel CHIKALAX ", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 28));
        titleLabel.setForeground(new Color(255, 215, 0, 0)); // start invisible
        titleLabel.setBounds(0, 20, 858, 40);

        // Loading animation text
        loadingLabel = new JLabel("Loading", SwingConstants.CENTER);
        loadingLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        loadingLabel.setForeground(Color.WHITE);
        loadingLabel.setBounds(0, 600, 858, 30);

        // Add components
        setLayout(null);
        add(titleLabel);
        add(loadingLabel);
        add(bgLabel);

        setLocation(300, 80);
        setSize(858, 680);
        setVisible(true);

        // Start animations
        startFadeIn();
        startLoadingText();

        try {
            Thread.sleep(6000); // Show splash for 6 sec
            new Login(); // go to login screen
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startFadeIn() {
        Timer timer = new Timer(50, e -> {
            alpha += 0.05f;
            if (alpha > 1f) {
                alpha = 1f;
                ((Timer) e.getSource()).stop();
            }
            // Apply fade effect to title
            titleLabel.setForeground(new Color(255, 215, 0, (int) (alpha * 255)));
        });
        timer.start();
    }

    private void startLoadingText() {
        Timer timer = new Timer(500, e -> {
            String text = loadingLabel.getText();
            if (text.equals("Loading...")) {
                loadingLabel.setText("Loading");
            } else {
                loadingLabel.setText(text + ".");
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        new Splash();
    }
}
