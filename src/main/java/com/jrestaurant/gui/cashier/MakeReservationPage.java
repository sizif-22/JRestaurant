package com.jrestaurant.gui.cashier;

import java.awt.*;
import javax.swing.*;

import com.jrestaurant.gui.MainFrame;

public class MakeReservationPage extends JPanel {
    public MakeReservationPage(MainFrame frame) {
        setLayout(null);
        JLabel Name = new JLabel("Make Reservation");
        Name.setForeground(Color.BLACK);
        Name.setFont(new Font("Arial", Font.BOLD, 30));
        Name.setBounds((int) (getWidth() * 0.21), (int) (getHeight() * 0.05), (int) (getWidth() * 0.3),
                (int) (getHeight() * 0.2));
        add(Name);

        JPanel Form = new JPanel();
        Form.setBounds((int) (getWidth() * 0.22), (int) (getHeight() * 0.2), (int) (getWidth() * 0.75),
                (int) (getHeight() * 0.3));
        Form.setLayout(null);
        Form.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 5));

        // Username Row
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        JTextField usernameField = new JTextField();
        usernameLabel.setBounds((int) (Form.getWidth() * 0.03), (int) (Form.getHeight() * 0.15),
                (int) (Form.getWidth() * 0.2), (int) (Form.getHeight() * 0.12));
        usernameField.setBounds((int) (Form.getWidth() * 0.25), (int) (Form.getHeight() * 0.15),
                (int) (Form.getWidth() * 0.7) - 20, (int) (Form.getHeight() * 0.12));
        Form.add(usernameLabel);
        Form.add(usernameField);

        // PhoneNumber Row
        JLabel phoneNumberLabel = new JLabel("PhoneNumber:");
        phoneNumberLabel.setFont(new Font("Arial", Font.BOLD, 20));
        JTextField PhoneField = new JTextField();
        phoneNumberLabel.setBounds((int) (Form.getWidth() * 0.03), (int) (Form.getHeight() * 0.38),
                (int) (Form.getWidth() * 0.2), (int) (Form.getHeight() * 0.12));
        PhoneField.setBounds((int) (Form.getWidth() * 0.25), (int) (Form.getHeight() * 0.38),
                (int) (Form.getWidth() * 0.7) - 20, (int) (Form.getHeight() * 0.12));
        Form.add(phoneNumberLabel);
        Form.add(PhoneField);

        // Date Row
        JLabel DateLabel = new JLabel("Date:");
        DateLabel.setFont(new Font("Arial", Font.BOLD, 20));
        JTextField DateField = new JTextField();
        DateLabel.setBounds((int) (Form.getWidth() * 0.03), (int) (Form.getHeight() * 0.61),
                (int) (Form.getWidth() * 0.2), (int) (Form.getHeight() * 0.12));
        DateField.setBounds((int) (Form.getWidth() * 0.25), (int) (Form.getHeight() * 0.61),
                (int) (Form.getWidth() * 0.7) - 20, (int) (Form.getHeight() * 0.12));
        Form.add(DateLabel);
        Form.add(DateField);
        add(Form);

        JButton CancelButton = new JButton("Cancel");
        CancelButton.setFont(new Font("Arial", Font.BOLD, 18));
        CancelButton.setBackground(Color.GRAY);
        CancelButton.setForeground(Color.white);
        CancelButton.setBounds((int) (getWidth() * 0.6), (int) (getHeight() * 0.52), (int) (getWidth() * 0.20) - 45,
                40);
        add(CancelButton);

        JButton createButton = new JButton("Create");
        createButton.setFont(new Font("Arial", Font.BOLD, 18));
        createButton.setBackground(Color.GRAY);
        createButton.setForeground(Color.white);
        createButton.setBounds((int) (getWidth() * 0.78), (int) (getHeight() * 0.52), (int) (getWidth() * 0.20) - 45,
                40);
        add(createButton);

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

        createButton.addActionListener(e -> {
            String username = usernameField.getText().trim();
            String phone = PhoneField.getText().trim();
            String date = DateField.getText().trim();

            if (!username.isEmpty() && !phone.isEmpty() && !date.isEmpty()) {
                JOptionPane.showConfirmDialog(
                        this,
                        "Done!",
                        "Confirmation",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Please fill in all fields.",
                        "Missing Information",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
    }

}
