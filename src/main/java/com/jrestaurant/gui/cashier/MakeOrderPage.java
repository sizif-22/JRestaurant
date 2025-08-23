package com.jrestaurant.gui.cashier;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import com.jrestaurant.classes.FoodItem;
import com.jrestaurant.classes.OrderHasFoodItems;
import com.jrestaurant.gui.MainFrame;

public class MakeOrderPage extends JPanel {

  public MakeOrderPage(MainFrame frame) {

    setBounds(0, 0, MainFrame.getFrameWidth(), MainFrame.getFrameHeight());
    setBackground(new Color(21, 21, 21));
    setLayout(null);

    JLabel Name = new JLabel("Make Order");
    Name.setForeground(Color.BLACK);
    Name.setFont(new Font("Arial", Font.BOLD, 50));
    Name.setBounds((int) (getWidth() * 0.21), (int) (getHeight() * 0.05), (int) (getWidth() * 0.3),
        (int) (getHeight() * 0.2));
    add(Name);

    JLabel Items = new JLabel("food Items : ");
    Items.setFont(new Font("Arial", Font.BOLD, 20));
    Items.setBounds((int) (getWidth() * 0.21), (int) (getHeight() * 0.1), (int) (getWidth() * 0.31),
        (int) (getHeight() * 0.2));
    add(Items);

    // JLabel selected = new JLabel("Items Selected:");
    // selected.setFont(new Font("Arial" , Font.ITALIC,20));
    // selected.setBounds((int)(getWidth()*0.21),(int)(getHeight()*0.5),(int)(getWidth()*0.5)
    // , (int)(getHeight()*0.2));
    // add(selected);
    JPanel itemsPanel = new JPanel();
    itemsPanel.setLayout(new GridLayout(0, 4, MainFrame.getWidthRatio(2), MainFrame.getHeightRatio(2))); // Changed to 4
                                                                                                         // columns,
                                                                                                         // auto rows
    itemsPanel.setBounds(MainFrame.getWidthRatio(25), MainFrame.getHeightRatio(35), MainFrame.getWidthRatio(70),
        MainFrame.getHeightRatio(50)); // Reduced height to make room for buttons
    itemsPanel.setBackground(new Color(25, 25, 25));

    // Add the itemsPanel to the main panel
    add(itemsPanel);
    System.out.println("List: "+ frame.getOrder().getOrderItems());
    
    for (FoodItem foodItem : FoodItem.getAllItems()) {
      System.out.println(foodItem.getName());
      System.out.println(foodItem.getPrice());
      JPanel itemPanel = new JPanel(null);
      itemPanel.setPreferredSize(new Dimension(180, 200)); // Increased width for better text display
      itemPanel.setBackground(new Color(40, 40, 40));
      if (frame.getOrder().getOrderItems().contains(new OrderHasFoodItems(frame.getOrder(), foodItem))) {
        System.out.println("Res: "+ frame.getOrder().getOrderItems().contains(new OrderHasFoodItems(frame.getOrder(), foodItem)));
        itemPanel.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180)));
      }

      JLabel itemName = new JLabel(foodItem.getName());
      itemName.setFont(new Font("Arial", Font.BOLD, 14)); // Adjusted font size
      itemName.setForeground(Color.WHITE);
      itemName.setBounds(5, 5, 170, 30);
      itemPanel.add(itemName);

      JLabel itemPrice = new JLabel("$" + String.format("%.2f", foodItem.getPrice())); // Better price formatting
      itemPrice.setFont(new Font("Arial", Font.BOLD, 16));
      itemPrice.setForeground(Color.WHITE);
      itemPrice.setBounds(5, 40, 170, 30);
      itemPanel.add(itemPrice);
      if (frame.getOrder().getOrderItems().contains(new OrderHasFoodItems(frame.getOrder(), foodItem))) {
        JButton addButton = new JButton("Add Item");
        addButton.setFont(new Font("Arial", Font.BOLD, 14));
        addButton.setBackground(new Color(70, 130, 180));
        addButton.setForeground(Color.WHITE);
        addButton.setBounds(5, 80, 170, 40);
        itemPanel.add(addButton);
        addButton.addActionListener(e -> {
          frame.getOrder().addItemToTheList(foodItem);
          frame.goToMakeOrderPanel();
        });
      } else {
        JButton addButton = new JButton("Cancel");
        addButton.setFont(new Font("Arial", Font.BOLD, 14));
        addButton.setBackground(Color.red);
        addButton.setForeground(Color.WHITE);
        addButton.setBounds(5, 80, 170, 40);
        itemPanel.add(addButton);
        addButton.addActionListener(e -> {
          frame.getOrder().removeFromList(foodItem);
          frame.goToMakeOrderPanel();
        });
      }

      itemsPanel.add(itemPanel);
    }

    JButton CancelButton = new JButton("Cancel");
    CancelButton.setFont(new Font("Arial", Font.BOLD, 18));
    CancelButton.setBackground(Color.GRAY);
    CancelButton.setForeground(Color.white);
    CancelButton.setBounds((int) (getWidth() * 0.6), (int) (getHeight() * 0.85), (int) (getWidth() * 0.20) - 45, 40);
    CancelButton.addActionListener(e -> {
      frame.goToCashierPanel();
    });
    add(CancelButton);

    JButton NextButton = new JButton("Next");
    NextButton.setFont(new Font("Arial", Font.BOLD, 18));
    NextButton.setBackground(Color.GRAY);
    NextButton.setForeground(Color.white);
    NextButton.setBounds((int) (getWidth() * 0.78), (int) (getHeight() * 0.85), (int) (getWidth() * 0.20) - 45, 40);
    add(NextButton);

    // Add action listeners

    NextButton.addActionListener(e -> {
      new ItemsSelectedPage(frame).setVisible(true);
    });

    // JPanel LeftPanel = new JPanel();
    // LeftPanel.setBounds(0, 0,(int)(getWidth()*0.20), getHeight());
    // LeftPanel.setBackground(new Color(25, 25, 25));
    // LeftPanel.setLayout(null);
    // add(LeftPanel);

    // JButton MakeOrderButton = new JButton("Make Order");
    // MakeOrderButton.setFont(new Font("Arial", Font.BOLD, 18));
    // MakeOrderButton.setBackground(Color.DARK_GRAY);
    // MakeOrderButton.setForeground(Color.BLACK);
    // MakeOrderButton.setBounds(20, (int)(getHeight()*0.30), (int)(getWidth()*0.20)
    // - 30, 35);
    // LeftPanel.add(MakeOrderButton);

    // JButton reservationButton = new JButton("Reservation");
    // reservationButton.setFont(new Font("Arial", Font.BOLD, 18));
    // reservationButton.setBackground(Color.DARK_GRAY);
    // reservationButton.setForeground(Color.BLACK);
    // reservationButton.setBounds(20, (int)(getHeight()*0.38),
    // (int)(getWidth()*0.20) - 30, 35);
    // LeftPanel.add(reservationButton);

    // JButton OrdersButton = new JButton("Orders");
    // OrdersButton.setFont(new Font("Arial", Font.BOLD, 18));
    // OrdersButton.setBackground(Color.DARK_GRAY);
    // OrdersButton.setForeground(Color.BLACK);
    // OrdersButton.setBounds(20, (int)(getHeight()*0.46), (int)(getWidth()*0.20) -
    // 30, 35);
    // LeftPanel.add(OrdersButton);

  }
}
