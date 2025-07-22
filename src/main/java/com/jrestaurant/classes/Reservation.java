package com.jrestaurant.classes;

import java.sql.Date;

public class Reservation {
     private int id;
     private String customerName;
     private String phone;
     private Date date;

     // Getters
     public int getId() {
          return id;
     }
     public String getCustomerName() {
          return customerName;
     }
     public String getPhone() {
          return phone;
     }
     public Date getDate() {
          return date;
     }

     // Setters
     public void setCustomerName(String customerName) {
          this.customerName = customerName;
     }
     public void setPhone(String phone) {
          this.phone = phone;
     }
     public void setDate(Date date) {
          this.date = date;
     }
}
