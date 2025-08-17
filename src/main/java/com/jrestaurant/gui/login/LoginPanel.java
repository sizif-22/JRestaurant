package com.jrestaurant.gui.login;

import java.awt.*;

import javax.swing.*;

import com.jrestaurant.classes.Employee;
import com.jrestaurant.classes.Role;
import com.jrestaurant.gui.MainFrame;

public class LoginPanel extends JPanel {
     private MainFrame frame;
     private JTextField userNameField;
     private JPasswordField passwordField;

     public LoginPanel(MainFrame frame) {
          this.frame = frame;
          setBounds(0, 0, frame.getWidth(), frame.getHeight());
          setBackground(new Color(21, 21, 21));
          setLayout(null);

          JLabel adminLabel = new JLabel("Log In Page.");
          adminLabel.setFont(new Font("Arial", Font.BOLD, 24));
          adminLabel.setForeground(Color.WHITE);
          adminLabel.setBounds(frame.getWidthRatio(10), frame.getHeightRatio(10), 200, 50);
          add(adminLabel);

          JLabel userNameLabel = new JLabel("UserName:");
          userNameLabel.setFont(new Font("Arial", Font.BOLD, 18));
          userNameLabel.setForeground(Color.WHITE);
          userNameLabel.setBounds(frame.getWidthRatio(30), frame.getHeightRatio(40), 100, 30);
          add(userNameLabel);

          userNameField = new JTextField();
          userNameField.setBounds(frame.getWidthRatio(40), frame.getHeightRatio(40), 400, 30);
          userNameField.setFont(new Font("Arial", Font.BOLD, 18));
          add(userNameField);

          JLabel passwordLabel = new JLabel("Password:");
          passwordLabel.setFont(new Font("Arial", Font.BOLD, 18));
          passwordLabel.setForeground(Color.WHITE);
          passwordLabel.setBounds(frame.getWidthRatio(30), frame.getHeightRatio(50), 100, 30);
          add(passwordLabel);

          passwordField = new JPasswordField();
          passwordField.setBounds(frame.getWidthRatio(40), frame.getHeightRatio(50), 400, 30);
          passwordField.setFont(new Font("Arial", Font.BOLD, 18));
          add(passwordField);

          JButton loginFormButton = new JButton("Log In");
          loginFormButton.setBackground(new Color(200, 200, 200));
          loginFormButton.setForeground(Color.black);
          loginFormButton.setFont(new Font("Arial", Font.BOLD, 18));
          loginFormButton.setFocusPainted(false);
          loginFormButton.setBounds(frame.getWidthRatio(50) - 100, frame.getHeightRatio(65), 200, 40);
          add(loginFormButton);
          loginFormButton.addActionListener(e -> {
               String userName = userNameField.getText();
               String password = new String(passwordField.getPassword());
               if (userName.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "UserName and Password Fields can not be empty.",
                              "Login Failed", JOptionPane.ERROR_MESSAGE);
                    return;
               }
               Employee emp = Employee.login(userName, password);

               if (emp == null) {
                    JOptionPane.showMessageDialog(this, "Incorrect username or password", "Login Failed",
                              JOptionPane.ERROR_MESSAGE);
                    return;
               }

               if ((emp.getRole()).toString() == (Role.MANAGER).toString()) {
                    frame.goToManagerMainPanel();
                    return;
               } else {
                    JOptionPane.showMessageDialog(this, "Something went wrong please try again later.",
                              "Login Failed",
                              JOptionPane.ERROR_MESSAGE);
                    return;
               }
          });
     }

}
