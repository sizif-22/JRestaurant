package com.jrestaurant.gui.manager;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.*;

import com.jrestaurant.classes.*;
import com.jrestaurant.gui.MainFrame;

public class DeliveryOrderRows extends JPanel {
     public DeliveryOrderRows(Delivery delivery, int index, MainFrame frame) {
          setLayout(null);
          setBounds(0, 40 * index, MainFrame.getWidthRatio(70), 40);
          setBorder(BorderFactory.createLineBorder(Color.white));
          setBackground(new Color(25, 25, 25));

          JLabel nameHeader = new JLabel(delivery.getCustomerName());
          nameHeader.setFont(new Font("Arial", Font.BOLD, 22));
          nameHeader.setForeground(Color.WHITE);
          nameHeader.setBounds(10, 0, (int) MainFrame.getWidthRatio(70) / 5, 40);
          add(nameHeader);

          JLabel phoneNumberHeader = new JLabel(delivery.getPhone());
          phoneNumberHeader.setFont(new Font("Arial", Font.BOLD, 22));
          phoneNumberHeader.setForeground(Color.WHITE);
          phoneNumberHeader.setBounds((int) (MainFrame.getWidthRatio(70) * 1 / 5) + 10, 0,
                    (int) MainFrame.getWidthRatio(70) / 5,
                    40);
          add(phoneNumberHeader);

          JLabel jobTitleHeader = new JLabel(delivery.getAddress());
          jobTitleHeader.setFont(new Font("Arial", Font.BOLD, 22));
          jobTitleHeader.setForeground(Color.WHITE);
          jobTitleHeader.setBounds((int) (MainFrame.getWidthRatio(70) * 2 / 5) + 10, 0,
                    (int) MainFrame.getWidthRatio(70) / 5, 40);
          add(jobTitleHeader);

          JLabel salaryHeader = new JLabel(
                    String.format("%.2f", delivery.getTotal() * 1.05 + delivery.getDeliveryFee()));
          salaryHeader.setFont(new Font("Arial", Font.BOLD, 22));
          salaryHeader.setForeground(Color.WHITE);
          salaryHeader.setBounds((int) (MainFrame.getWidthRatio(70) * 3 / 5) + 10, 0,
                    (int) MainFrame.getWidthRatio(70) / 5, 40);
          add(salaryHeader);

          // Details Button
          JButton detailsButton = new JButton("details");
          detailsButton.setFont(new Font("Arial", Font.BOLD, 16));
          detailsButton.setBackground(new Color(70, 130, 180));
          detailsButton.setForeground(Color.WHITE);
          detailsButton.setBounds((int) (MainFrame.getWidthRatio(70) * 4 / 5) - 10, 5, 100, 30);
          detailsButton.addActionListener(e -> showDetailsDialog(delivery, frame));
          add(detailsButton);

          // Cancel Button
          JButton cancelButton = new JButton("cancel");
          cancelButton.setFont(new Font("Arial", Font.BOLD, 16));
          cancelButton.setBackground(new Color(25, 25, 25));
          cancelButton.setForeground(Color.red);
          cancelButton.setBorder(BorderFactory.createDashedBorder(Color.red));
          cancelButton.setBounds((int) (MainFrame.getWidthRatio(70) * 4 / 5) + 100, 5, 80, 30);
          cancelButton.addActionListener(e -> showCancelDialog(delivery, frame));
          add(cancelButton);
     }

     private void showDetailsDialog(Delivery delivery, MainFrame frame) {
          JDialog detailsDialog = new JDialog(frame, "Order Details", true);
          detailsDialog.setLayout(new BorderLayout());
          detailsDialog.setSize(400, 300);
          detailsDialog.setLocationRelativeTo(frame);

          JPanel contentPanel = new JPanel(new GridLayout(9, 2, 10, 10));
          contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

          contentPanel.add(new JLabel("Client Name:"));
          contentPanel.add(new JLabel(delivery.getCustomerName()));

          contentPanel.add(new JLabel("Items:"));
          StringBuilder itemsText = new StringBuilder();
          for (var orderItem : delivery.getOrderItems()) {
               itemsText.append(orderItem.getFoodItem().getName()).append(" x").append(orderItem.getCount())
                         .append(", ");
          }
          if (itemsText.length() > 0) {
               itemsText.setLength(itemsText.length() - 2);
          }
          contentPanel.add(new JLabel(itemsText.toString()));

          contentPanel.add(new JLabel("Delivery Man:"));
          contentPanel.add(new JLabel(Employee.getEmployeeById(delivery.getDeliveryManId()).getName()));

          contentPanel.add(new JLabel("Total:"));
          contentPanel.add(
                    new JLabel("$" + String.format("%.2f", delivery.getTotal() * 1.05 + delivery.getDeliveryFee())));

          contentPanel.add(new JLabel("Ordered at:"));
          contentPanel.add(new JLabel(delivery.getOrderTime().toString()));

          contentPanel.add(new JLabel("Will be delivered at:"));
          LocalDateTime orderTime = delivery.getOrderTime().toLocalDateTime();
          LocalDateTime deliveryTime = orderTime.plusMinutes(40);
          contentPanel.add(new JLabel(deliveryTime.format(DateTimeFormatter.ofPattern("HH:mm"))));

          contentPanel.add(new JLabel("Is Delivered:"));

          LocalDateTime currentTime = LocalDateTime.now();
          boolean isDelivered = currentTime.isAfter(deliveryTime);

          if (isDelivered && !delivery.getStatus().equals("Delivered")) {
               delivery.setStatus("Delivered");
          }

          contentPanel.add(new JLabel(isDelivered ? "true" : "false"));
          contentPanel.add(new JLabel("Status: "));
          contentPanel.add(new JLabel(delivery.getStatus()));

          JButton okButton = new JButton("OK");
          okButton.addActionListener(e -> detailsDialog.dispose());

          detailsDialog.add(contentPanel, BorderLayout.CENTER);
          detailsDialog.add(okButton, BorderLayout.SOUTH);

          detailsDialog.setVisible(true);
     }

     private void showCancelDialog(Delivery delivery, MainFrame frame) {
          int result = JOptionPane.showConfirmDialog(
                    frame,
                    "Are you sure you want to cancel this order?",
                    "Cancel Order",
                    JOptionPane.YES_NO_OPTION);

          if (result == JOptionPane.YES_OPTION) {

               delivery.setStatus("Cancelled");

               JOptionPane.showMessageDialog(frame, "Order cancelled successfully!", "Success",
                         JOptionPane.INFORMATION_MESSAGE);

               frame.goToSecondManagerPanel();
          }
     }
}
