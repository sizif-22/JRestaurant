package com.jrestaurant.classes;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.*;
import jakarta.persistence.TypedQuery;

@Entity
@Table(name = "delivery")
@PrimaryKeyJoinColumn(name = "order_id")
public class Delivery extends Order {

     @Column(name = "delivery_man_id")
     private int deliveryManId;

     @Column(name = "customer_name")
     private String customerName;

     @Column(name = "address")
     private String address;

     @Column(name = "phone")
     private String phone;

     @Column(name = "status")
     private String status;

     @Column(name = "delivery_fee")
     private double deliveryFee;

     // Default constructor
     public Delivery() {
          super();
          this.status = "Pending";
          this.deliveryFee = 5.0; // Default delivery fee
     }

     // Constructor with parameters
     public Delivery(String customerName, String address, String phone) {
          super();
          this.customerName = customerName;
          this.phone = phone;
          this.address = address;
          this.status = "Pending";
          this.deliveryFee = 5.0; // Default delivery fee
     }

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

     public String getPhone() {
          return phone;
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

     public void setPhone(String phone) {
          this.phone = phone;
     }

     public void setDeliveryFee(double deliveryFee) {
          this.deliveryFee = deliveryFee;
     }

     public static List<Delivery> getAllOrders() {
          EntityManager em = null;
          try {
               em = odbManager.getEntityManager();
               em.getTransaction().begin();

               TypedQuery<Delivery> query = em.createQuery("SELECT d FROM Delivery d", Delivery.class);
               List<Delivery> deliveryOrders = query.getResultList();

               em.getTransaction().commit();
               return deliveryOrders;
          } catch (Exception e) {
               if (em != null && em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
               }
               System.err.println("Error getting delivery orders: " + e.getMessage());
               e.printStackTrace();
               return new ArrayList<>();
          } finally {
               if (em != null && em.isOpen()) {
                    em.close();
               }
          }
     }
}
