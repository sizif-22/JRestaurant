package com.jrestaurant.classes;

public class Delivery extends Order {
     private int deliveryManId;
     private String customerName;
     private String address;
     private String status;
     private double deliveryFee;

     // Getters
     public int getDeliveryManId() {
          return deliveryManId;
     }
     public String getCustomerName() {
          return customerName;
     }
     public String getAddress() {
          return address;
     }
     public String getStatus() {
          return status;
     }
     public double getDeliveryFee() {
          return deliveryFee;
     }

     // Setters
     public void setDeliveryManId(int deliveryManId) {
          this.deliveryManId = deliveryManId;
     }
     public void setCustomerName(String customerName) {
          this.customerName = customerName;
     }
     public void setAddress(String address) {
          this.address = address;
     }
     public void setStatus(String status) {
          this.status = status;
     }
     public void setDeliveryFee(double deliveryFee) {
          this.deliveryFee = deliveryFee;
     }
}
