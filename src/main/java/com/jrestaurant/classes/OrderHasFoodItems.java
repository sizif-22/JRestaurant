package com.jrestaurant.classes;

import com.jrestaurant.config.DatabaseConfig;

import jakarta.persistence.*;

@Entity
@Table(name = "Order_has_food_item")
public class OrderHasFoodItems {

     @Id
     private OrderHasFoodItemsId id = new OrderHasFoodItemsId();

     @ManyToOne
     @MapsId("orderId")
     @JoinColumn(name = "order_id")
     private Order order;

     @ManyToOne
     @MapsId("foodItemId")
     @JoinColumn(name = "food_item_id")
     private FoodItem foodItem;

     @Column(name = "times")
     private int count;

     private static DatabaseConfig odbManager;

     OrderHasFoodItems() {
     }

     public OrderHasFoodItems(Order order, FoodItem foodItem, int count) {
          this();
          this.order = order;
          this.foodItem = foodItem;
          this.count = count;
     }

     public OrderHasFoodItems(Order order, FoodItem foodItem) {
          this();
          this.order = order;
          this.foodItem = foodItem;
          this.count = 1;
     }

     public static void setODBManager(DatabaseConfig manager) {
          odbManager = manager;
     }

     public void updateCount() {
          count++;
     }
}
