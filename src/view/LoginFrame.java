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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.Login;

public class LoginFrame extends JFrame implements ActionListener {
    // Initialize content here
    private JFrame loginFrame;
    private CardLayout loginLayout;
    private JPanel loginPanel;
    private JLabel lblTitle;
    private JLabel lblUsername;
    private JTextField fldUsername;
    private JLabel lblPassword;
    private JPasswordField fldPassword;
    private JLabel lblLevel;
    private JComboBox<Integer> cbxLevel;
    private JButton btnLogin;
    private JButton btnClear;
    private JLabel lblRegister;

    /**
     * 
     */
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
            lblLevel = new JLabel("Level");
            cbxLevel = new JComboBox<Integer>();
            btnLogin = new JButton("Login");
            btnClear = new JButton("Clear");
            lblRegister = new JLabel("Register");
        }

        { // Initialize functionalities and layouts
            lblUsername.setLabelFor(fldUsername);
            lblPassword.setLabelFor(fldPassword);
            lblLevel.setLabelFor(cbxLevel);
            cbxLevel.addItem(1);
            cbxLevel.addItem(2);
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
            lblRegister.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            lblRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            lblRegister.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // the user clicks on the label
                    loginFrame.dispose();
                    new RegisterFrame();
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    // the mouse has entered the label

                    lblRegister.setForeground(Color.DARK_GRAY);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    // the mouse has exited the label
                    lblRegister.setForeground(Color.WHITE);
                }
            });
        }

        { // Setting up to the frame and panel
            loginFrame.setLayout(loginLayout);
            loginPanel.add(lblTitle);
            loginPanel.add(lblUsername);
            loginPanel.add(fldUsername);
            loginPanel.add(lblPassword);
            loginPanel.add(fldPassword);
            loginPanel.add(lblLevel);
            loginPanel.add(cbxLevel);
            loginPanel.add(btnLogin);
            loginPanel.add(btnClear);
            loginPanel.add(lblRegister);

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
        /*
         * -1 Plain
         * 0 Error
         * 1 Information
         * 2 Warning
         * 3 Question
         */
        String strUsername = fldUsername.getText();
        char[] chrPassword = fldPassword.getPassword();
        int intLevel = (int) cbxLevel.getSelectedItem();
        if (Login.login(strUsername, chrPassword, intLevel)) {
            chrPassword = Login.passwordRezero(chrPassword);
            JOptionPane.showMessageDialog(null, "Login Successfully", "PDAS", 1);
            loginFrame.dispose();
            if (intLevel == 1) {
                new MainFrame();
            }
            if (intLevel == 2) {
                new SecondaryFrame();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Login Failed", "PDAS", 0);
        }

    }

    /**
     * @param evtClear
     */
    private void actClear(ActionEvent evtClear) {
        fldUsername.setText("");
        fldPassword.setText("");
        cbxLevel.setSelectedIndex(0);
    }

    /**
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Auto-generated method stub

    }

}