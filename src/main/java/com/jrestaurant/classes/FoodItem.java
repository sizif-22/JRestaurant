package com.jrestaurant.classes;

enum Category {
     FOOD, DRINK
};

public class FoodItem {
     private int id;
     private String name;
     private double price;
     private Category category;
}
