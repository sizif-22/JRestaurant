package com.jrestaurant.gui.cashier;

import java.awt.*;
import javax.swing.*;

import com.jrestaurant.gui.MainFrame;

public class SelectTypeOrderPage extends JPanel {

    public SelectTypeOrderPage(MainFrame frame) {
        setLayout(null);

        JLabel Name = new JLabel("Select one : This Order is ....");
        Name.setForeground(Color.BLACK);
        Name.setFont(new Font("Arial", Font.BOLD, 20));
        Name.setBounds((int) (getWidth() * 0.21), (int) (getHeight() * 0.05), (int) (getWidth() * 0.30),
                (int) (getHeight() * 0.2));
        add(Name);

        JButton DineButton = new JButton("Dine in");
        DineButton.setFont(new Font("Arial", Font.BOLD, 20));
        DineButton.setBackground(Color.GRAY);
        DineButton.setForeground(Color.white);
        DineButton.setBounds((int) (getWidth() * 0.21), (int) (getHeight() * 0.2), (int) (getWidth() * 0.20) - 10, 50);
        add(DineButton);

        DineButton.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(
                    this,
                    "Do you have a reservation?",
                    "Confirmation",
                    JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.YES_OPTION) {

                JTextField usernameField = new JTextField(15);
                JTextField phoneField = new JTextField(15);

                JPanel inputPanel = new JPanel();
                inputPanel.setLayout(new java.awt.GridLayout(2, 2, 10, 10));
                inputPanel.add(new JLabel("Username:"));
                inputPanel.add(usernameField);
                inputPanel.add(new JLabel("Phone Number:"));
                inputPanel.add(phoneField);

                JOptionPane.showConfirmDialog(
                        this,
                        inputPanel,
                        "Enter Your Details",
                        JOptionPane.OK_CANCEL_OPTION);

            } else if (result == JOptionPane.NO_OPTION) {
                // Check if there any table

            }

        });

        JButton TakeawayButton = new JButton("Takeaway");
        TakeawayButton.setFont(new Font("Arial", Font.BOLD, 20));
        TakeawayButton.setBackground(Color.GRAY);
        TakeawayButton.setForeground(Color.white);
        TakeawayButton.setBounds((int) (getWidth() * 0.41), (int) (getHeight() * 0.2), (int) (getWidth() * 0.20) - 10,
                50);
        add(TakeawayButton);

        JButton DeliveryButton = new JButton("Delivery");
        DeliveryButton.setFont(new Font("Arial", Font.BOLD, 20));
        DeliveryButton.setBackground(Color.GRAY);
        DeliveryButton.setForeground(Color.white);
        DeliveryButton.setBounds((int) (getWidth() * 0.61), (int) (getHeight() * 0.2), (int) (getWidth() * 0.20) - 10,
                50);
        add(DeliveryButton);

        DeliveryButton.addActionListener(e -> {
            JTextField usernameField = new JTextField(15);
            JTextField addressField = new JTextField(15);
            JTextField phoneField = new JTextField(15);

            JPanel inputPanel = new JPanel(new java.awt.GridLayout(3, 2, 5, 20));
            inputPanel.add(new JLabel("Username:"));
            inputPanel.add(usernameField);
            inputPanel.add(new JLabel("Address:"));
            inputPanel.add(addressField);
            inputPanel.add(new JLabel("Phone Number:"));
            inputPanel.add(phoneField);

            int result = JOptionPane.showConfirmDialog(
                    null,
                    inputPanel,
                    "Enter Delivery Details",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                String username = usernameField.getText().trim();
                String address = addressField.getText().trim();
                String phone = phoneField.getText().trim();

                if (!username.isEmpty() && !address.isEmpty() && !phone.isEmpty()) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Done!",
                            "Confirmation",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Please fill in all fields.",
                            "Missing Information",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        JLabel selected = new JLabel("ToTal (with tax):");
        selected.setFont(new Font("Arial", Font.ITALIC, 20));
        selected.setBounds((int) (getWidth() * 0.21), (int) (getHeight() * 0.26), (int) (getWidth() * 0.4),
                (int) (getHeight() * 0.2));
        add(selected);

        JButton CancelButton = new JButton("Cancel Order");
        CancelButton.setFont(new Font("Arial", Font.BOLD, 18));
        CancelButton.setBackground(Color.GRAY);
        CancelButton.setForeground(Color.DARK_GRAY);
        CancelButton.setBounds((int) (getWidth() * 0.21), (int) (getHeight() * 0.85), (int) (getWidth() * 0.20) - 45,
                40);
        add(CancelButton);

        CancelButton.addActionListener(e -> {
            setVisible(false);
        });

        JButton VisaButton = new JButton("Pay W/Visa");
        VisaButton.setFont(new Font("Arial", Font.BOLD, 18));
        VisaButton.setBackground(Color.GRAY);
        VisaButton.setForeground(Color.white);
        VisaButton.setBounds((int) (getWidth() * 0.6), (int) (getHeight() * 0.85), (int) (getWidth() * 0.20) - 45, 40);
        add(VisaButton);

        JButton CachButton = new JButton("Pay Cach");
        CachButton.setFont(new Font("Arial", Font.BOLD, 18));
        CachButton.setBackground(Color.GRAY);
        CachButton.setForeground(Color.white);
        CachButton.setBounds((int) (getWidth() * 0.78), (int) (getHeight() * 0.85), (int) (getWidth() * 0.20) - 45, 40);
        add(CachButton);

        JPanel LeftPanel = new JPanel();
        LeftPanel.setBounds(0, 0, (int) (getWidth() * 0.20), getHeight());
        LeftPanel.setBackground(new Color(25, 25, 25));
        LeftPanel.setLayout(null);
        add(LeftPanel);

        JButton MakeOrderButton = new JButton("Make Order");
        MakeOrderButton.setFont(new Font("Arial", Font.BOLD, 18));
        MakeOrderButton.setBackground(Color.DARK_GRAY);
        MakeOrderButton.setForeground(Color.BLACK);
        MakeOrderButton.setBounds(20, (int) (getHeight() * 0.30), (int) (getWidth() * 0.20) - 30, 35);
        LeftPanel.add(MakeOrderButton);

        JButton reservationButton = new JButton("Reservation");
        reservationButton.setFont(new Font("Arial", Font.BOLD, 18));
        reservationButton.setBackground(Color.DARK_GRAY);
        reservationButton.setForeground(Color.BLACK);
        reservationButton.setBounds(20, (int) (getHeight() * 0.38), (int) (getWidth() * 0.20) - 30, 35);
        LeftPanel.add(reservationButton);

        JButton OrdersButton = new JButton("Orders");
        OrdersButton.setFont(new Font("Arial", Font.BOLD, 18));
        OrdersButton.setBackground(Color.DARK_GRAY);
        OrdersButton.setForeground(Color.BLACK);
        OrdersButton.setBounds(20, (int) (getHeight() * 0.46), (int) (getWidth() * 0.20) - 30, 35);
        LeftPanel.add(OrdersButton);
    }
}
