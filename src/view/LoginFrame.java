/*
 * LoginFrame.java created on Wed Jun 29 2022 by King Red Sanchez
 * Copyright (c) 2022 
 */
package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame implements ActionListener {
    // SEE: Initialize content here
    JFrame loginFrame;
    CardLayout loginLayout;
    JPanel loginPanel;
    JLabel lblTitle;
    JLabel lblUsername;
    JTextField fldUsername;
    JLabel lblPassword;
    JPasswordField fldPassword;
    JButton btnLogin;
    JButton btnClear;
    JLabel lblRegister;

    public LoginFrame() {
        initializeLogin();

    }

    /**
     * 
     */
    public void initializeLogin() {

        { // Initialize component contents
            loginFrame = new JFrame("Login");
            loginLayout = new CardLayout();
            loginPanel = new JPanel();
            lblTitle = new JLabel("Project Deliverables Automation System");
            lblUsername = new JLabel("Username: ");
            fldUsername = new JTextField("", 10);
            lblPassword = new JLabel("Password: ");
            fldPassword = new JPasswordField(10);
            btnLogin = new JButton("Login");
            btnClear = new JButton("Clear");
            lblRegister = new JLabel("Register");
        }

        { // Setting up to the frame and panel
            loginFrame.setLayout(loginLayout);
            loginPanel.add(lblTitle);
            loginPanel.add(lblUsername);
            loginPanel.add(fldUsername);
            loginPanel.add(lblPassword);
            loginPanel.add(fldPassword);
            loginPanel.add(btnLogin);
            loginPanel.add(btnClear);
            loginPanel.add(lblRegister);

            loginFrame.add(loginPanel);
            loginFrame.setSize(250, 250);
            loginFrame.setLocationRelativeTo(null);
            loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            loginFrame.setVisible(true);
        }

        { // Initialize functionalities and layouts
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
            lblRegister.setForeground(Color.BLUE.darker());
            lblRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            lblRegister.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    // the user clicks on the label
                    loginFrame.dispose();;
                    new RegisterFrame();

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    // the mouse has entered the label
                    lblRegister.setText("<html><a href=''>Register</a></html>");
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    // the mouse has exited the label
                    lblRegister.setText("Register");
                }
            });
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