package com.jrestaurant.classes;

import java.sql.Timestamp;

import com.jrestaurant.config.DatabaseConfig;

import jakarta.persistence.*;

@Entity
@Table(name = "Reservation")
public class Reservation {
     @Id
     @GeneratedValue
     private int id;
     @Column(name = "customer_name")
     private String customerName;
     @Column(name = "phone")
     private String phone;
     @Column(name = "date")
     private Timestamp date;

     private static DatabaseConfig odbManager;

     Reservation() {
     }

     public Reservation(String customerName, String phone, Timestamp parsedDate) {
          this();
          this.customerName = customerName;
          this.phone = phone;
          this.date = parsedDate;
     }

     public static void setODBManager(DatabaseConfig manager) {
          odbManager = manager;
     }

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

     public Timestamp getDate() {
          return date;
     }

     // Setters
     public void setCustomerName(String customerName) {
          this.customerName = customerName;
     }

     public void setPhone(String phone) {
          this.phone = phone;
     }

     public void setDate(Timestamp date) {
          this.date = date;
     }

     public static boolean makeReservation(Reservation reservation) {
          try {
               System.out.println(reservation.customerName);
               System.out.println(reservation.phone);
               System.out.println(reservation.date);
               EntityManager em = odbManager.getEntityManager();
               em.getTransaction().begin();
               em.merge(reservation);
               em.getTransaction().commit();
               em.close();
               return true;
          } catch (Exception e) {
               System.out.println(e.getMessage());
               return false;
          }
     }

}
