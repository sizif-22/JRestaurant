package com.jrestaurant.gui.cashier;

import java.awt.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

import javax.swing.*;

import com.jrestaurant.classes.Reservation;
import com.jrestaurant.gui.MainFrame;

public class MakeReservationPage extends JPanel {
        public MakeReservationPage(MainFrame frame) {

                setBounds(0, 0, MainFrame.getFrameWidth(), MainFrame.getFrameHeight());
                setBackground(new Color(21, 21, 21));
                setLayout(null);

                JLabel Name = new JLabel("Make Reservation");
                Name.setForeground(Color.WHITE);
                Name.setFont(new Font("Georgia", Font.BOLD, 36));
                Name.setBounds((int) (getWidth() * 0.25), (int) (getHeight() * 0.05), (int) (getWidth() * 0.3),
                                (int) (getHeight() * 0.2));
                add(Name);

                JPanel Form = new JPanel();
                Form.setBounds(MainFrame.getWidthRatio(25), (int) (getHeight() * 0.3), MainFrame.getWidthRatio(70),
                                (int) (getHeight() * 0.3));
                Form.setLayout(null);
                // Form.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 5));
                Form.setBackground(new Color(25, 25, 25));

                // name Row
                JLabel nameLabel = new JLabel("Name:");
                nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
                nameLabel.setForeground(Color.WHITE);
                JTextField nameField = new JTextField();
                nameLabel.setBounds((int) (Form.getWidth() * 0.03), (int) (Form.getHeight() * 0.15),
                                (int) (Form.getWidth() * 0.2), (int) (Form.getHeight() * 0.12));
                nameField.setBounds((int) (Form.getWidth() * 0.25), (int) (Form.getHeight() * 0.15),
                                (int) (Form.getWidth() * 0.7) - 20, (int) (Form.getHeight() * 0.12));
                Form.add(nameLabel);
                Form.add(nameField);

                JLabel phoneNumberLabel = new JLabel("Phone Number:");
                phoneNumberLabel.setFont(new Font("Arial", Font.BOLD, 20));
                JTextField PhoneField = new JTextField();
                phoneNumberLabel.setBounds((int) (Form.getWidth() * 0.03), (int) (Form.getHeight() * 0.38),
                                (int) (Form.getWidth() * 0.2), (int) (Form.getHeight() * 0.12));
                phoneNumberLabel.setForeground(Color.WHITE);
                PhoneField.setBounds((int) (Form.getWidth() * 0.25), (int) (Form.getHeight() * 0.38),
                                (int) (Form.getWidth() * 0.7) - 20, (int) (Form.getHeight() * 0.12));
                Form.add(phoneNumberLabel);
                Form.add(PhoneField);

                JLabel DateLabel = new JLabel("Date & Time (YYYY-MM-DD HH:MM):");
                DateLabel.setForeground(Color.WHITE);
                DateLabel.setFont(new Font("Arial", Font.BOLD, 18));
                JFormattedTextField DateField = new JFormattedTextField(
                                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm"));
                DateField.setToolTipText("Enter date and time as YYYY-MM-DD HH:MM");
                DateLabel.setBounds((int) (Form.getWidth() * 0.03), (int) (Form.getHeight() * 0.61),
                                (int) (Form.getWidth() * 0.35), (int) (Form.getHeight() * 0.12));
                DateField.setBounds((int) (Form.getWidth() * 0.39), (int) (Form.getHeight() * 0.61),
                                (int) (Form.getWidth() * 0.56) - 20, (int) (Form.getHeight() * 0.12));
                Form.add(DateLabel);
                Form.add(DateField);
                add(Form);

                JButton cancelAReservationButton = new JButton("Cancel A Reservation");
                cancelAReservationButton.setFont(new Font("Arial", Font.BOLD, 18));
                cancelAReservationButton.setBackground(Color.GRAY);
                cancelAReservationButton.setForeground(Color.white);
                cancelAReservationButton.setBounds(MainFrame.getWidthRatio(25), (int) (getHeight() * 0.85),
                                (int) (getWidth() * 0.20), 40);
                cancelAReservationButton.addActionListener(e -> {
                        // Create dialog for cancellation details
                        JDialog cancelDialog = new JDialog(frame, "Cancel Reservation", true);
                        cancelDialog.setLayout(new BorderLayout());
                        cancelDialog.setSize(450, 250); // Increased dialog size
                        cancelDialog.setLocationRelativeTo(frame);

                        // Create input panel
                        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 15, 15)); // Increased spacing
                        inputPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25)); // Increased padding

                        JTextField nameField2 = new JTextField(25); // Increased width
                        nameField2.setPreferredSize(new Dimension(250, 35)); // Set custom size

                        JTextField phoneField = new JTextField(25); // Increased width
                        phoneField.setPreferredSize(new Dimension(250, 35)); // Set custom size

                        JTextField dateField = new JTextField(25); // Increased width
                        dateField.setPreferredSize(new Dimension(250, 35)); // Set custom size

                        inputPanel.add(new JLabel("Name:"));
                        inputPanel.add(nameField2);
                        inputPanel.add(new JLabel("Phone Number:"));
                        inputPanel.add(phoneField);
                        inputPanel.add(new JLabel("Date (YYYY-MM-DD):"));
                        inputPanel.add(dateField);

                        // Add placeholder text for date format
                        dateField.setText("2024-01-01");

                        // Create button panel
                        JPanel buttonPanel = new JPanel(new FlowLayout());
                        JButton cancelButton = new JButton("Cancel");
                        JButton confirmButton = new JButton("Confirm Cancellation");

                        // Cancel button closes dialog
                        cancelButton.addActionListener(ev -> cancelDialog.dispose());

                        // Confirm button processes the cancellation
                        confirmButton.addActionListener(ev -> {
                                String name = nameField2.getText().trim();
                                String phone = phoneField.getText().trim();
                                String dateStr = dateField.getText().trim();

                                if (name.isEmpty() || phone.isEmpty() || dateStr.isEmpty()) {
                                        JOptionPane.showMessageDialog(cancelDialog,
                                                        "Please fill in all fields.",
                                                        "Missing Information",
                                                        JOptionPane.WARNING_MESSAGE);
                                        return;
                                }

                                try {
                                        // Parse the date
                                        java.time.LocalDate date = java.time.LocalDate.parse(dateStr);
                                        java.sql.Timestamp dateTime = java.sql.Timestamp.valueOf(date.atStartOfDay());

                                        // Attempt to cancel the reservation
                                        boolean cancelled = Reservation.cancelReservation(name, phone, dateTime);

                                        if (cancelled) {
                                                JOptionPane.showMessageDialog(cancelDialog,
                                                                "Reservation cancelled successfully!",
                                                                "Success",
                                                                JOptionPane.INFORMATION_MESSAGE);
                                                cancelDialog.dispose();
                                        } else {
                                                JOptionPane.showMessageDialog(cancelDialog,
                                                                "No reservation found for the specified details.",
                                                                "Not Found",
                                                                JOptionPane.INFORMATION_MESSAGE);
                                        }

                                } catch (java.time.format.DateTimeParseException ex) {
                                        JOptionPane.showMessageDialog(frame,
                                                        "Please enter a valid date in YYYY-MM-DD format.",
                                                        "Invalid Date Format",
                                                        JOptionPane.ERROR_MESSAGE);
                                } catch (Exception ex) {
                                        JOptionPane.showMessageDialog(frame,
                                                        "Error cancelling reservation: " + ex.getMessage(),
                                                        "Error",
                                                        JOptionPane.ERROR_MESSAGE);
                                        JOptionPane.showMessageDialog(cancelDialog,
                                                        "Please enter a valid date in YYYY-MM-DD format.",
                                                        "Invalid Date Format",
                                                        JOptionPane.ERROR_MESSAGE);
                                }
                        });

                        buttonPanel.add(cancelButton);
                        buttonPanel.add(confirmButton);

                        // Add components to dialog
                        cancelDialog.add(inputPanel, BorderLayout.CENTER);
                        cancelDialog.add(buttonPanel, BorderLayout.SOUTH);

                        cancelDialog.setVisible(true);
                });
                add(cancelAReservationButton);

                JButton cancelButton = new JButton("Cancel");
                cancelButton.setFont(new Font("Arial", Font.BOLD, 18));
                cancelButton.setBackground(Color.GRAY);
                cancelButton.setForeground(Color.white);
                cancelButton.setBounds(MainFrame.getWidthRatio(95) - 420, (int) (getHeight() * 0.85), 200, 40);
                cancelButton.addActionListener(e -> frame.goToCashierPanel());
                add(cancelButton);

                JButton createButton = new JButton("Create");
                createButton.setFont(new Font("Arial", Font.BOLD, 18));
                createButton.setBackground(Color.GRAY);
                createButton.setForeground(Color.white);
                createButton.setBounds(MainFrame.getWidthRatio(95) - 200, (int) (getHeight() * 0.85), 200, 40);
                add(createButton);

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
                makeOrderButton.addActionListener(e -> frame.goToMakeOrderPanel());
                leftPanel.add(makeOrderButton);

                JButton reservationButton = new JButton("Reservation");
                reservationButton.setFont(new Font("Arial", Font.BOLD, 18));
                reservationButton.setBackground(Color.darkGray);
                reservationButton.setForeground(Color.BLACK);
                reservationButton.setBounds(30, MainFrame.getHeightRatio(50) - 35, MainFrame.getWidthRatio(20) - 60,
                                45);
                reservationButton.addActionListener(e -> frame.goToMakeReservationPanel());
                leftPanel.add(reservationButton);

                JButton orderButton = new JButton("Orders");
                orderButton.setFont(new Font("Arial", Font.BOLD, 18));
                orderButton.setBackground(Color.white);
                orderButton.setForeground(Color.BLACK);
                orderButton.setBounds(30, MainFrame.getHeightRatio(50) + 40, MainFrame.getWidthRatio(20) - 60, 45);
                orderButton.addActionListener(e -> frame.goToSecondManagerPanel());
                leftPanel.add(orderButton);

                JButton logoutButton = new JButton("Log out");
                logoutButton.setFont(new Font("Arial", Font.BOLD, 18));
                logoutButton.setBackground(Color.white);
                logoutButton.setForeground(Color.BLACK);
                logoutButton.setBounds(30, MainFrame.getFrameHeight() - 55, MainFrame.getWidthRatio(20) - 60, 45);
                logoutButton.addActionListener(e -> frame.logOut());
                leftPanel.add(logoutButton);

                createButton.addActionListener(e -> {
                        String name = nameField.getText().trim();
                        String phone = PhoneField.getText().trim();
                        String date = DateField.getText().trim();

                        if (!name.isEmpty() && !phone.isEmpty() && !date.isEmpty()) {

                                if (!Pattern.matches("^[a-zA-Z ]+$", name)) {
                                        JOptionPane.showMessageDialog(frame,
                                                        "Name should only contain alphabetic characters");
                                        System.out.println("doesn't match");
                                        return;
                                }

                                if (phone.length() != 11 || !phone.startsWith("01")
                                                || !Pattern.matches("^[0-9]+$", phone.substring(2))) {
                                        JOptionPane.showMessageDialog(frame,
                                                        "Phone number must be 11 digits, start with '01', and contain only numbers after '01'.");
                                        System.out.println("Phone number format is invalid.");
                                        return;
                                }
                                LocalDateTime dateTime;
                                try {
                                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                                        dateTime = LocalDateTime.parse(date, formatter);
                                        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
                                                        "yyyy-MM-dd HH:mm");
                                        sdf.setLenient(false);
                                        LocalDateTime now = LocalDateTime.now();
                                        if (dateTime.isBefore(now)) {
                                                JOptionPane.showMessageDialog(
                                                                this,
                                                                "The reservation date must be in the future.",
                                                                "Invalid Date",
                                                                JOptionPane.ERROR_MESSAGE);
                                                return;
                                        }
                                        frame.goToMakeReservationPanel();
                                } catch (Exception ex) {
                                        System.out.println(ex.getMessage());
                                        JOptionPane.showMessageDialog(
                                                        this,
                                                        "Please enter a valid date in the format yyyy-MM-dd HH:MM",
                                                        "Invalid Date Format",
                                                        JOptionPane.ERROR_MESSAGE);
                                        return;
                                }
                                Reservation.makeReservation(
                                                new Reservation(name, phone, Timestamp.valueOf(dateTime)));
                                JOptionPane.showMessageDialog(
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

// 2028-02-29 01:20