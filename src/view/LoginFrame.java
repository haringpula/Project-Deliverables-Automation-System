/*
 * LoginFrame.java created on Wed Jun 29 2022 by King Red Sanchez
 * Copyright (c) 2022 
 */
package view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame implements ActionListener {
    // SEE: Initialize content here
    JFrame loginFrame;
    CardLayout loginLayout;
    JPanel loginPanel;
    JLabel lblTitle ;
    JLabel lblUsername;
    JTextField fldUsername;
    JLabel lblPassword;
    JPasswordField fldPassword;
    JButton btnLogin ;
    JButton btnClear;

    public LoginFrame() {
        initializeLogin();
        
    }

    /**
     * 
     */
    public void initializeLogin() {

        {   // Initialize contents
            loginFrame = new JFrame("PDAS");
            loginLayout = new CardLayout();
            loginPanel = new JPanel();
            lblTitle = new JLabel("Project Deliverables Automation System");
            lblUsername = new JLabel("Username: ");
            fldUsername = new JTextField("",10);
            lblPassword = new JLabel("Password: ");
            fldPassword = new JPasswordField(10);
            btnLogin = new JButton("Login");
            btnClear = new JButton("Clear");
        }
        
        {   // Initialize functionalities and layouts
            lblUsername.setLabelFor(fldUsername);
            lblPassword.setLabelFor(fldPassword);
            btnLogin.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evtLogin) {
                    actLogin(evtLogin);
                }
            });
            btnClear.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evtClear) {
                    actClear(evtClear);
                }
            });
        }

        {   // Setting up to the frame and panel
            loginFrame.setLayout(loginLayout);
            loginPanel.add(lblTitle);
            loginPanel.add(lblUsername);
            loginPanel.add(fldUsername);
            loginPanel.add(lblPassword);
            loginPanel.add(fldPassword);
            loginPanel.add(btnLogin);
            loginPanel.add(btnClear);

            loginFrame.add(loginPanel);  
            loginFrame.setSize(250, 250);  
            loginFrame.setLocationRelativeTo(null);  
            loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            loginFrame.setVisible(true);
        } 
    }
    
    /** 
     * @param evtLogin
     */
    protected void actLogin(ActionEvent evtLogin) {

        // TODO: Login
    }

    /** 
     * @param evtClear
     */
    private void actClear(ActionEvent evtClear) {
        fldUsername.setText("");
        fldPassword.setText("");
    }

    
    /** 
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: Auto-generated method stub
        
    }

    
}