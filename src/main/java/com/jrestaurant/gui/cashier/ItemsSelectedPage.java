package com.jrestaurant.gui.cashier;

import java.awt.*;
import javax.swing.*;

import com.jrestaurant.classes.OrderHasFoodItems;
import com.jrestaurant.gui.MainFrame;

public class ItemsSelectedPage extends JPanel {

    public ItemsSelectedPage(MainFrame frame) {

        setBounds(0, 0, MainFrame.getFrameWidth(), MainFrame.getFrameHeight());
        setBackground(new Color(21, 21, 21));
        setLayout(null);

        JLabel pageName = new JLabel("Make Order");
        pageName.setFont(new Font("Georgia", Font.BOLD, 36));
        pageName.setForeground(Color.WHITE);
        pageName.setBounds((int) (getWidth() * 0.1), MainFrame.getHeightRatio(5), (int) (getWidth() * 0.3),
                50);
        add(pageName);

        JLabel itemsLabel = new JLabel("Items Selected:");
        itemsLabel.setFont(new Font("Arial", Font.BOLD, 20));
        itemsLabel.setBounds((int) (getWidth() * 0.1), MainFrame.getHeightRatio(15), (int) (getWidth() * 0.31),
                40);
        add(itemsLabel);

        JPanel selectedItemsPanel = new JPanel(new GridLayout(6, 1, 0, 1));
        selectedItemsPanel.setBounds(MainFrame.getWidthRatio(10), MainFrame.getHeightRatio(20),
                MainFrame.getWidthRatio(80), MainFrame.getHeightRatio(60));
        selectedItemsPanel.setBackground(new Color(25, 25, 25));
        add(selectedItemsPanel);
        double totalPrice = 0;
        for (OrderHasFoodItems item : frame.getOrder().getOrderItems()) {
            JPanel itemPanel = new JPanel(null);
            itemPanel.setBackground(new Color(40, 40, 40));
            JLabel itemName = new JLabel(
                    item.getFoodItem().getName() + " | Price per one: $" + item.getFoodItem().getPrice());
            itemName.setFont(new Font("Arial", Font.BOLD, 20));
            itemName.setBounds(5, 0, 600, 70);
            itemName.setFont(new Font("Arial", Font.BOLD, 24));
            itemName.setForeground(Color.WHITE);
            itemPanel.add(itemName);
            double total = item.getCount() * item.getFoodItem().getPrice();
            totalPrice += total;
            JLabel totalLabel = new JLabel(Double.toString(total));
            totalLabel.setBounds(MainFrame.getWidthRatio(80) - 80, 0, 80, 70);
            totalLabel.setFont(new Font("Arial", Font.BOLD, 24));
            totalLabel.setForeground(Color.WHITE);
            itemPanel.add(totalLabel);
            JButton rightButton = new JButton("+1");
            rightButton.setBounds(MainFrame.getWidthRatio(80) - 150, 10, 60, 50);
            rightButton.setBackground(Color.WHITE);
            rightButton.setForeground(Color.BLACK);
            rightButton.addActionListener(e -> {
                item.increment();
                frame.goToItemsSelectedPage();
            });
            itemPanel.add(rightButton);
            JLabel countLabel = new JLabel(Integer.toString((int) item.getCount()));
            countLabel.setBounds(MainFrame.getWidthRatio(80) - 200, 0, 40, 70);
            countLabel.setFont(new Font("Arial", Font.BOLD, 24));
            countLabel.setForeground(Color.WHITE);
            itemPanel.add(countLabel);
            JButton leftButton = new JButton("-1");
            leftButton.setBounds(MainFrame.getWidthRatio(80) - 270, 10, 60, 50);
            leftButton.setBackground(Color.WHITE);
            leftButton.setForeground(Color.BLACK);
            leftButton.addActionListener(e -> {
                if (item.getCount() < 2) {
                    item.getOrder().removeFromList(item.getFoodItem());
                } else {
                    item.decrement();
                }
                frame.goToItemsSelectedPage();
            });
            itemPanel.add(leftButton);
            selectedItemsPanel.add(itemPanel);
        }
        frame.getOrder().setTotal(totalPrice);
        JLabel selected = new JLabel("Total Price: " + String.format("%.2f", totalPrice));
        selected.setFont(new Font("Arial", Font.ITALIC, 20));
        selected.setForeground(Color.WHITE);
        selected.setBounds((int) (getWidth() * 0.1), MainFrame.getHeightRatio(82), (int) (getWidth() * 0.5),
                50);
        add(selected);

        JButton BackButton = new JButton("Back");
        BackButton.setFont(new Font("Arial", Font.BOLD, 18));
        BackButton.setBackground(Color.WHITE);
        BackButton.setForeground(Color.BLACK);
        BackButton.setBounds((int) (getWidth() * 0.1), (int) (getHeight() * 0.92), (int) (getWidth() * 0.20) - 45, 40);
        BackButton.addActionListener(e -> frame.goToMakeOrderPanel());
        add(BackButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Arial", Font.BOLD, 18));
        cancelButton.setBackground(Color.WHITE);
        cancelButton.setForeground(Color.BLACK);
        cancelButton.setBounds(MainFrame.getWidthRatio(90) - 420, (int) (getHeight() * 0.92), 200, 40);
        cancelButton.addActionListener(e -> frame.cancelOrder());
        add(cancelButton);

        JButton nextButton = new JButton("Next");
        nextButton.setFont(new Font("Arial", Font.BOLD, 18));
        if (frame.getOrder().getOrderItems().isEmpty()) {
            nextButton.setBackground(Color.GRAY);
        } else {
            nextButton.setBackground(new Color(70, 130, 180));
        }
        nextButton.setForeground(Color.WHITE);
        nextButton.setBounds(MainFrame.getWidthRatio(90) - 200, (int) (getHeight() * 0.92), 200, 40);
        nextButton.addActionListener(e -> {
            if (frame.getOrder().getOrderItems().isEmpty())
                return;
            frame.goToSelectTypeOrderPage();
        });
        add(nextButton);

        // JPanel LeftPanel = new JPanel();
        // LeftPanel.setBounds(0, 0, (int) (getWidth() * 0.20), getHeight());
        // LeftPanel.setBackground(new Color(25, 25, 25));
        // LeftPanel.setLayout(null);
        // add(LeftPanel);

        // JButton MakeOrderButton = new JButton("Make Order");
        // MakeOrderButton.setFont(new Font("Arial", Font.BOLD, 18));
        // MakeOrderButton.setBackground(Color.DARK_GRAY);
        // MakeOrderButton.setForeground(Color.BLACK);
        // MakeOrderButton.setBounds(20, (int) (getHeight() * 0.30), (int) (getWidth() *
        // 0.20) - 30, 35);
        // LeftPanel.add(MakeOrderButton);

        // JButton reservationButton = new JButton("Reservation");
        // reservationButton.setFont(new Font("Arial", Font.BOLD, 18));
        // reservationButton.setBackground(Color.DARK_GRAY);
        // reservationButton.setForeground(Color.BLACK);
        // reservationButton.setBounds(20, (int) (getHeight() * 0.38), (int) (getWidth()
        // * 0.20) - 30, 35);
        // LeftPanel.add(reservationButton);

        // JButton OrdersButton = new JButton("Orders");
        // OrdersButton.setFont(new Font("Arial", Font.BOLD, 18));
        // OrdersButton.setBackground(Color.DARK_GRAY);
        // OrdersButton.setForeground(Color.BLACK);
        // OrdersButton.setBounds(20, (int) (getHeight() * 0.46), (int) (getWidth() *
        // 0.20) - 30, 35);
        // LeftPanel.add(OrdersButton);
    }
}
