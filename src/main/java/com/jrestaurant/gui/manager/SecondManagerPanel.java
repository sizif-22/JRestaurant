package com.jrestaurant.gui.manager;

import javax.swing.*;


import com.jrestaurant.classes.*;
import com.jrestaurant.gui.MainFrame;

import java.awt.*;

public class SecondManagerPanel extends JPanel {

     public SecondManagerPanel(MainFrame frame) {
          frame.getEmp();
          setLayout(null);
          setBackground(new Color(21, 21, 21));
          setBounds(0, 0, MainFrame.getFrameWidth(), MainFrame.getFrameHeight());

          JLabel label = new JLabel("Delivery Orders.");
          label.setFont(new Font("Arial", Font.BOLD, 24));
          label.setForeground(Color.WHITE);
          label.setBounds(MainFrame.getWidthRatio(25), MainFrame.getHeightRatio(7), 200, 50);
          add(label);

          JPanel leftPanel = new JPanel();
          leftPanel.setBounds(0, 0, MainFrame.getWidthRatio(20), MainFrame.getFrameHeight());
          leftPanel.setBackground(new Color(25, 25, 25));
          leftPanel.setLayout(null);
          add(leftPanel);

          JPanel table = new JPanel();
          table.setLayout(null);
          table.setBounds(MainFrame.getWidthRatio(25), MainFrame.getHeightRatio(15), MainFrame.getWidthRatio(70),
                    MainFrame.getHeightRatio(60));
          table.setBorder(BorderFactory.createLineBorder(Color.white));
          table.setBackground(new Color(25, 25, 25));
          add(table);

          JLabel nameHeader = new JLabel("ClientName");
          nameHeader.setFont(new Font("Arial", Font.BOLD, 22));
          nameHeader.setForeground(Color.WHITE);
          nameHeader.setBounds(10, 0, (int) MainFrame.getWidthRatio(70) / 5, 40);
          table.add(nameHeader);

          JLabel phoneNumberHeader = new JLabel("PhoneNumber");
          phoneNumberHeader.setFont(new Font("Arial", Font.BOLD, 22));
          phoneNumberHeader.setForeground(Color.WHITE);
          phoneNumberHeader.setBounds((int) (MainFrame.getWidthRatio(70) * 1 / 5) + 10, 0,
                    (int) MainFrame.getWidthRatio(70) / 5,
                    40);
          table.add(phoneNumberHeader);

          JLabel jobTitleHeader = new JLabel("Address");
          jobTitleHeader.setFont(new Font("Arial", Font.BOLD, 22));
          jobTitleHeader.setForeground(Color.WHITE);
          jobTitleHeader.setBounds((int) (MainFrame.getWidthRatio(70) * 2 / 5) + 10, 0,
                    (int) MainFrame.getWidthRatio(70) / 5, 40);
          table.add(jobTitleHeader);

          JLabel salaryHeader = new JLabel("Total");
          salaryHeader.setFont(new Font("Arial", Font.BOLD, 22));
          salaryHeader.setForeground(Color.WHITE);
          salaryHeader.setBounds((int) (MainFrame.getWidthRatio(70) * 3 / 5) + 10, 0,
                    (int) MainFrame.getWidthRatio(70) / 5, 40);
          table.add(salaryHeader);

          JLabel actionHeader = new JLabel("Actions");
          actionHeader.setFont(new Font("Arial", Font.BOLD, 22));
          actionHeader.setForeground(Color.WHITE);
          actionHeader.setBounds((int) (MainFrame.getWidthRatio(70) * 4 / 5) + 10, 0,
                    (int) MainFrame.getWidthRatio(70) / 5, 40);
          table.add(actionHeader);

          java.util.List<Delivery> DeliveryOrders = Delivery.getAllOrders();
          int index = 0;
          for (Delivery delivery : DeliveryOrders) {
               DeliveryOrderRows dor = new DeliveryOrderRows(delivery, ++index, frame);
               table.add(dor);
          }



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
