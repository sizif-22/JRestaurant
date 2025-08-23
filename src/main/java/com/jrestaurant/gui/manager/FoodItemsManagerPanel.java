package com.jrestaurant.gui.manager;

import java.awt.*;

import javax.swing.*;

import com.jrestaurant.classes.*;
import com.jrestaurant.gui.MainFrame;

import java.util.List;

public class FoodItemsManagerPanel extends JPanel {

     public FoodItemsManagerPanel(MainFrame frame) {
          frame.getEmp();

          setBounds(0, 0, MainFrame.getFrameWidth(), MainFrame.getFrameHeight());
          setBackground(new Color(21, 21, 21));
          setLayout(null);

          JLabel label = new JLabel("Food Items.");
          label.setFont(new Font("Arial", Font.BOLD, 24));
          label.setForeground(Color.WHITE);
          label.setBounds(MainFrame.getWidthRatio(25), MainFrame.getHeightRatio(7), 200, 50);
          add(label);

          JPanel leftPanel = new JPanel();
          leftPanel.setBounds(0, 0, MainFrame.getWidthRatio(20), MainFrame.getFrameHeight());
          leftPanel.setBackground(new Color(25, 25, 25));
          leftPanel.setLayout(null);
          add(leftPanel);

          JButton empButton = new JButton("Employees");
          empButton.setFont(new Font("Arial", Font.BOLD, 18));
          empButton.setBackground(Color.WHITE);
          empButton.setForeground(Color.BLACK);
          empButton.setBounds(30, MainFrame.getHeightRatio(50) - 110, MainFrame.getWidthRatio(20) - 60, 45);
          leftPanel.add(empButton);

          JButton foodItemsButton = new JButton("Food items");
          foodItemsButton.setFont(new Font("Arial", Font.BOLD, 18));
          foodItemsButton.setBackground(Color.DARK_GRAY);
          foodItemsButton.setForeground(Color.BLACK);
          foodItemsButton.setBounds(30, MainFrame.getHeightRatio(50) - 35, MainFrame.getWidthRatio(20) - 60, 45);
          foodItemsButton.addActionListener(e -> frame.goToFoodItemsManagerPanel());
          leftPanel.add(foodItemsButton);

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
          JPanel table = new JPanel();
          table.setLayout(null);
          table.setBounds(MainFrame.getWidthRatio(25), MainFrame.getHeightRatio(15), MainFrame.getWidthRatio(70),
                    MainFrame.getHeightRatio(60));
          table.setBorder(BorderFactory.createLineBorder(Color.white));
          table.setBackground(new Color(25, 25, 25));
          add(table);

          // Create a container panel for all the food item rows
          JPanel foodItemsContainer = new JPanel();
          foodItemsContainer.setLayout(null);
          foodItemsContainer.setBackground(new Color(25, 25, 25));

          // Calculate the height needed for all food items
          List<FoodItem> foodItems = FoodItem.getAllItems();
          int totalHeight = Math.max(foodItems.size() * 40 + 40, MainFrame.getHeightRatio(60)); // +40 for header,
                                                                                                // minimum height
          foodItemsContainer.setPreferredSize(new Dimension(MainFrame.getWidthRatio(70), totalHeight));

          JLabel nameHeader = new JLabel("Name");
          nameHeader.setFont(new Font("Arial", Font.BOLD, 22));
          nameHeader.setForeground(Color.WHITE);
          nameHeader.setBounds(10, 0, (int) MainFrame.getWidthRatio(70) / 5, 40);
          foodItemsContainer.add(nameHeader);

          JLabel categoryHeader = new JLabel("Category");
          categoryHeader.setFont(new Font("Arial", Font.BOLD, 22));
          categoryHeader.setForeground(Color.WHITE);
          categoryHeader.setBounds((int) (MainFrame.getWidthRatio(70) * 1 / 5) + 60, 0,
                    (int) MainFrame.getWidthRatio(70) / 5, 40);
          foodItemsContainer.add(categoryHeader);

          JLabel priceHeader = new JLabel("Price");
          priceHeader.setFont(new Font("Arial", Font.BOLD, 22));
          priceHeader.setForeground(Color.WHITE);
          priceHeader.setBounds((int) (MainFrame.getWidthRatio(70) * 2 / 5) + 55, 0,
                    (int) MainFrame.getWidthRatio(70) / 5, 40);
          foodItemsContainer.add(priceHeader);

          JLabel idHeader = new JLabel("ID");
          idHeader.setFont(new Font("Arial", Font.BOLD, 22));
          idHeader.setForeground(Color.WHITE);
          idHeader.setBounds((int) (MainFrame.getWidthRatio(70) * 3 / 5) + 55, 0,
                    (int) MainFrame.getWidthRatio(70) / 5, 40);
          foodItemsContainer.add(idHeader);

          JLabel actionHeader = new JLabel("Actions");
          actionHeader.setFont(new Font("Arial", Font.BOLD, 22));
          actionHeader.setForeground(Color.WHITE);
          actionHeader.setBounds((int) (MainFrame.getWidthRatio(70) * 4 / 5) + 55, 0,
                    (int) MainFrame.getWidthRatio(70) / 5, 40);
          foodItemsContainer.add(actionHeader);

          int index = 0;
          for (FoodItem foodItem : foodItems) {
               FoodItemRows fir = new FoodItemRows(foodItem, ++index, frame);
               foodItemsContainer.add(fir);
          }

          // Create scroll pane with the food items container
          JScrollPane scrollPane = new JScrollPane(foodItemsContainer);
          scrollPane.setBounds(0, 0, MainFrame.getWidthRatio(70), MainFrame.getHeightRatio(60));
          scrollPane.setBorder(null);
          scrollPane.setBackground(new Color(25, 25, 25));

          // Customize the scroll pane appearance
          scrollPane.getVerticalScrollBar().setUnitIncrement(16); // Smooth scrolling
          scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
          scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

          // Style the scroll bar to match the dark theme
          scrollPane.getVerticalScrollBar().setBackground(new Color(25, 25, 25));
          scrollPane.getVerticalScrollBar().setForeground(new Color(70, 70, 70));
          scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(12, 0));

          table.add(scrollPane);

          JButton addItemButton = new JButton("Add Item");
          addItemButton.setBackground(Color.WHITE);
          addItemButton.setForeground(Color.BLACK);
          addItemButton.setBounds(MainFrame.getWidthRatio(95) - 100, MainFrame.getHeightRatio(75) + 5, 100, 50);
          add(addItemButton);

          addItemButton.addActionListener(e -> {
               JPanel dataPanel = new JPanel(new GridLayout(4, 2, 5, 5));
               JTextField nameField = new JTextField();
               JTextField categoryField = new JTextField();
               JTextField priceField = new JTextField();

               dataPanel.add(new JLabel("Item Name:"));
               dataPanel.add(nameField);
               dataPanel.add(new JLabel("Category (FOOD/DRINK):"));
               dataPanel.add(categoryField);
               dataPanel.add(new JLabel("Price:"));
               dataPanel.add(priceField);

               int result = JOptionPane.showConfirmDialog(frame, dataPanel,
                         "Add New Food Item", JOptionPane.OK_CANCEL_OPTION);
               if (result == JOptionPane.OK_OPTION) {
                    String name = nameField.getText().trim();
                    String categoryStr = categoryField.getText().trim().toUpperCase();
                    String priceStr = priceField.getText().trim();

                    // Validation
                    if (name.isEmpty()) {
                         JOptionPane.showMessageDialog(frame, "Item name cannot be empty", "Error",
                                   JOptionPane.ERROR_MESSAGE);
                         return;
                    }

                    if (!categoryStr.equals("FOOD") && !categoryStr.equals("DRINK")) {
                         JOptionPane.showMessageDialog(frame, "Category must be either 'FOOD' or 'DRINK'", "Error",
                                   JOptionPane.ERROR_MESSAGE);
                         return;
                    }

                    try {
                         double price = Double.parseDouble(priceStr);
                         if (price <= 0 || price > 1000) {
                              JOptionPane.showMessageDialog(frame, "Price must be between 0 and 1000", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                              return;
                         }

                         // Create and save the new food item
                         FoodItem newItem = new FoodItem(name, price,Category.valueOf(categoryStr));
                         if (FoodItem.addFoodItem(newItem)) {
                              JOptionPane.showMessageDialog(frame, "Food item added successfully!", "Success",
                                        JOptionPane.INFORMATION_MESSAGE);
                              frame.goToFoodItemsManagerPanel(); // Refresh the panel
                         } else {
                              JOptionPane.showMessageDialog(frame, "Failed to add food item", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                         }

                    } catch (NumberFormatException ex) {
                         JOptionPane.showMessageDialog(frame, "Please enter a valid price number", "Error",
                                   JOptionPane.ERROR_MESSAGE);
                    }
               }
          });

          logoutButton.addActionListener(e -> {
               frame.logOut();
          });
     }
}