package com.jrestaurant.gui.manager;

import java.awt.*;
import javax.swing.*;

import com.jrestaurant.classes.*;
import com.jrestaurant.gui.MainFrame;

public class FoodItemRows extends JPanel {
     public FoodItemRows(FoodItem foodItem, int index, MainFrame frame) {
          setLayout(null);
          setBounds(0, 40 * index, MainFrame.getWidthRatio(70), 40);
          setBorder(BorderFactory.createLineBorder(Color.white));
          setBackground(new Color(25, 25, 25));

          JLabel nameLabel = new JLabel(foodItem.getName());
          nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
          nameLabel.setForeground(Color.WHITE);
          nameLabel.setBounds(10, 0, (int) MainFrame.getWidthRatio(70) / 5 +50, 40);
          add(nameLabel);

          JLabel categoryLabel = new JLabel(foodItem.getCategory().toString());
          categoryLabel.setFont(new Font("Arial", Font.BOLD, 22));
          categoryLabel.setForeground(Color.WHITE);
          categoryLabel.setBounds((int) (MainFrame.getWidthRatio(70) * 1 / 5) + 60, 0,
                    (int) MainFrame.getWidthRatio(70) / 5, 40);
          add(categoryLabel);

          JLabel priceLabel = new JLabel("$" + String.format("%.2f", foodItem.getPrice()));
          priceLabel.setFont(new Font("Arial", Font.BOLD, 22));
          priceLabel.setForeground(Color.WHITE);
          priceLabel.setBounds((int) (MainFrame.getWidthRatio(70) * 2 / 5) + 55, 0,
                    (int) MainFrame.getWidthRatio(70) / 5, 40);
          add(priceLabel);

          JLabel idLabel = new JLabel(String.valueOf(foodItem.getId()));
          idLabel.setFont(new Font("Arial", Font.BOLD, 22));
          idLabel.setForeground(Color.WHITE);
          idLabel.setBounds((int) (MainFrame.getWidthRatio(70) * 3 / 5) + 55, 0,
                    (int) MainFrame.getWidthRatio(70) / 5, 40);
          add(idLabel);

          // Remove Button
          JButton removeButton = new JButton("Remove");
          removeButton.setFont(new Font("Arial", Font.BOLD, 16));
          removeButton.setBackground(new Color(25, 25, 25));
          removeButton.setForeground(Color.red);
          removeButton.setBorder(BorderFactory.createDashedBorder(Color.red));
          removeButton.setBounds((int) (MainFrame.getWidthRatio(70) * 4 / 5) + 55, 5, 80, 30);
          removeButton.addActionListener(e -> showRemoveDialog(foodItem, frame));
          add(removeButton);
     }

     private void showRemoveDialog(FoodItem foodItem, MainFrame frame) {
          int result = JOptionPane.showConfirmDialog(
                    frame,
                    "Are you sure you want to remove '" + foodItem.getName() + "'?",
                    "Remove Food Item",
                    JOptionPane.YES_NO_OPTION);

          if (result == JOptionPane.YES_OPTION) {
               // Remove the food item
               if (FoodItem.removeFoodItem(foodItem)) {
                    JOptionPane.showMessageDialog(frame,
                              "Food item removed successfully!",
                              "Success",
                              JOptionPane.INFORMATION_MESSAGE);
                    frame.goToFoodItemsManagerPanel(); // Refresh the panel
               } else {
                    JOptionPane.showMessageDialog(frame,
                              "Failed to remove food item!",
                              "Error",
                              JOptionPane.ERROR_MESSAGE);
               }
          }
     }
}