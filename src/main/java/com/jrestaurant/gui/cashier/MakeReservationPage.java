/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.jrestaurant.gui.cashier;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author HP
 */
public class MakeReservationPage extends javax.swing.JFrame {

    /**
     * Creates new form MakeReservationPage
     */
    public MakeReservationPage() {
        setTitle("CashierPage"); 
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setSize(1000,800);
         setLayout(null);
         setLocationRelativeTo(null);
         
         
         
        JLabel Name = new JLabel("Make Reservation");
        Name.setForeground(Color.BLACK);
        Name.setFont(new Font("Arial", Font.BOLD, 30));
         Name.setBounds((int)(getWidth()*0.21),(int)(getHeight()*0.05),(int)(getWidth()*0.3) , (int)(getHeight()*0.2));
         add(Name);
         
        JPanel Form = new JPanel();
        Form.setBounds((int)(getWidth() * 0.22), (int)(getHeight() * 0.2), (int)(getWidth() * 0.75), (int)(getHeight() * 0.3));
        Form.setLayout(null); 
        Form.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 5));

         // Username Row
         JLabel usernameLabel = new JLabel("Username:");
         usernameLabel.setFont(new Font("Arial", Font.BOLD, 20));
         JTextField usernameField = new JTextField();
         usernameLabel.setBounds((int)(Form.getWidth() * 0.03), (int)(Form.getHeight() * 0.15), (int)(Form.getWidth() * 0.2), (int)(Form.getHeight() * 0.12));
         usernameField.setBounds((int)(Form.getWidth() * 0.25), (int)(Form.getHeight() * 0.15), (int)(Form.getWidth() * 0.7)-20, (int)(Form.getHeight() * 0.12));
         Form.add(usernameLabel);
         Form.add(usernameField);
        
         
         // PhoneNumber Row
         JLabel PhoneNumerLabel = new JLabel("PhoneNumber:");
         PhoneNumerLabel.setFont(new Font("Arial", Font.BOLD, 20));
         JTextField PhoneField = new JTextField();
         PhoneNumerLabel.setBounds((int)(Form.getWidth() * 0.03), (int)(Form.getHeight() * 0.38), (int)(Form.getWidth() * 0.2), (int)(Form.getHeight() * 0.12));
         PhoneField.setBounds((int)(Form.getWidth() * 0.25), (int)(Form.getHeight() * 0.38), (int)(Form.getWidth() * 0.7)-20, (int)(Form.getHeight() * 0.12));
         Form.add(PhoneNumerLabel);
         Form.add(PhoneField);
         
         // Date Row
         JLabel DateLabel = new JLabel("Date:");
         DateLabel.setFont(new Font("Arial", Font.BOLD, 20));
         JTextField DateField = new JTextField();
         DateLabel.setBounds((int)(Form.getWidth() * 0.03), (int)(Form.getHeight() * 0.61), (int)(Form.getWidth() * 0.2), (int)(Form.getHeight() * 0.12));
         DateField.setBounds((int)(Form.getWidth() * 0.25), (int)(Form.getHeight() * 0.61), (int)(Form.getWidth() * 0.7)-20, (int)(Form.getHeight() * 0.12));
         Form.add(DateLabel);
         Form.add(DateField);

        add(Form);

        
        JButton CancelButton = new JButton("Cancel");
          CancelButton.setFont(new Font("Arial", Font.BOLD, 18));
          CancelButton.setBackground(Color.GRAY);
          CancelButton.setForeground(Color.white);
          CancelButton.setBounds((int)(getWidth()*0.6),(int)(getHeight()*0.52),(int)(getWidth()*0.20) - 45 , 40);
          add(CancelButton);
          
          
          
        JButton createButton = new JButton("Create");
          createButton.setFont(new Font("Arial", Font.BOLD, 18));
          createButton.setBackground(Color.GRAY);
          createButton.setForeground(Color.white);
          createButton.setBounds((int)(getWidth()*0.78),(int)(getHeight()*0.52),(int)(getWidth()*0.20) - 45 , 40);
          add(createButton);
          
          createButton.addActionListener(e -> {
                    String username = usernameField.getText().trim();
                    String phone = PhoneField.getText().trim();
                    String date = DateField.getText().trim();

            if (!username.isEmpty() && !phone.isEmpty() && !date.isEmpty()) {
               int result = JOptionPane.showConfirmDialog(
               this,
               "Done!",
               "Confirmation",
               JOptionPane.INFORMATION_MESSAGE
            );
                   new MainCashier().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(
              this,
               "Please fill in all fields.",
               "Missing Information",
              JOptionPane.WARNING_MESSAGE
          );
        }
      });

        JPanel LeftPanel = new JPanel();
            LeftPanel.setBounds(0, 0,(int)(getWidth()*0.20), getHeight());
            LeftPanel.setBackground(new Color(25, 25, 25));
            LeftPanel.setLayout(null);
            add(LeftPanel);
            
            
        JButton MakeOrderButton = new JButton("Make Order");
          MakeOrderButton.setFont(new Font("Arial", Font.BOLD, 18));
          MakeOrderButton.setBackground(Color.DARK_GRAY);
          MakeOrderButton.setForeground(Color.BLACK);
          MakeOrderButton.setBounds(20, (int)(getHeight()*0.30), (int)(getWidth()*0.20) - 30, 35);
          LeftPanel.add(MakeOrderButton);
          
          
        JButton reservationButton = new JButton("Reservation");
          reservationButton.setFont(new Font("Arial", Font.BOLD, 18));
          reservationButton.setBackground(Color.DARK_GRAY);
          reservationButton.setForeground(Color.BLACK);
          reservationButton.setBounds(20, (int)(getHeight()*0.38), (int)(getWidth()*0.20) - 30, 35);
          LeftPanel.add(reservationButton);
          
          
          
          JButton OrdersButton = new JButton("Orders");
          OrdersButton.setFont(new Font("Arial", Font.BOLD, 18));
          OrdersButton.setBackground(Color.DARK_GRAY);
          OrdersButton.setForeground(Color.BLACK);
          OrdersButton.setBounds(20, (int)(getHeight()*0.46), (int)(getWidth()*0.20) - 30, 35);
          LeftPanel.add(OrdersButton);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MakeReservationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MakeReservationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MakeReservationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MakeReservationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MakeReservationPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
