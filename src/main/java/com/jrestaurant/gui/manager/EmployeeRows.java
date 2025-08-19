package com.jrestaurant.gui.manager;

import java.awt.*;

import javax.swing.*;

import com.jrestaurant.classes.*;
import com.jrestaurant.gui.MainFrame;

public class EmployeeRows extends JPanel {
     private Employee targetEmployee;
     private int index;

     public EmployeeRows(Employee emp, int index) {
          this.targetEmployee = emp;
          this.index = index;
          setLayout(null);
          setBounds(0, 40 * index, MainFrame.getWidthRatio(70), 40);
          setBorder(BorderFactory.createLineBorder(Color.white));
          setBackground(new Color(25,25,25));

          JLabel nameHeader = new JLabel(emp.getName());
          nameHeader.setFont(new Font("Arial", Font.BOLD, 22));
          nameHeader.setForeground(Color.WHITE);
          nameHeader.setBounds(10, 0, (int) MainFrame.getWidthRatio(70) / 5, 40);
          add(nameHeader);

          JLabel phoneNumberHeader = new JLabel(emp.getPhone());
          phoneNumberHeader.setFont(new Font("Arial", Font.BOLD, 22));
          phoneNumberHeader.setForeground(Color.WHITE);
          phoneNumberHeader.setBounds((int) (MainFrame.getWidthRatio(70) * 1 / 5)+10, 0, (int) MainFrame.getWidthRatio(70) / 5,
                    40);
          add(phoneNumberHeader);

          JLabel jobTitleHeader = new JLabel(emp.getRole().toString());
          jobTitleHeader.setFont(new Font("Arial", Font.BOLD, 22));
          jobTitleHeader.setForeground(Color.WHITE);
          jobTitleHeader.setBounds((int) (MainFrame.getWidthRatio(70) * 2 / 5)+10, 0, (int) MainFrame.getWidthRatio(70) / 5, 40);
          add(jobTitleHeader);

          JLabel salaryHeader = new JLabel(Double.toString(emp.getSalary()));
          salaryHeader.setFont(new Font("Arial", Font.BOLD, 22));
          salaryHeader.setForeground(Color.WHITE);
          salaryHeader.setBounds((int) (MainFrame.getWidthRatio(70) * 3 / 5)+10, 0, (int) MainFrame.getWidthRatio(70) / 5,40);
          add(salaryHeader);

          JButton actionHeader = new JButton("Fire");
          actionHeader.setFont(new Font("Arial", Font.BOLD, 22));
          actionHeader.setBackground(new Color(25,25,25));
          actionHeader.setForeground(Color.red);
          actionHeader.setBorder(BorderFactory.createDashedBorder(Color.red));
          actionHeader.setBounds((int) (MainFrame.getWidthRatio(70) * 4 / 5)+10, 5, 100, 30);
          if(emp.getRole() != Role.MANAGER){
               add(actionHeader);
          }
     }

}
