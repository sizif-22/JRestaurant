package com.jrestaurant.classes;

import java.sql.Date;
import java.util.Map;

public class Order {
     private int id;
     private int cashierId;
     private Map<FoodItem, Integer> orderItems;
     private Date orderTime;
     private double total;

}
