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
import controller.Register;

public class RegisterFrame extends JFrame implements ActionListener {
    // Initialize content here
    private JFrame registerFrame;
    private CardLayout registerLayout;
    private JPanel registerPanel;
    private JLabel lblTitle;
    private JLabel lblUsername;
    private JTextField fldUsername;
    private JLabel lblPassword;
    private JPasswordField fldPassword;
    private JLabel lblPassword2;
    private JPasswordField fldPassword2;
    private JLabel lblLevel;
    private JComboBox<Integer> cbxLevel;
    private JButton btnRegister;
    private JButton btnClear;
    private JLabel lblLogin;

    public RegisterFrame() {
        initializeRegister();

    }

    /**
     * 
     */
    public void initializeRegister() {
        { // Initialize component contents
            registerFrame = new JFrame("Register");
            registerLayout = new CardLayout();
            registerPanel = new JPanel();
            lblTitle = new JLabel("Project Deliverables Automation System");
            lblUsername = new JLabel("Username: ");
            fldUsername = new JTextField("", 10);
            lblPassword = new JLabel("Password: ");
            fldPassword = new JPasswordField(10);
            lblPassword2 = new JLabel("Repeat Password: ");
            fldPassword2 = new JPasswordField(10);
            lblLevel = new JLabel("Level");
            cbxLevel = new JComboBox<Integer>();
            btnRegister = new JButton("Register");
            btnClear = new JButton("Clear");
            lblLogin = new JLabel("Login");
        }

        { // Initialize functionalities and layouts
            registerPanel.setBorder(BorderFactory.createEmptyBorder(0, 4, 4, 4));
            lblUsername.setLabelFor(fldUsername);
            fldUsername.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evtEnter) {
                    actUsernameEnter(evtEnter);
                }
            });
            lblPassword.setLabelFor(fldPassword);
            fldPassword.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evtEnter) {
                    actPasswordEnter(evtEnter);
                }
            });
            lblPassword2.setLabelFor(fldPassword2);
            fldPassword2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evtEnter) {
                    actPasswordEnter2(evtEnter);
                }
            });
            lblLevel.setLabelFor(cbxLevel);
            cbxLevel.addItem(1);
            cbxLevel.addItem(2);
            btnRegister.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evtRegister) {
                    actRegister(evtRegister);
                }
            });
            btnClear.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evtClear) {
                    actClear(evtClear);
                }
            });
            cbxLevel.setSelectedIndex(1);
            lblLogin.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            lblLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            lblLogin.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // the user clicks on the label
                    registerFrame.dispose();
                    Login.startLoginFrame();

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    // the mouse has entered the label
                    lblLogin.setForeground(Color.DARK_GRAY);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    // the mouse has exited the label
                    lblLogin.setForeground(Color.WHITE);
                }
            });
        }

        { // Setting up to the frame and panel
            registerFrame.setLayout(registerLayout);
            registerPanel.add(lblTitle);
            registerPanel.add(lblUsername);
            registerPanel.add(fldUsername);
            registerPanel.add(lblPassword);
            registerPanel.add(fldPassword);
            registerPanel.add(lblPassword2);
            registerPanel.add(fldPassword2);
            registerPanel.add(lblLevel);
            registerPanel.add(cbxLevel);
            registerPanel.add(btnRegister);
            registerPanel.add(btnClear);
            registerPanel.add(lblLogin);

            registerFrame.add(registerPanel);
            registerFrame.setSize(250, 250);
            registerFrame.setLocationRelativeTo(null);
            registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            registerFrame.setVisible(true);
        }

    }


    
    /** 
     * @param evtEnter
     */
    protected void actPasswordEnter2(ActionEvent evtEnter) {
        btnRegister.doClick();
    }

    
    /** 
     * @param evtEnter
     */
    protected void actPasswordEnter(ActionEvent evtEnter) {
        fldPassword2.requestFocus();
    }

    
    /** 
     * @param evtEnter
     */
    protected void actUsernameEnter(ActionEvent evtEnter) {
        fldPassword.requestFocus();
    }

    /**
     * @param evtRegister
     */
    protected void actRegister(ActionEvent evtRegister) {
        int intConfirm;
        String strHash;
        String strError;
        String strUsername = fldUsername.getText();
        char[] chrPassword = fldPassword.getPassword();
        char[] chrPassword2 = fldPassword2.getPassword();
        int intLevel = (int) cbxLevel.getSelectedItem();
        Color redLabel = Color.RED;
        strError = Register.credentialValidator(strUsername, chrPassword, chrPassword2);
        if (!strError.isEmpty()) {
            fldPassword.setBorder(BorderFactory.createLineBorder(redLabel));
            fldPassword2.setBorder(BorderFactory.createLineBorder(redLabel));
            JOptionPane.showMessageDialog(null, strError, "PDAS", 0, null);
        }
        // Validation for admin users
        if (intLevel == 1 && strError.isEmpty()) {
            strHash = JOptionPane.showInputDialog(null,
                    "Are you sure you want to create this admin user?\nPlease input the system Hash Code prompt to verify your identity:",
                    "Create User: " + strUsername, 2);
            if (Register.csvHashVerifier(strHash)) {
                if (Register.register(strUsername, chrPassword, intLevel)) {
                    JOptionPane.showMessageDialog(null, "User created succesfully!", "PDAS", 1, null);
                    registerFrame.dispose();
                    Register.logSessionRegister();
                    Login.startLoginFrame();
                } else {
                    JOptionPane.showMessageDialog(null, "User Creation Failed", "PDAS", 0, null);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Hash Code Error", "PDAS", 0, null);
            }
        }
        if (intLevel == 2 && strError.isEmpty()) {
            intConfirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to create this user?",
                    "Create User: " + strUsername, 0, 3);
            if (intConfirm == JOptionPane.YES_OPTION) {
                if (Register.register(strUsername, chrPassword, intLevel)) {
                    JOptionPane.showMessageDialog(null, "User created succesfully!", "PDAS", 1, null);
                    registerFrame.dispose();
                    Register.logSessionRegister();
                    Login.startLoginFrame();
                } else {
                    JOptionPane.showMessageDialog(null, "User Creation Failed", "PDAS", 0, null);
                }

            }
        }

    }

    /**
     * @param evtClear
     */
    private void actClear(ActionEvent evtClear) {
        fldUsername.setText("");
        fldPassword.setText("");
        fldPassword2.setText("");
        cbxLevel.setSelectedIndex(1);
    }

    /**
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Auto-generated method stub

    }

}
