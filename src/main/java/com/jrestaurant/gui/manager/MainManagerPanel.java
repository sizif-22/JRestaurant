package com.jrestaurant.gui.manager;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.*;

import com.jrestaurant.classes.*;
import com.jrestaurant.gui.MainFrame;

public class MainManagerPanel extends JPanel {

     public MainManagerPanel(MainFrame frame) {
          frame.getEmp();

          setBounds(0, 0, MainFrame.getFrameWidth(), MainFrame.getFrameHeight());
          setBackground(new Color(21, 21, 21));
          setLayout(null);

          JLabel label = new JLabel("Employees.");
          label.setFont(new Font("Arial", Font.BOLD, 24));
          label.setForeground(Color.WHITE);
          label.setBounds(MainFrame.getWidthRatio(25), MainFrame.getHeightRatio(7), 200, 50);
          add(label);

          JPanel leftPanel = new JPanel();
          leftPanel.setBounds(0, 0, MainFrame.getWidthRatio(20), MainFrame.getFrameHeight());
          leftPanel.setBackground(new Color(25, 25, 25));
          leftPanel.setLayout(null);
          add(leftPanel);

          JButton empButton = new JButton("Employees");
          empButton.setFont(new Font("Arial", Font.BOLD, 18));
          empButton.setBackground(Color.DARK_GRAY);
          empButton.setForeground(Color.BLACK);
          empButton.setBounds(30, MainFrame.getHeightRatio(50) - 55, MainFrame.getWidthRatio(20) - 60, 45);
          leftPanel.add(empButton);

          JButton orderButton = new JButton("Orders");
          orderButton.setFont(new Font("Arial", Font.BOLD, 18));
          orderButton.setBackground(Color.white);
          orderButton.setForeground(Color.BLACK);
          orderButton.setBounds(30, MainFrame.getHeightRatio(50) + 40, MainFrame.getWidthRatio(20) - 60, 45);
          leftPanel.add(orderButton);

          JButton logoutButton = new JButton("Log out");
          logoutButton.setFont(new Font("Arial", Font.BOLD, 18));
          logoutButton.setBackground(Color.white);
          logoutButton.setForeground(Color.BLACK);
          logoutButton.setBounds(30, MainFrame.getFrameHeight() - 55, MainFrame.getWidthRatio(20) - 60, 45);
          leftPanel.add(logoutButton);

          JPanel table = new JPanel();
          table.setLayout(null);
          table.setBounds(MainFrame.getWidthRatio(25), MainFrame.getHeightRatio(15), MainFrame.getWidthRatio(70),
                    MainFrame.getHeightRatio(60));
          table.setBorder(BorderFactory.createLineBorder(Color.white));
          table.setBackground(new Color(25, 25, 25));
          add(table);

          JLabel nameHeader = new JLabel("Name");
          nameHeader.setFont(new Font("Arial", Font.BOLD, 22));
          nameHeader.setForeground(Color.WHITE);
          nameHeader.setBounds(10, 0, (int) MainFrame.getWidthRatio(70) / 5, 40);
          table.add(nameHeader);

          JLabel phoneNumberHeader = new JLabel("PhoneNumber");
          phoneNumberHeader.setFont(new Font("Arial", Font.BOLD, 22));
          phoneNumberHeader.setForeground(Color.WHITE);
          phoneNumberHeader.setBounds((int) (MainFrame.getWidthRatio(70) * 1 / 5) + 10, 0,
                    (int) MainFrame.getWidthRatio(70) / 5,
                    40);
          table.add(phoneNumberHeader);

          JLabel jobTitleHeader = new JLabel("Job title");
          jobTitleHeader.setFont(new Font("Arial", Font.BOLD, 22));
          jobTitleHeader.setForeground(Color.WHITE);
          jobTitleHeader.setBounds((int) (MainFrame.getWidthRatio(70) * 2 / 5) + 10, 0,
                    (int) MainFrame.getWidthRatio(70) / 5, 40);
          table.add(jobTitleHeader);

          JLabel salaryHeader = new JLabel("Salary");
          salaryHeader.setFont(new Font("Arial", Font.BOLD, 22));
          salaryHeader.setForeground(Color.WHITE);
          salaryHeader.setBounds((int) (MainFrame.getWidthRatio(70) * 3 / 5) + 10, 0,
                    (int) MainFrame.getWidthRatio(70) / 5, 40);
          table.add(salaryHeader);

          JLabel actionHeader = new JLabel("Actions");
          actionHeader.setFont(new Font("Arial", Font.BOLD, 22));
          actionHeader.setForeground(Color.WHITE);
          actionHeader.setBounds((int) (MainFrame.getWidthRatio(70) * 4 / 5) + 10, 0,
                    (int) MainFrame.getWidthRatio(70) / 5, 40);
          table.add(actionHeader);

          List<Employee> employees = Employee.getEmployees();
          int index = 0;
          for (Employee emp : employees) {
               EmployeeRows emr = new EmployeeRows(emp, ++index, frame);
               table.add(emr);
          }

          JButton hireButton = new JButton("Hire");
          hireButton.setBackground(Color.WHITE);
          hireButton.setForeground(Color.BLACK);
          hireButton.setBounds(MainFrame.getWidthRatio(95) - 100, MainFrame.getHeightRatio(75) + 5, 100, 50);
          add(hireButton);

          hireButton.addActionListener(e -> {

               JTextField roleField = new JTextField();

               JPanel myPanel = new JPanel(new GridLayout(5, 2, 5, 5));

               myPanel.add(new JLabel("Employee Role:"));
               myPanel.add(roleField);
               outer: while (true) {
                    int result = JOptionPane.showConfirmDialog(frame, myPanel,
                              "Hire a new Employee", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                         String role = roleField.getText().toUpperCase().trim();
                         System.out.println("Role: " + role);
                         Vector<String> arr = new Vector<>();
                         for (Role r : Role.values()) {
                              System.out.println("r: " + r.toString());
                              arr.add(r.toString());
                         }

                         System.out.println("res: " + !arr.contains(role));
                         System.out.println("res2: " + role == Role.MANAGER.toString());
                         if (!arr.contains(role) || role == Role.MANAGER.toString()) {
                              JOptionPane.showMessageDialog(frame,
                                        "the current job titles available are: " + Role.CASHIER + ", " + Role.CHEF
                                                  + ", "
                                                  + Role.DELIVERY + ".",
                                        "Error. Invalid Role.", JOptionPane.ERROR_MESSAGE);
                              continue;
                              // return;
                         }

                         JPanel dataPanel = new JPanel(new GridLayout(5, 2, 5, 5));
                         JTextField nameField = new JTextField();
                         JTextField phoneNumberField = new JTextField();
                         JTextField salaryField = new JTextField();
                         JTextField usernameField = new JTextField();
                         JTextField passwordField = new JTextField();

                         dataPanel.add(new JLabel("Employee Name:"));
                         dataPanel.add(nameField);
                         dataPanel.add(new JLabel("Phone Number:"));
                         dataPanel.add(phoneNumberField);
                         dataPanel.add(new JLabel("Salary:"));
                         dataPanel.add(salaryField);
                         System.out.println("A7A");
                         System.out.println("role = cashier? " + role.equals(Role.CASHIER.toString()));
                         if (role.equals(Role.CASHIER.toString())) {
                              dataPanel.add(new JLabel("UserName:"));
                              dataPanel.add(usernameField);
                              dataPanel.add(new JLabel("Password:"));
                              dataPanel.add(passwordField);
                         }
                         while (true) {
                              int result2 = JOptionPane.showConfirmDialog(frame, dataPanel,
                                        "Hire a new Employee", JOptionPane.OK_CANCEL_OPTION);
                              if (result2 == JOptionPane.OK_OPTION) {

                                   String name = nameField.getText();
                                   String phone = phoneNumberField.getText();
                                   String salary = salaryField.getText();
                                   if (salary.isEmpty())
                                        salary = "0";
                                   String username = usernameField.getText();
                                   String password = passwordField.getText();
                                   System.out.println("name: " + name);
                                   if (!Pattern.matches("^[a-zA-Z ]+$", name)) {
                                        JOptionPane.showMessageDialog(frame,
                                                  "Name should only contain alphabetic characters");
                                        System.out.println("doesn't match");
                                        continue;
                                   }
                                   if (phone.length() != 11 || !phone.startsWith("01")
                                             || !Pattern.matches("^[0-9]+$", phone.substring(2))) {
                                        JOptionPane.showMessageDialog(frame,
                                                  "Phone number must be 11 digits, start with '01', and contain only numbers after '01'.");
                                        System.out.println("Phone number format is invalid.");
                                        continue;
                                   }
                                   if (Double.parseDouble(salary) < 100 || Double.parseDouble(salary) > 10000) {
                                        JOptionPane.showMessageDialog(frame,
                                                  "The range for our salary is between 100 ~ 10,000");
                                        System.out.println("Salary is out of range.");
                                        continue;
                                   }
                                   if (role.equals(Role.CASHIER.toString())) {
                                        if (username.length() > 3 || !Pattern.matches("^\\S$", username)) {
                                             JOptionPane.showMessageDialog(frame,
                                                       "username must be 3 characters at least and it can't contain any spaces.");
                                             System.out.println("username invalid.");
                                             continue;
                                        }
                                        if (password.length() < 6 || !Pattern.matches("^\\S$", password)) {
                                             JOptionPane.showMessageDialog(frame, "This password is too weak");
                                             System.out.println("Password is Too weak.");
                                             continue;
                                        }
                                   }
                                   Employee.hireEmployee(
                                             new Employee(name, phone, Role.valueOf(role), Double.parseDouble(salary),
                                                       username, password));
                                   JOptionPane.showMessageDialog(frame, "Employee added successfully");
                              }
                              frame.goToManagerMainPanel();
                              break outer;
                         }
                    }
                    if (result == JOptionPane.CANCEL_OPTION) {
                         break;
                    }
               }
          });

          logoutButton.addActionListener(e -> {
               frame.logOut();
          });

          orderButton.addActionListener(e -> {
               frame.goToSecondManagerPanel();
          });
     }
}
