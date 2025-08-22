package com.jrestaurant.gui.manager;

import java.awt.*;

import javax.swing.*;

import com.jrestaurant.classes.*;
import com.jrestaurant.gui.MainFrame;

public class EmployeeRows extends JPanel {
     public EmployeeRows(Employee emp, int index, MainFrame frame) {
          setLayout(null);
          setBounds(0, 40 * index, MainFrame.getWidthRatio(70), 40);
          setBorder(BorderFactory.createLineBorder(Color.white));
          setBackground(new Color(25, 25, 25));

          JLabel nameHeader = new JLabel(emp.getName());
          nameHeader.setFont(new Font("Arial", Font.BOLD, 22));
          nameHeader.setForeground(Color.WHITE);
          nameHeader.setBounds(10, 0, (int) MainFrame.getWidthRatio(70) / 5, 40);
          add(nameHeader);

          JLabel phoneNumberHeader = new JLabel(emp.getPhone());
          phoneNumberHeader.setFont(new Font("Arial", Font.BOLD, 22));
          phoneNumberHeader.setForeground(Color.WHITE);
          phoneNumberHeader.setBounds((int) (MainFrame.getWidthRatio(70) * 1 / 5) + 10, 0,
                    (int) MainFrame.getWidthRatio(70) / 5,
                    40);
          add(phoneNumberHeader);

          JLabel jobTitleHeader = new JLabel(emp.getRole().toString());
          jobTitleHeader.setFont(new Font("Arial", Font.BOLD, 22));
          jobTitleHeader.setForeground(Color.WHITE);
          jobTitleHeader.setBounds((int) (MainFrame.getWidthRatio(70) * 2 / 5) + 10, 0,
                    (int) MainFrame.getWidthRatio(70) / 5, 40);
          add(jobTitleHeader);

          JLabel salaryHeader = new JLabel(Double.toString(emp.getSalary()));
          salaryHeader.setFont(new Font("Arial", Font.BOLD, 22));
          salaryHeader.setForeground(Color.WHITE);
          salaryHeader.setBounds((int) (MainFrame.getWidthRatio(70) * 3 / 5) + 10, 0,
                    (int) MainFrame.getWidthRatio(70) / 5, 40);
          add(salaryHeader);

          JButton fireButton = new JButton("Fire");
          fireButton.setFont(new Font("Arial", Font.BOLD, 22));
          fireButton.setBackground(new Color(25, 25, 25));
          fireButton.setForeground(Color.red);
          fireButton.setBorder(BorderFactory.createDashedBorder(Color.red));
          fireButton.setBounds((int) (MainFrame.getWidthRatio(70) * 4 / 5) + 10, 5, 100, 30);
          if (emp.getRole() != Role.MANAGER) {
               add(fireButton);
          }
          fireButton.addActionListener(e -> {
               int res = JOptionPane.showConfirmDialog(frame, "Are you sure you want to FIRE this employee?",
                         "Fire Employee: " + emp.getName(), JOptionPane.OK_CANCEL_OPTION);
               if (res == JOptionPane.OK_OPTION) {
                    System.out.println("Fire");
                    boolean isFired = Employee.fireEmployee(emp);
                    if(isFired){
                         System.out.println("Done!");
                    }
                    JOptionPane.showMessageDialog(frame, "Employee fired successfully.");
                    frame.goToManagerMainPanel();
               }
          });
     }

}
