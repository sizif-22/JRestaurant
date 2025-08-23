package com.jrestaurant.gui.cashier;

import java.awt.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.regex.Pattern;

import javax.swing.*;

import com.jrestaurant.classes.Order;
import com.jrestaurant.classes.Reservation;
import com.jrestaurant.gui.MainFrame;
import com.jrestaurant.classes.Delivery;
import com.jrestaurant.classes.Employee;

public class SelectTypeOrderPage extends JPanel {

        public SelectTypeOrderPage(MainFrame frame) {

                setBounds(0, 0, MainFrame.getFrameWidth(), MainFrame.getFrameHeight());
                setBackground(new Color(21, 21, 21));
                setLayout(null);

                JLabel Name = new JLabel("Select one: This order is...");
                Name.setForeground(Color.BLACK);
                Name.setFont(new Font("Arial", Font.BOLD, 20));

                Name.setBounds((int) (getWidth() * 0.21), (int) (getHeight() * 0.05), (int) (getWidth() * 0.30),
                                50);
                Name.setForeground(Color.WHITE);
                add(Name);

                JButton DineButton = new JButton("Dine in");
                DineButton.setFont(new Font("Arial", Font.BOLD, 20));
                if (frame.getOrderType() == "Dine in") {
                        DineButton.setBackground(new Color(70, 130, 180));
                } else {

                        DineButton.setBackground(Color.GRAY);
                }
                DineButton.setForeground(Color.white);
                DineButton.setBounds((int) (getWidth() * 0.21), (int) (getHeight() * 0.2),
                                (int) (getWidth() * 0.20) - 10, 50);
                DineButton.addActionListener(e -> {
                        frame.setOrderType("Dine in");
                        frame.goToSelectTypeOrderPage();
                });
                add(DineButton);

                JButton TakeawayButton = new JButton("Takeaway");
                TakeawayButton.setFont(new Font("Arial", Font.BOLD, 20));
                if (frame.getOrderType() == "Takeaway") {
                        TakeawayButton.setBackground(new Color(70, 130, 180));
                } else {

                        TakeawayButton.setBackground(Color.GRAY);
                }
                TakeawayButton.setForeground(Color.white);
                TakeawayButton.setBounds((int) (getWidth() * 0.41), (int) (getHeight() * 0.2),
                                (int) (getWidth() * 0.20) - 10,
                                50);
                TakeawayButton.addActionListener(e -> {
                        frame.setOrderType("Takeaway");
                        frame.goToSelectTypeOrderPage();
                });
                add(TakeawayButton);

                JButton DeliveryButton = new JButton("Delivery");
                DeliveryButton.setFont(new Font("Arial", Font.BOLD, 20));
                if (frame.getOrderType() == "Delivery") {
                        DeliveryButton.setBackground(new Color(70, 130, 180));
                } else {

                        DeliveryButton.setBackground(Color.GRAY);
                }
                DeliveryButton.setForeground(Color.white);
                DeliveryButton.setBounds((int) (getWidth() * 0.61), (int) (getHeight() * 0.2),
                                (int) (getWidth() * 0.20) - 10,
                                50);
                DeliveryButton.addActionListener(e -> {
                        frame.setOrderType("Delivery");
                        frame.goToSelectTypeOrderPage();
                });
                add(DeliveryButton);
                JLabel selected = new JLabel(
                                "ToTal (with tax): " + String.format("%.2f", frame.getOrder().getTotal() * 1.05));
                selected.setFont(new Font("Arial", Font.ITALIC, 20));
                selected.setForeground(Color.WHITE);
                selected.setBounds((int) (getWidth() * 0.21), (int) (getHeight() * 0.26), (int) (getWidth() * 0.4),
                                (int) (getHeight() * 0.2));
                add(selected);

                JButton cancelButton = new JButton("Cancel Order");
                cancelButton.setFont(new Font("Arial", Font.BOLD, 18));
                cancelButton.setBackground(Color.WHITE);
                cancelButton.setForeground(Color.BLACK);
                cancelButton.setBounds((int) (getWidth() * 0.1), (int) (getHeight() * 0.92),
                                (int) (getWidth() * 0.20) - 45, 40);
                cancelButton.addActionListener(e -> frame.cancelOrder());
                add(cancelButton);

                // JButton payWVisaButton = new JButton("Pay W/ Visa");
                // payWVisaButton.setFont(new Font("Arial", Font.BOLD, 18));
                // payWVisaButton.setBackground(Color.WHITE);
                // payWVisaButton.setForeground(Color.BLACK);
                // payWVisaButton.setBounds(MainFrame.getWidthRatio(90) - 420, (int)
                // (getHeight() * 0.92), 200, 40);
                // add(payWVisaButton);

                JButton payCashButton = new JButton("Pay");
                payCashButton.setFont(new Font("Arial", Font.BOLD, 18));
                // payCashButton.setBackground(Color.WHITE);
                if (frame.getOrder().getOrderItems().isEmpty() || (frame.getOrderType() != "Dine in"
                                && frame.getOrderType() != "Takeaway" && frame.getOrderType() != "Delivery")) {
                        payCashButton.setBackground(Color.GRAY);
                } else {
                        payCashButton.setBackground(new Color(70, 130, 180));
                }
                payCashButton.setForeground(Color.BLACK);
                payCashButton.setBounds(MainFrame.getWidthRatio(90) - 200, (int) (getHeight() * 0.92), 200, 40);
                payCashButton.addActionListener(e -> {
                        if (frame.getOrderType() == "Takeaway") {
                                frame.getOrder().setOrderTime(Timestamp.valueOf(LocalDateTime.now()));
                                Order.makeOrder(frame.getOrder());
                                JOptionPane.showMessageDialog(frame, "Done!", "Process Completed Successfully.",
                                                JOptionPane.INFORMATION_MESSAGE);
                                frame.setOrderType("");
                                frame.cancelOrder();
                        } else if (frame.getOrderType() == "Dine in") {
                                int res = JOptionPane.showConfirmDialog(frame, "Do you have a reservation?", "",
                                                JOptionPane.YES_NO_OPTION);
                                if (res == JOptionPane.YES_OPTION) {
                                        JPanel askPanel = new JPanel(new GridLayout(2, 2, 5, 5));
                                        JTextField nameField = new JTextField();
                                        JTextField phoneField = new JTextField();
                                        askPanel.add(new JLabel("Name: "));
                                        askPanel.add(nameField);
                                        askPanel.add(new JLabel("Phone: "));
                                        askPanel.add(phoneField);
                                        JOptionPane.showConfirmDialog(frame, askPanel, "", JOptionPane.OK_OPTION);
                                        String name = nameField.getText();
                                        String phone = phoneField.getText();
                                        boolean res2 = Reservation.searchForSpecificReservation(name, phone);
                                        if (res2) {
                                                Random random = new Random();
                                                int rand = random.nextInt(5) + 1;
                                                JOptionPane.showConfirmDialog(frame, "You are at table no." + rand, "",
                                                                JOptionPane.OK_OPTION);
                                                frame.getOrder().setOrderTime(Timestamp.valueOf(LocalDateTime.now()));
                                                Order.makeOrder(frame.getOrder());
                                                frame.setOrderType("");
                                                frame.cancelOrder();
                                        } else {
                                                JOptionPane.showConfirmDialog(frame, "This reservation is Invalid.", "",
                                                                JOptionPane.OK_OPTION);
                                                return;
                                        }
                                } else if (res == JOptionPane.NO_OPTION) {
                                        boolean res2 = Reservation
                                                        .searchAvailablePlaces(Timestamp.valueOf(LocalDateTime.now()));
                                        if (res2) {
                                                Random random = new Random();
                                                int rand = random.nextInt(5) + 1;
                                                JOptionPane.showConfirmDialog(frame, "You are at table no." + rand, "",
                                                                JOptionPane.OK_OPTION);
                                                frame.getOrder().setOrderTime(Timestamp.valueOf(LocalDateTime.now()));
                                                Order.makeOrder(frame.getOrder());
                                                frame.setOrderType("");
                                                frame.cancelOrder();
                                        } else {
                                                JOptionPane.showConfirmDialog(frame,
                                                                "There is no available tables right now.", "",
                                                                JOptionPane.OK_OPTION);
                                                return;
                                        }
                                }
                        } else if (frame.getOrderType() == "Delivery") {
                                JPanel askPanel = new JPanel(new GridLayout(3, 2, 5, 5));
                                JTextField nameField = new JTextField();
                                JTextField addressField = new JTextField();
                                JTextField phoneField = new JTextField();
                                askPanel.add(new JLabel("Name: "));
                                askPanel.add(nameField);
                                askPanel.add(new JLabel("Address: "));
                                askPanel.add(addressField);
                                askPanel.add(new JLabel("Phone: "));
                                askPanel.add(phoneField);

                                while (true) {
                                        int result = JOptionPane.showConfirmDialog(frame, askPanel, "Delivery Details",
                                                        JOptionPane.OK_CANCEL_OPTION);

                                        if (result == JOptionPane.OK_OPTION) {
                                                String name = nameField.getText().trim();
                                                String address = addressField.getText().trim();
                                                String phone = phoneField.getText().trim();
                                                if (!Pattern.matches("^[a-zA-Z ]+$", name)) {
                                                        JOptionPane.showMessageDialog(frame,
                                                                        "Name should only contain alphabetic characters");
                                                        continue;
                                                }
                                                if (phone.length() != 11 || !phone.startsWith("01")
                                                                || !Pattern.matches("^[0-9]+$", phone.substring(2))) {
                                                        JOptionPane.showMessageDialog(frame,
                                                                        "Phone number must be 11 digits, start with '01', and contain only numbers after '01'.");
                                                        continue;
                                                }
                                                if (address.isEmpty()) {
                                                        JOptionPane.showMessageDialog(frame,
                                                                        "Address can't be Empty.");
                                                        continue;
                                                }
                                                Delivery deliveryOrder = new Delivery(name, address, phone);
                                                deliveryOrder.setDeliveryManId(
                                                                Employee.getRandomDeliveryEmployee().getId());

                                                // Copy the order items from the current order
                                                for (var orderItem : frame.getOrder().getOrderItems()) {
                                                        deliveryOrder.addItemToTheList(orderItem.getFoodItem());
                                                }

                                                // Set the total and order time
                                                deliveryOrder.setTotal(frame.getOrder().getTotal());
                                                deliveryOrder.setOrderTime(Timestamp.valueOf(LocalDateTime.now()));

                                                // Save the delivery order
                                                if (Order.makeOrder(deliveryOrder)) {
                                                        JOptionPane.showMessageDialog(frame,
                                                                        "Delivery order created successfully!",
                                                                        "Success", JOptionPane.INFORMATION_MESSAGE);
                                                        frame.setOrderType("");
                                                        frame.cancelOrder();
                                                } else {
                                                        JOptionPane.showMessageDialog(frame,
                                                                        "Failed to create delivery order!",
                                                                        "Error", JOptionPane.ERROR_MESSAGE);

                                                }
                                                break;
                                        }
                                }
                                return;
                        }

                });
                add(payCashButton);
        }
}
