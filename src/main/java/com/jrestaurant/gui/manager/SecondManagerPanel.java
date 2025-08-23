package com.jrestaurant.gui.manager;

import javax.swing.*;

import com.jrestaurant.classes.Role;
import com.jrestaurant.gui.MainFrame;

import java.awt.*;

public class SecondManagerPanel extends JPanel {

     public SecondManagerPanel(MainFrame frame) {
          frame.getEmp();
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

          if (frame.getEmp().getRole() == Role.MANAGER) {
               JButton empButton = new JButton("Employees");
               empButton.setFont(new Font("Arial", Font.BOLD, 18));
               empButton.setBackground(Color.white);
               empButton.setForeground(Color.BLACK);
               empButton.setBounds(30, MainFrame.getHeightRatio(50) - 55, MainFrame.getWidthRatio(20) - 60, 45);
               empButton.addActionListener(e -> frame.goToManagerMainPanel());
               leftPanel.add(empButton);
          } else if (frame.getEmp().getRole() == Role.CASHIER) {
               JButton makeOrderButton = new JButton("Make Order");
               makeOrderButton.setFont(new Font("Arial", Font.BOLD, 18));
               makeOrderButton.setBackground(Color.white);
               makeOrderButton.setForeground(Color.BLACK);
               makeOrderButton.setBounds(30, MainFrame.getHeightRatio(50) - 110, MainFrame.getWidthRatio(20) - 60, 45);
               makeOrderButton.addActionListener(e -> frame.goToMakeOrderPanel());
               leftPanel.add(makeOrderButton);

               JButton reservationButton = new JButton("Reservation");
               reservationButton.setFont(new Font("Arial", Font.BOLD, 18));
               reservationButton.setBackground(Color.white);
               reservationButton.setForeground(Color.BLACK);
               reservationButton.setBounds(30, MainFrame.getHeightRatio(50) - 35, MainFrame.getWidthRatio(20) - 60, 45);
               reservationButton.addActionListener(e -> frame.goToMakeReservationPanel());
               leftPanel.add(reservationButton);
          }

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
          logoutButton.addActionListener(e -> frame.logOut());
          leftPanel.add(logoutButton);
     }
}
