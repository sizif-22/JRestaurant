package com.jrestaurant.classes;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;
import com.jrestaurant.config.DatabaseConfig;
import jakarta.persistence.*;

@Entity
@Table(name = "Order")
public class Order {
     @Id
     @GeneratedValue
     private int id;

     @Column(name = "order_time")
     private Timestamp orderTime;

     @Column(name = "total")
     private double total;

     @OneToMany(mappedBy = "order")
     private Set<OrderHasFoodItems> orderItems;

     private static DatabaseConfig odbManager;

     public static void setODBManager(DatabaseConfig manager) {
          odbManager = manager;
     }

     public Order() {
          this.orderItems = new HashSet<OrderHasFoodItems>();
          this.orderTime = Timestamp.valueOf(LocalDateTime.now());
          this.total = 0;
     }

     // Getters
     public int getId() {
          return id;
     }

     public Timestamp getOrderTime() {
          return orderTime;
     }

     public double getTotal() {
          return total;
     }

     public void setOrderTime(Timestamp orderTime) {
          this.orderTime = orderTime;
     }

     public void setTotal(double total) {
          this.total = total;
     }

     public Set<OrderHasFoodItems> getOrderItems() {
          return orderItems;
     }

     public void addItemToTheList(FoodItem foodItem) {
          orderItems.add(new OrderHasFoodItems(this, foodItem));
     }

     public void removeFromList(FoodItem foodItem) {
          orderItems.remove(new OrderHasFoodItems(this, foodItem));
     }

     public static boolean makeOrder(Order order) {
          try {
               EntityManager em = odbManager.getEntityManager();
               em.getTransaction().begin();
               em.merge(order);
               em.getTransaction().commit();
               return true;
          } catch (Exception ex) {
               System.out.println(ex.getMessage());
               return false;
          }
     }

}
