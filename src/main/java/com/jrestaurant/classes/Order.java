package com.jrestaurant.classes;

import java.sql.Date;
import java.util.Map;

public class Order {
     private int id;
     private int cashierId;
     private Map<FoodItem, Integer> orderItems;
     private Date orderTime;
     private double total;

     // Getters
     public int getId() {
          return id;
     }
     public int getCashierId() {
          return cashierId;
     }
     public Map<FoodItem, Integer> getOrderItems() {
          return orderItems;
     }
     public Date getOrderTime() {
          return orderTime;
     }
     public double getTotal() {
          return total;
     }

     // Setters
     public void setCashierId(int cashierId) {
          this.cashierId = cashierId;
     }
     public void setOrderItems(Map<FoodItem, Integer> orderItems) {
          this.orderItems = orderItems;
     }
     public void setOrderTime(Date orderTime) {
          this.orderTime = orderTime;
     }    
     public void setTotal(double total) {
          this.total = total;
     }

}
