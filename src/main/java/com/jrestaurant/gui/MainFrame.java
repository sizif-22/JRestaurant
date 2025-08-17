package com.jrestaurant.gui;

import java.awt.*;
import javax.swing.*;

import com.jrestaurant.classes.Employee;
import com.jrestaurant.config.DatabaseConfig;
import com.jrestaurant.gui.login.LoginPanel;
import com.jrestaurant.gui.manager.MainManagerPanel;
import com.jrestaurant.gui.manager.SecondManagerPanel;

public class MainFrame extends JFrame {
     private JPanel currentPanel;
     private int width = (int) (1920 * 0.7);
     private int height = (int) (1080 * 0.7);

     public MainFrame() {

          // ImageIcon img = new
          // ImageIcon(MainFrame.class.getResource("../assets/swuber.jpg"));
          // setIconImage(img.getImage());
          DatabaseConfig dbconfig = new DatabaseConfig();
          Employee.setODBManager(dbconfig);
          setTitle("JRestaurant");
          getContentPane().setBackground(new Color(21, 21, 21));
          setSize(width, height);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          setResizable(false);
          setLocationRelativeTo(null);
          currentPanel = new JPanel(new BorderLayout());

          setLayout(new BorderLayout());
          add(currentPanel, BorderLayout.CENTER);
          setVisible(true);
          setPanel(new LoginPanel(this));
     }

     public void setPanel(JPanel panel) {
          currentPanel.removeAll();
          currentPanel.add(panel, BorderLayout.CENTER);
          SwingUtilities.updateComponentTreeUI(currentPanel);
     }

     @Override
     public int getWidth() {
          return this.width;
     }

     @Override
     public int getHeight() {
          return (this.height - 38);
     }

     public int getWidthRatio(int ratio) {
          return (int) (this.width * ratio / 100);
     }

     public int getHeightRatio(int ratio) {
          return (int) ((this.height - 38) * ratio / 100);
     }

     public void goToManagerMainPanel() {
          setPanel(new MainManagerPanel(this));
     }

     public void goToSecondManagerPanel() {
          setPanel(new SecondManagerPanel(this));
     }

     public void logOut() {
          setPanel(new LoginPanel(this));
     }

}
