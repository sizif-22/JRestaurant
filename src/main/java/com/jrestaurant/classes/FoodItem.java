package com.jrestaurant.classes;

import java.util.*;

import com.jrestaurant.config.DatabaseConfig;

import jakarta.persistence.*;

enum Category {
     FOOD, DRINK
};

@Entity
@Table(name = "food_item")
public class FoodItem {
     @Id
     @GeneratedValue
     private int id;

     @Column(name = "name")
     private String name;

     @Column(name = "price")
     private double price;

     @Column(name = "category")
     @Enumerated(EnumType.STRING)
     private Category category;

     @OneToMany(mappedBy = "foodItem")
     private Set<OrderHasFoodItems> orderItems;

     private static DatabaseConfig odbManager;

     public static void setODBManager(DatabaseConfig manager) {
          odbManager = manager;
     }

     // Getters
     public int getId() {
          return id;
     }

     public String getName() {
          return name;
     }

     public Category getCategory() {
          return category;
     }

     public double getPrice() {
          return price;
     }

     // Setters
     public void setName(String name) {
          this.name = name;
     }

     public void setCategory(Category category) {
          this.category = category;
     }

     public void setPrice(double price) {
          this.price = price;
     }

     @SuppressWarnings({ "unchecked", "rawtypes" })
     public static List<FoodItem> getAllItems() {
          EntityManager em = null;
          try {
               em = odbManager.getEntityManager();
               em.getTransaction().begin();
               TypedQuery query = em.createQuery("SELECT f from FoodItem f", FoodItem.class);
               List<FoodItem> foodItems = query.getResultList();
               em.getTransaction().commit();
               return foodItems;
          } catch (Exception e) {
               if (em != null && em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
               }
               System.err.println("Error getting food items: " + e.getMessage());
               e.printStackTrace();
               return new ArrayList<>();
          } finally {
               if (em != null && em.isOpen()) {
                    em.close();
               }
          }
     }
}
