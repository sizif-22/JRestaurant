package com.jrestaurant.classes;



public class Employee {
    public enum Role {
     CASHIER, MANAGER, DELIVERY, CHEF
};
     private int id;
     private String name;
     private String phone;
     private double salary;
     private Role role;
     private String username;
     private String password;

     // Getters
     public int getId() {
          return id;
     }
     public String getName() {
          return name;
     }
     public String getPhone() {
          return phone;
     }
     public Role getRole() {
          return role;
     }
     public double getSalary() {
          return salary;
     }
     public String getUsername() {
          return username;
     }
     public String getPassword() {
          return password;
     }
     
     // Setters
     public void setName(String name) {
          this.name = name;
     }
     public void setPhone(String phone) {
          this.phone = phone;
     }
     public void setRole(Role role) {
          this.role = role;
     }
     public void setSalary(double salary) {
          this.salary = salary;
     }
     public boolean deleteAccount() {
          return false;
     }
     public void setUsername(String username) {
          this.username = username;
     }
     public void setPassword(String password) {
          this.password = password;
     }
     
     
     public static Employee login(String enteredUsername, String enteredPassword) {
          return null;
     }

     public boolean register(Employee emp) {
          return false;
     }

}
