package com.jrestaurant.gui.manager;

import javax.swing.*;

import com.jrestaurant.classes.Employee;
import com.jrestaurant.gui.MainFrame;

import java.awt.*;

public class SecondManagerPanel extends JPanel {

     private MainFrame frame;
     private Employee emp;

     public SecondManagerPanel(MainFrame frame) {
          this.frame = frame;
          this.emp = frame.getEmp();
          setLayout(null);
          setBackground(new Color(21, 21, 21));
          setBounds(0, 0, MainFrame.getFrameWidth(), MainFrame.getFrameHeight());

          JLabel label = new JLabel("Manager Page 2.");
          label.setFont(new Font("Arial", Font.BOLD, 24));
          label.setForeground(Color.WHITE);
          label.setBounds(MainFrame.getWidthRatio(25), MainFrame.getHeightRatio(10), 200, 50);
          add(label);

          JPanel leftPanel = new JPanel();
          leftPanel.setBounds(0, 0, MainFrame.getWidthRatio(20), MainFrame.getFrameHeight());
          leftPanel.setBackground(new Color(25, 25, 25));
          leftPanel.setLayout(null);
          add(leftPanel);

          JButton empButton = new JButton("Employees");
          empButton.setFont(new Font("Arial", Font.BOLD, 18));
          empButton.setBackground(Color.white);
          empButton.setForeground(Color.BLACK);
          empButton.setBounds(30, MainFrame.getHeightRatio(50) - 55, MainFrame.getWidthRatio(20) - 60, 45);
          leftPanel.add(empButton);

          JButton orderButton = new JButton("Orders");
          orderButton.setFont(new Font("Arial", Font.BOLD, 18));
          orderButton.setBackground(Color.DARK_GRAY);
          orderButton.setForeground(Color.BLACK);
          orderButton.setBounds(30, MainFrame.getHeightRatio(50) + 40, MainFrame.getWidthRatio(20) - 60, 45);
          leftPanel.add(orderButton);

          JButton logoutButton = new JButton("Log out");
          logoutButton.setFont(new Font("Arial", Font.BOLD, 18));
          logoutButton.setBackground(Color.white);
          logoutButton.setForeground(Color.BLACK);
          logoutButton.setBounds(30, MainFrame.getFrameHeight() - 55, MainFrame.getWidthRatio(20) - 60, 45);
          leftPanel.add(logoutButton);

          logoutButton.addActionListener(e -> {
               frame.logOut();
          });

          empButton.addActionListener(e -> {
               frame.goToManagerMainPanel();
          });
     }

}
