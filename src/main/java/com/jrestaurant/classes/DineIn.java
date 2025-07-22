package com.jrestaurant.classes;

public class DineIn extends Order {
     private double serviceTax;

     public double getServiceTax(){
          return serviceTax;
     }
     public void setServiceTax(double serviceTax) {
          this.serviceTax = serviceTax;
     }
}
