/*
 * LoginFrame.java created on Wed Jun 29 2022 by King Red Sanchez
 * Copyright (c) 2022 
 */

package view;

import javax.swing.*;

import java.awt.event.*;

public class LoginFrame extends JFrame implements ActionListener {
    JPanel panel;
    JLabel user_label, password_label;
    JTextField username_text;
    JPasswordField password_text;
    JButton submit;

    public LoginFrame() {
        user_label = new JLabel();
        user_label.setText("User Name :");
        username_text = new JTextField(10);
        password_label = new JLabel();
        password_label.setText("Password :");
        password_text = new JPasswordField(10);
        submit = new JButton("SUBMIT");

        // FIXME: JPanel has no panel type attribute
        //GroupLayout layout = new GroupLayout(panel);
        panel = new JPanel();
        //panel.setLayout(layout);
        ImageIcon imageIcon = new ImageIcon("res/icon.png");
        //panel.setIconImage(imageIcon.getImage());  
        panel.add(user_label);
        panel.add(username_text);
        panel.add(password_label);
        panel.add(password_text);
        panel.add(submit);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        submit.addActionListener(this);
        add(panel);
        setTitle("Login");
        setSize(250, 250);
        setVisible(true);
    }
    
    /** 
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: Auto-generated method stub

    }

}