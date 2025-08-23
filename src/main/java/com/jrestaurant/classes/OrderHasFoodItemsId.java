package com.jrestaurant.classes;

import java.util.*;

import jakarta.persistence.*;

@Embeddable
public class OrderHasFoodItemsId {

    private int orderId;
    private int foodItemId;

    public OrderHasFoodItemsId() {
    }

    public OrderHasFoodItemsId(int orderId, int foodItemId) {
        this.orderId = orderId;
        this.foodItemId = foodItemId;
    }

    public int getFoodItemId() {
        return foodItemId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setFoodItemId(int foodItemId) {
        this.foodItemId = foodItemId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, foodItemId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        OrderHasFoodItemsId that = (OrderHasFoodItemsId) obj;
        return orderId == that.orderId && foodItemId == that.foodItemId;
    }
}
