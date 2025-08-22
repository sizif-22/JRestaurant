package com.jrestaurant.classes;

import java.util.*;
import com.jrestaurant.config.DatabaseConfig;

import jakarta.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {
     @Id
     @GeneratedValue
     @Column(name = "id")
     private int id;
     @Column(name = "name")
     private String name;
     @Column(name = "phone")
     private String phone;
     @Column(name = "salary")
     private double salary;
     @Column(name = "role")
     private Role role;
     @Column(name = "username")
     private String username;
     @Column(name = "password")
     private String password;

     private static DatabaseConfig odbManager;

     public Employee() {
     }

     public Employee(String name, String phone, Role role, double salary, String username, String password) {
          this();
          this.name = name;
          this.phone = phone;
          this.role = role;
          this.salary = salary;
          this.username = username;
          this.password = password;
     }

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

     public static void setODBManager(DatabaseConfig manager) {
          odbManager = manager;
     }

     public static Employee login(String enteredUsername, String enteredPassword) {
          EntityManager em = odbManager.getEntityManager();
          em.getTransaction().begin();
          TypedQuery<Employee> query = em.createQuery(
                    "select e from Employee e  where e.username = :u and e.password = :p",
                    Employee.class);
          query.setParameter("u", enteredUsername);
          query.setParameter("p", enteredPassword);
          query.setMaxResults(1);
          List<Employee> employees = query.getResultList();
          em.close();
          if (employees.isEmpty()) {
               return null;
          }
          return employees.get(0);
     }

     public static List<Employee> getEmployees() {
          EntityManager em = odbManager.getEntityManager();
          TypedQuery<Employee> query = em.createQuery("Select e from Employee e", Employee.class);
          List<Employee> employees = query.getResultList();
          em.close();
          return employees;
     }

     public boolean register(Employee emp) {
          return false;
     }

     public static boolean fireEmployee(Employee emp) {
          try {
               EntityManager em = odbManager.getEntityManager();
               em.getTransaction().begin();
               Employee merged = em.merge(emp);
               em.remove(merged);
               em.getTransaction().commit();
               em.close();
               return true;
          } catch (Exception e) {
               System.out.println(e.getMessage());
               return false;
          }
     }

     public static boolean hireEmployee(Employee emp) {
          try {
               EntityManager em = odbManager.getEntityManager();
               em.getTransaction().begin();
               em.merge(emp);
               em.getTransaction().commit();
               em.close();
               return true;
          } catch (Exception e) {
               return false;
          }
     }
}
