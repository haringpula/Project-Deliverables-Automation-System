package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

// TODO: Set things to private if needed
public class RegisterFrame extends JFrame implements ActionListener {
    // Initialize content here
    JFrame registerFrame;
    CardLayout registerLayout;
    JPanel registerPanel;
    JLabel lblTitle;
    JLabel lblUsername;
    JTextField fldUsername;
    JLabel lblPassword;
    JPasswordField fldPassword;
    JButton btnRegister;
    JButton btnClear;
    JComboBox<Integer> cbxLevel;
    JLabel lblLogin;

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
            btnRegister = new JButton("Register");
            btnClear = new JButton("Clear");
            cbxLevel = new JComboBox<Integer>();
            lblLogin = new JLabel("Login");
        }

        { // Setting up to the frame and panel
            registerFrame.setLayout(registerLayout);
            registerPanel.add(lblTitle);
            registerPanel.add(lblUsername);
            registerPanel.add(fldUsername);
            registerPanel.add(lblPassword);
            registerPanel.add(fldPassword);
            registerPanel.add(btnRegister);
            registerPanel.add(btnClear);
            registerPanel.add(cbxLevel);
            registerPanel.add(lblLogin);

            registerFrame.add(registerPanel);
            registerFrame.setSize(250, 250);
            registerFrame.setLocationRelativeTo(null);
            registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            registerFrame.setVisible(true);
        }

        { // Initialize functionalities and layouts
            lblUsername.setLabelFor(fldUsername);
            lblPassword.setLabelFor(fldPassword);
            btnRegister.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evtLogin) {
                    actLogin(evtLogin);
                }
            });
            btnClear.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evtClear) {
                    actClear(evtClear);
                }
            });
            cbxLevel.addItem(1);
            cbxLevel.addItem(2);
            lblLogin.setForeground(Color.BLUE.darker());
            lblLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            lblLogin.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    // the user clicks on the label
                    registerFrame.setVisible(false);
                    new LoginFrame();

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    // the mouse has entered the label
                    lblLogin.setText("<html><a href=''>Login</a></html>");
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    // the mouse has exited the label
                    lblLogin.setText("Login");
                }
            });
        }

        
    }

    /**
     * @param evtLogin
     */
    protected void actLogin(ActionEvent evtLogin) {
        // TODO: Register

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
        // Auto-generated method stub

    }

}
