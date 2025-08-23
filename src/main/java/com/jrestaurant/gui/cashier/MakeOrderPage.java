package com.jrestaurant.gui.cashier;

import java.awt.*;
import javax.swing.*;
import javax.swing.BorderFactory;

import com.jrestaurant.classes.FoodItem;
import com.jrestaurant.gui.MainFrame;

public class MakeOrderPage extends JPanel {

  public MakeOrderPage(MainFrame frame) {

    setBounds(0, 0, MainFrame.getFrameWidth(), MainFrame.getFrameHeight());
    setBackground(new Color(21, 21, 21));
    setLayout(null);

    JLabel pageName = new JLabel("Make Order");
    pageName.setFont(new Font("Georgia", Font.BOLD, 36));
    pageName.setForeground(Color.WHITE);
    pageName.setBounds((int) (getWidth() * 0.1), MainFrame.getHeightRatio(5), (int) (getWidth() * 0.3),
        50);
    add(pageName);

    JLabel itemsLabel = new JLabel("food Items:");
    itemsLabel.setFont(new Font("Arial", Font.BOLD, 20));
    itemsLabel.setBounds((int) (getWidth() * 0.1), MainFrame.getHeightRatio(15), (int) (getWidth() * 0.31),
        40);
    add(itemsLabel);

    // JLabel selected = new JLabel("Items Selected:");
    // selected.setFont(new Font("Arial" , Font.ITALIC,20));
    // selected.setBounds((int)(getWidth()*0.21),(int)(getHeight()*0.5),(int)(getWidth()*0.5)
    // , (int)(getHeight()*0.2));
    // add(selected);
    JPanel itemsPanel = new JPanel();
    itemsPanel.setLayout(new GridLayout(3, 5, MainFrame.getWidthRatio(2), MainFrame.getHeightRatio(2)));
    itemsPanel.setBounds(MainFrame.getWidthRatio(10), MainFrame.getHeightRatio(20), MainFrame.getWidthRatio(80),
        MainFrame.getHeightRatio(60)); // Reduced height to make room for buttons
    itemsPanel.setBackground(new Color(25, 25, 25));

    add(itemsPanel);
    for (FoodItem foodItem : FoodItem.getAllItems()) {
      // System.out.println(foodItem.getName());
      // System.out.println(foodItem.getPrice());
      JPanel itemPanel = new JPanel(null);
      itemPanel.setPreferredSize(new Dimension(180, 200)); // Increased width for better text display
      itemPanel.setBackground(new Color(40, 40, 40));

      boolean isInOrder = frame.getOrder().contains(foodItem);
      // System.out.println("isInOrder? " + isInOrder);
      if (isInOrder) {
        // System.out.println("Item " + foodItem.getName() + " is in order");
        itemPanel.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 2)); // Blue border for selected
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

      // Create button based on whether item is in order or not
      JButton actionButton;
      if (isInOrder) {
        actionButton = new JButton("Remove");
        actionButton.setBackground(Color.RED);
        actionButton.addActionListener(e -> {
          frame.getOrder().removeFromList(foodItem);
          frame.goToMakeOrderPanel();
        });
      } else {
        actionButton = new JButton("Add Item");
        actionButton.setBackground(new Color(70, 130, 180));
        actionButton.addActionListener(e -> {
          frame.getOrder().addItemToTheList(foodItem);
          // System.out.println(frame.getOrder().getOrderItems().toString());
          frame.goToMakeOrderPanel();
        });
      }

      actionButton.setFont(new Font("Arial", Font.BOLD, 14));
      actionButton.setForeground(Color.WHITE);

      // Center the button horizontally within itemPanel
      int buttonWidth = 150;
      int buttonHeight = 40;
      int x = 40; // Center horizontally (180 is panel width)
      int y = 90; // Position vertically
      actionButton.setBounds(x, y, buttonWidth, buttonHeight);

      itemPanel.add(actionButton);

      itemsPanel.add(itemPanel);
    }

    JButton cancelButton = new JButton("Cancel");
    cancelButton.setFont(new Font("Arial", Font.BOLD, 18));
    cancelButton.setBackground(Color.GRAY);
    cancelButton.setForeground(Color.white);
    cancelButton.setBounds(MainFrame.getWidthRatio(90) - 420, (int) (getHeight() * 0.85), 200, 40);
    cancelButton.addActionListener(e -> {
      frame.cancelOrder();
    });
    add(cancelButton);

    JButton nextButton = new JButton("Next");
    nextButton.setFont(new Font("Arial", Font.BOLD, 18));
    nextButton.setForeground(Color.white);
    if (frame.getOrder().getOrderItems().isEmpty()) {
      nextButton.setBackground(Color.GRAY);
    } else {
      nextButton.setBackground(new Color(70, 130, 180));
    }
    nextButton.setBounds(MainFrame.getWidthRatio(90) - 200, (int) (getHeight() * 0.85), 200, 40);

    add(nextButton);

    // Add action listeners

    nextButton.addActionListener(e -> {
      if (frame.getOrder().getOrderItems().isEmpty())
        return;
      frame.goToItemsSelectedPage();
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
