package com.jrestaurant.gui;

import java.awt.*;
import javax.swing.*;

import com.jrestaurant.classes.Employee;
import com.jrestaurant.classes.FoodItem;
import com.jrestaurant.classes.Order;
import com.jrestaurant.classes.OrderHasFoodItems;
import com.jrestaurant.classes.Reservation;
import com.jrestaurant.config.DatabaseConfig;
import com.jrestaurant.gui.cashier.*;
import com.jrestaurant.gui.login.LoginPanel;
import com.jrestaurant.gui.manager.MainManagerPanel;
import com.jrestaurant.gui.manager.SecondManagerPanel;

public class MainFrame extends JFrame {
     private JPanel currentPanel;
     private static int width = (int) (1920 * 0.7);
     private static int height = (int) (1080 * 0.7);
     private Employee emp;
     private Order order;
     private String orderType;

     public MainFrame() {
          ImageIcon img = new ImageIcon(MainFrame.class.getResource("../assets/Jresaurant-2.jpg"));
          setIconImage(img.getImage());

          DatabaseConfig dbconfig = new DatabaseConfig();
          Employee.setODBManager(dbconfig);
          Reservation.setODBManager(dbconfig);
          Order.setODBManager(dbconfig);
          FoodItem.setODBManager(dbconfig);
          OrderHasFoodItems.setODBManager(dbconfig);
          // Delivery.setODBManager(dbconfig);

          setTitle("JRestaurant");
          getContentPane().setBackground(new Color(21, 21, 21));
          setSize(width, height);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          setResizable(false);
          setLocationRelativeTo(null);
          currentPanel = new JPanel(new BorderLayout());
          setLayout(new BorderLayout());
          add(currentPanel, BorderLayout.CENTER);
          setVisible(true);
          setPanel(new LoginPanel(this));
          this.emp = null;
          this.order = new Order();
          this.orderType = "";
     }

     public void setPanel(JPanel panel) {
          currentPanel.removeAll();
          currentPanel.add(panel, BorderLayout.CENTER);
          SwingUtilities.updateComponentTreeUI(currentPanel);
     }

     public void setEmp(Employee emp) {
          this.emp = emp;
     }

     public void setOrderType(String orderType) {
          this.orderType = orderType;
     }

     public String getOrderType() {
          return orderType;
     }

     public Employee getEmp() {
          return this.emp;
     }

     public Order getOrder() {
          return this.order;
     }

     public void cancelOrder() {
          this.order.cancelOrder();
          goToCashierPanel();
     }

     public static int getFrameWidth() {
          return width;
     }

     public static int getFrameHeight() {
          return (height - 38);
     }

     public static int getWidthRatio(int ratio) {
          return (int) (MainFrame.width * ratio / 100);
     }

     public static int getHeightRatio(int ratio) {
          return (int) ((MainFrame.height - 38) * ratio / 100);
     }

     public void goToManagerMainPanel() {
          setPanel(new MainManagerPanel(this));
     }

     public void goToCashierPanel() {
          setPanel(new Home(this));
     }

     public void goToSecondManagerPanel() {
          setPanel(new SecondManagerPanel(this));
     }

     public void goToMakeOrderPanel() {
          setPanel(new MakeOrderPage(this));
     }

     public void goToMakeReservationPanel() {
          setPanel(new MakeReservationPage(this));
     }

     public void goToSelectTypeOrderPage() {
          setPanel(new SelectTypeOrderPage(this));
     }

     public void goToItemsSelectedPage() {
          setPanel(new ItemsSelectedPage(this));
     }

     public void logOut() {
          setPanel(new LoginPanel(this));
     }

}
