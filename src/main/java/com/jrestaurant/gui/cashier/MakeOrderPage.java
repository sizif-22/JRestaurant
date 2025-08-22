package com.jrestaurant.gui.cashier;

import java.awt.*;
import javax.swing.*;

import com.jrestaurant.gui.MainFrame;

public class MakeOrderPage extends JPanel {

    public MakeOrderPage(MainFrame frame) {

         setLayout(null);
         
        JLabel Name = new JLabel("Make Order");
        Name.setForeground(Color.BLACK);
        Name.setFont(new Font("Arial", Font.BOLD, 50));
         Name.setBounds((int)(getWidth()*0.21),(int)(getHeight()*0.05),(int)(getWidth()*0.3) , (int)(getHeight()*0.2));
         add(Name);
         
        JLabel Items = new JLabel("food Items : ");
        Items.setFont(new Font("Arial" ,Font.BOLD,20));
        Items.setBounds((int)(getWidth()*0.21),(int)(getHeight()*0.1),(int)(getWidth()*0.31) , (int)(getHeight()*0.2));
        add(Items);
        
        
        JLabel selected = new JLabel("Items Selected:");
        selected.setFont(new Font("Arial" , Font.ITALIC,20));
        selected.setBounds((int)(getWidth()*0.21),(int)(getHeight()*0.5),(int)(getWidth()*0.5) , (int)(getHeight()*0.2));
        add(selected);
        
        JButton CancelButton = new JButton("Cancel");
          CancelButton.setFont(new Font("Arial", Font.BOLD, 18));
          CancelButton.setBackground(Color.GRAY);
          CancelButton.setForeground(Color.white);
          CancelButton.setBounds((int)(getWidth()*0.6),(int)(getHeight()*0.85),(int)(getWidth()*0.20) - 45 , 40);
          add(CancelButton);
          
          
          
        JButton NextButton = new JButton("Next");
          NextButton.setFont(new Font("Arial", Font.BOLD, 18));
          NextButton.setBackground(Color.GRAY);
          NextButton.setForeground(Color.white);
          NextButton.setBounds((int)(getWidth()*0.78),(int)(getHeight()*0.85),(int)(getWidth()*0.20) - 45 , 40);
          add(NextButton);
          
          NextButton.addActionListener(e ->{
              new ItemsSelectedPage(frame).setVisible(true);
          });
        
        JPanel LeftPanel = new JPanel();
            LeftPanel.setBounds(0, 0,(int)(getWidth()*0.20), getHeight());
            LeftPanel.setBackground(new Color(25, 25, 25));
            LeftPanel.setLayout(null);
            add(LeftPanel);
            
            
        JButton MakeOrderButton = new JButton("Make Order");
          MakeOrderButton.setFont(new Font("Arial", Font.BOLD, 18));
          MakeOrderButton.setBackground(Color.DARK_GRAY);
          MakeOrderButton.setForeground(Color.BLACK);
          MakeOrderButton.setBounds(20, (int)(getHeight()*0.30), (int)(getWidth()*0.20) - 30, 35);
          LeftPanel.add(MakeOrderButton);
          
          
        JButton reservationButton = new JButton("Reservation");
          reservationButton.setFont(new Font("Arial", Font.BOLD, 18));
          reservationButton.setBackground(Color.DARK_GRAY);
          reservationButton.setForeground(Color.BLACK);
          reservationButton.setBounds(20, (int)(getHeight()*0.38), (int)(getWidth()*0.20) - 30, 35);
          LeftPanel.add(reservationButton);
          
          
          
          JButton OrdersButton = new JButton("Orders");
          OrdersButton.setFont(new Font("Arial", Font.BOLD, 18));
          OrdersButton.setBackground(Color.DARK_GRAY);
          OrdersButton.setForeground(Color.BLACK);
          OrdersButton.setBounds(20, (int)(getHeight()*0.46), (int)(getWidth()*0.20) - 30, 35);
          LeftPanel.add(OrdersButton);
        
    }
}
