package com.jrestaurant.classes;

enum Category {
     FOOD, DRINK
};

public class FoodItem {
     private int id;
     private String name;
     private double price;
     private Category category;

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
}
