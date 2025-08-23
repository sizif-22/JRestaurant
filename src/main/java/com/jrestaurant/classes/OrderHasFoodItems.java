package com.jrestaurant.classes;

import com.jrestaurant.config.DatabaseConfig;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_has_food_item")
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

          // Set the composite key values
          if (order != null && foodItem != null) {
               this.id.setOrderId(order.getId());
               this.id.setFoodItemId(foodItem.getId());
          }
     }

     public OrderHasFoodItems(Order order, FoodItem foodItem) {
          this();
          this.order = order;
          this.foodItem = foodItem;
          this.count = 1;

          // Set the composite key values
          if (order != null && foodItem != null) {
               this.id.setOrderId(order.getId());
               this.id.setFoodItemId(foodItem.getId());
          }
     }

     public void increment() {
          count++;
     }

     public void decrement() {
          count--;
     }

     public static void setODBManager(DatabaseConfig manager) {
          odbManager = manager;
     }

     public void updateCount() {
          count++;
     }

     public FoodItem getFoodItem() {
          return foodItem;
     }

     public void setFoodItem(FoodItem foodItem) {
          this.foodItem = foodItem;
     }

     public Order getOrder() {
          return order;
     }

     public void setOrder(Order order) {
          this.order = order;
     }

     public int getCount() {
          return count;
     }

     // Add the missing getId method
     public OrderHasFoodItemsId getId() {
          return id;
     }

     @Override
     public int hashCode() {
          return Objects.hash(id);
     }

     @Override
     public boolean equals(Object obj) {
          if (this == obj)
               return true;
          if (obj == null || getClass() != obj.getClass())
               return false;
          OrderHasFoodItems that = (OrderHasFoodItems) obj;
          return Objects.equals(id, that.id);
     }
}
