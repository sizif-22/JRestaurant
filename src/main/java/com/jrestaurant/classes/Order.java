package com.jrestaurant.classes;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;
import com.jrestaurant.config.DatabaseConfig;
import jakarta.persistence.*;

@Entity
@Table(name = "orders")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING)
public class Order {
     @Id
     @GeneratedValue
     private int id;

     @Column(name = "order_time")
     private Timestamp orderTime;

     @Column(name = "total")
     private double total;

     @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
     private Set<OrderHasFoodItems> orderItems;

     protected static DatabaseConfig odbManager;

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
          OrderHasFoodItems orderItem = new OrderHasFoodItems(this, foodItem);
          orderItems.add(orderItem);
     }

     public void removeFromList(FoodItem foodItem) {
          for (Iterator<OrderHasFoodItems> iterator = orderItems.iterator(); iterator.hasNext();) {
               OrderHasFoodItems orderItem = iterator.next();
               if (orderItem.getOrder().equals(this) && orderItem.getFoodItem().equals(foodItem)) {
                    iterator.remove();
                    orderItem.setOrder(null);
                    orderItem.setFoodItem(null);
               }
          }
     }

     public boolean contains(FoodItem foodItem) {
          for (OrderHasFoodItems orderItem : orderItems) {
               if (orderItem.getFoodItem().getId() == foodItem.getId()) {
                    return true;
               }
          }
          return false;
     }

     public void cancelOrder() {
          orderItems.clear();
     }

     public static boolean makeOrder(Order order) {
          EntityManager em = null;
          try {
               em = odbManager.getEntityManager();
               em.getTransaction().begin();

               // First persist the order to get an ID
               em.persist(order);

               // Then persist each OrderHasFoodItems
               for (OrderHasFoodItems orderItem : order.getOrderItems()) {
                    // Find the FoodItem by ID instead of merging to get a managed entity
                    int foodItemId = orderItem.getFoodItem().getId();
                    FoodItem managedFoodItem = em.find(FoodItem.class, foodItemId);

                    if (managedFoodItem == null) {
                         throw new RuntimeException("FoodItem with ID " + foodItemId + " not found in database");
                    }

                    // Create a new OrderHasFoodItems with managed entities and proper composite key
                    OrderHasFoodItems newOrderItem = new OrderHasFoodItems(order, managedFoodItem,
                              orderItem.getCount());

                    // Set the composite key values after the order has been persisted
                    newOrderItem.getId().setOrderId(order.getId());
                    newOrderItem.getId().setFoodItemId(managedFoodItem.getId());

                    em.persist(newOrderItem);
               }

               em.getTransaction().commit();
               return true;
          } catch (Exception ex) {
               if (em != null && em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
               }
               System.out.println("Error making order: " + ex.getMessage());
               ex.printStackTrace();
               return false;
          } finally {
               if (em != null && em.isOpen()) {
                    em.close();
               }
          }
     }

}
