package com.jrestaurant.gui.manager;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.Border;

import com.jrestaurant.classes.Employee;
import com.jrestaurant.gui.MainFrame;

public class MainManagerPanel extends JPanel {

     private MainFrame frame;
     private Employee emp;

     public MainManagerPanel(MainFrame frame) {
          this.frame = frame;
          this.emp = frame.getEmp();

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
               EmployeeRows emr = new EmployeeRows(emp, ++index);
               table.add(emr);
          }

          JButton hireButton = new JButton("Hire");
          hireButton.setBackground(Color.WHITE);
          hireButton.setForeground(Color.BLACK);
          hireButton.setBounds(MainFrame.getWidthRatio(95) - 100, MainFrame.getHeightRatio(75) + 5, 100, 50);
          add(hireButton);

          hireButton.addActionListener(e -> {

               JTextField nameField = new JTextField(5);
               JTextField salaryField = new JTextField(5);

               JPanel myPanel = new JPanel();
               myPanel.add(new JLabel("Employee Name:"));
               myPanel.add(nameField);
               myPanel.add(Box.createHorizontalStrut(15)); // a spacer
               myPanel.add(new JLabel("Salary:"));
               myPanel.add(salaryField);

               int result = JOptionPane.showConfirmDialog(frame, myPanel,
                         "Hire a new Employee", JOptionPane.OK_CANCEL_OPTION);
               if (result == JOptionPane.OK_OPTION) {
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
