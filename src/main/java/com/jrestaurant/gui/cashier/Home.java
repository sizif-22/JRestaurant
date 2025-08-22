package com.jrestaurant.gui.cashier;

import javax.swing.*;

import com.jrestaurant.gui.MainFrame;

import java.awt.*;

public class Home extends JPanel {

     public Home(MainFrame frame) {
          frame.getEmp();
          setLayout(null);
          setBackground(new Color(21, 21, 21));
          setBounds(0, 0, MainFrame.getFrameWidth(), MainFrame.getFrameHeight());

          JLabel label = new JLabel("JRestaurant");
          label.setFont(new Font("Georgia", Font.BOLD, 36));
          label.setForeground(Color.WHITE);
          label.setBounds(MainFrame.getWidthRatio(25), MainFrame.getHeightRatio(10), 500, 50);
          add(label);

          JLabel cashierName = new JLabel("Cashier Name: " + frame.getEmp().getName());
          cashierName.setFont(new Font("Arial", Font.PLAIN, 24));
          cashierName.setForeground(Color.WHITE);
          cashierName.setBounds(MainFrame.getWidthRatio(25), MainFrame.getHeightRatio(20), 500, 50);
          add(cashierName);

          JLabel commonUsedLabel = new JLabel("Common actions:");
          commonUsedLabel.setFont(new Font("Arial", Font.ITALIC, 18));
          commonUsedLabel.setForeground(Color.LIGHT_GRAY);
          commonUsedLabel.setBounds(MainFrame.getWidthRatio(25), MainFrame.getHeightRatio(73), 200, 50);
          add(commonUsedLabel);

          JButton makeOrderButton1 = new JButton("Make Order");
          makeOrderButton1.setFont(new Font("Arial", Font.BOLD, 18));
          makeOrderButton1.setBackground(Color.white);
          makeOrderButton1.setForeground(Color.BLACK);
          makeOrderButton1.setBounds(MainFrame.getWidthRatio(25), MainFrame.getHeightRatio(80),
                    MainFrame.getWidthRatio(15), 40);
          add(makeOrderButton1);

          JPanel leftPanel = new JPanel();
          leftPanel.setBounds(0, 0, MainFrame.getWidthRatio(20), MainFrame.getFrameHeight());
          leftPanel.setBackground(new Color(25, 25, 25));
          leftPanel.setLayout(null);
          add(leftPanel);

          JButton makeOrderButton = new JButton("Make Order");
          makeOrderButton.setFont(new Font("Arial", Font.BOLD, 18));
          makeOrderButton.setBackground(Color.white);
          makeOrderButton.setForeground(Color.BLACK);
          makeOrderButton.setBounds(30, MainFrame.getHeightRatio(50) - 110, MainFrame.getWidthRatio(20) - 60, 45);
          leftPanel.add(makeOrderButton);

          JButton reservationButton = new JButton("Reservation");
          reservationButton.setFont(new Font("Arial", Font.BOLD, 18));
          reservationButton.setBackground(Color.white);
          reservationButton.setForeground(Color.BLACK);
          reservationButton.setBounds(30, MainFrame.getHeightRatio(50) - 35, MainFrame.getWidthRatio(20) - 60, 45);
          leftPanel.add(reservationButton);

          JButton orderButton = new JButton("Orders");
          orderButton.setFont(new Font("Arial", Font.BOLD, 18));
          orderButton.setBackground(Color.white);
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

     }
     void makeOrder(MainFrame frame){
          
     }

}
