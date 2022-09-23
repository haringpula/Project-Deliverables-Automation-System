package view;

import javax.swing.*;
import java.awt.event.*;

public class Frame extends JFrame implements ActionListener {
    JPanel panel;


    public Frame() {
        // FIXME: JPanel has no panel type attribute
        //GroupLayout layout = new GroupLayout(panel);
        panel = new JPanel();
        //panel.setLayout(layout);
        //ImageIcon imageIcon = new ImageIcon("res/icon.png");
        //panel.setIconImage(imageIcon.getImage());  

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //submit.addActionListener(this);
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
