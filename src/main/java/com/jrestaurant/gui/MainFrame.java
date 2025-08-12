package com.jrestaurant.gui;

import java.awt.*;
import javax.swing.*;
import com.jrestaurant.config.DatabaseConfig;

public class MainFrame extends JFrame {
     private JPanel currentPanel;

     public MainFrame() {

          // ImageIcon img = new
          // ImageIcon(MainFrame.class.getResource("../assets/swuber.jpg"));
          // setIconImage(img.getImage());
		DatabaseConfig dbconfig = new DatabaseConfig();

          setTitle("JRestaurant");
          getContentPane().setBackground(new Color(21, 21, 21));
          setSize(1200, 800);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          setResizable(false);
          setLocationRelativeTo(null);

          currentPanel = new JPanel(new BorderLayout());
          setLayout(new BorderLayout());
          add(currentPanel, BorderLayout.CENTER);
          // setPanel(loginPanel);

          setVisible(true);
     }

     public void setPanel(JPanel panel) {
          currentPanel.removeAll();
          currentPanel.add(panel, BorderLayout.CENTER);
          SwingUtilities.updateComponentTreeUI(currentPanel);
     }
}
