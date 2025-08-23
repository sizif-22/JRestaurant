package com.jrestaurant.classes;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import com.jrestaurant.config.DatabaseConfig;

import jakarta.persistence.*;

@Entity
@Table(name = "Reservation")
public class Reservation {
     @Id
     @GeneratedValue
     private int id;
     @Column(name = "customer_name")
     private String customerName;
     @Column(name = "phone")
     private String phone;
     @Column(name = "date")
     private Timestamp date;

     private static DatabaseConfig odbManager;

     Reservation() {
     }

     public Reservation(String customerName, String phone, Timestamp parsedDate) {
          this();
          this.customerName = customerName;
          this.phone = phone;
          this.date = parsedDate;
     }

     public static void setODBManager(DatabaseConfig manager) {
          odbManager = manager;
     }

     // Getters
     public int getId() {
          return id;
     }

     public String getCustomerName() {
          return customerName;
     }

     public String getPhone() {
          return phone;
     }

     public Timestamp getDate() {
          return date;
     }

     // Setters
     public void setCustomerName(String customerName) {
          this.customerName = customerName;
     }

     public void setPhone(String phone) {
          this.phone = phone;
     }

     public void setDate(Timestamp date) {
          this.date = date;
     }

     public static boolean makeReservation(Reservation reservation) {
          try {
               if (!Reservation.searchAvailablePlaces(reservation.date))
                    return false;
               System.out.println(reservation.customerName);
               System.out.println(reservation.phone);
               System.out.println(reservation.date);
               EntityManager em = odbManager.getEntityManager();
               em.getTransaction().begin();
               em.merge(reservation);
               em.getTransaction().commit();
               em.close();
               return true;
          } catch (Exception e) {
               System.out.println(e.getMessage());
               return false;
          }
     }

     public static boolean searchForSpecificReservation(String name, String phone) {
          long millis = 30 * 60 * 1000L;
          Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
          Timestamp start = new Timestamp(timestamp.getTime() - millis);
          Timestamp end = new Timestamp(timestamp.getTime() + millis);
          try {
               EntityManager em = odbManager.getEntityManager();
               em.getTransaction().begin();
               TypedQuery query = em.createQuery(
                         "SELECT r FROM reservation r WHERE r.customerName = :n and r.phone = :p AND r.date BETWEEN :s AND :e",
                         Reservation.class);
               query.setParameter("n", name);
               query.setParameter("p", phone);
               query.setParameter("p", start);
               query.setParameter("p", end);

               List<Reservation> reservations = query.getResultList();
               em.getTransaction().commit();
               em.close();
               if (reservations.size() > 0) {
                    return true;
               } else {
                    return false;
               }

          } catch (Exception ex) {

               return false;
          }
     }

     public static boolean searchAvailablePlaces(Timestamp timestamp) {
          // Assume there are 5 tables in the restaurant
          final int TOTAL_TABLES = 5;
          EntityManager em = null;
          try {
               em = odbManager.getEntityManager();
               em.getTransaction().begin();

               // Calculate the time window: 30 min before and after the given timestamp
               long millis = 30 * 60 * 1000L;
               Timestamp start = new Timestamp(timestamp.getTime() - millis);
               Timestamp end = new Timestamp(timestamp.getTime() + millis);

               // Query for reservations that overlap with the window
               String jpql = "SELECT COUNT(r) FROM Reservation r WHERE r.date BETWEEN :start AND :end";
               Long count = (Long) em.createQuery(jpql)
                         .setParameter("start", start)
                         .setParameter("end", end)
                         .getSingleResult();

               em.getTransaction().commit();
               em.close();

               // If less than 5 reservations, at least one table is available
               return count < TOTAL_TABLES;
          } catch (Exception e) {
               if (em != null && em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
               }
               System.out.println(e.getMessage());
               return false;
          } finally {
               if (em != null && em.isOpen()) {
                    em.close();
               }
          }
     }

     public static boolean dineIn() {
          try {
               if (!Reservation.searchAvailablePlaces(Timestamp.valueOf(LocalDateTime.now())))
                    return false;
               Reservation reservation = new Reservation("Dine in", "", Timestamp.valueOf(LocalDateTime.now()));
               System.out.println(reservation.customerName);
               System.out.println(reservation.phone);
               System.out.println(reservation.date);
               EntityManager em = odbManager.getEntityManager();
               em.getTransaction().begin();
               em.merge(reservation);
               em.getTransaction().commit();
               em.close();
               return true;
          } catch (Exception e) {
               System.out.println(e.getMessage());
               return false;
          }
     }

     public static boolean cancelReservation(String customerName, String phone, Timestamp date) {
          EntityManager em = null;
          try {
               em = odbManager.getEntityManager();
               em.getTransaction().begin();

               // Convert the timestamp to start and end of the day
               java.time.LocalDate localDate = date.toLocalDateTime().toLocalDate();
               java.time.LocalDateTime startOfDay = localDate.atStartOfDay();
               java.time.LocalDateTime endOfDay = localDate.atTime(23, 59, 59, 999999999);

               Timestamp startOfDayTimestamp = Timestamp.valueOf(startOfDay);
               Timestamp endOfDayTimestamp = Timestamp.valueOf(endOfDay);

               // Debug output
               System.out.println("Searching for reservation on date: " + localDate);
               System.out.println("Name: " + customerName);
               System.out.println("Phone: " + phone);
               System.out.println("Time range: " + startOfDayTimestamp + " to " + endOfDayTimestamp);

               // Query for reservations on the specific day
               String jpql = "SELECT r FROM Reservation r WHERE r.customerName = :name AND r.phone = :phone AND r.date BETWEEN :start AND :end";
               TypedQuery<Reservation> query = em.createQuery(jpql, Reservation.class);
               query.setParameter("name", customerName);
               query.setParameter("phone", phone);
               query.setParameter("start", startOfDayTimestamp);
               query.setParameter("end", endOfDayTimestamp);

               List<Reservation> reservations = query.getResultList();
               System.out.println("Found " + reservations.size() + " matching reservations");

               if (reservations.isEmpty()) {
                    em.getTransaction().commit();
                    em.close();
                    return false; // No matching reservations found
               }

               // Remove all matching reservations
               for (Reservation reservation : reservations) {
                    System.out.println("Removing reservation ID: " + reservation.getId());
                    em.remove(reservation);
               }

               em.getTransaction().commit();
               em.close();
               return true; // Successfully cancelled reservations

          } catch (Exception e) {
               if (em != null && em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
               }
               System.err.println("Error cancelling reservation: " + e.getMessage());
               e.printStackTrace();
               return false;
          } finally {
               if (em != null && em.isOpen()) {
                    em.close();
               }
          }
     }

}
