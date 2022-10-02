package view;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import model.Session;

// TODO: MainFrame activities
public class MainFrame extends JFrame implements ActionListener {
    // Initialize content here
    private JFrame mainFrame;
    private CardLayout mainLayout;
    private JPanel mainPanel;
    private JTable sessionTable;

    public MainFrame() {
        initializeMain();

    }

    /**
     * 
     */
    public void initializeMain() {

        { // Initialize component contents
            mainFrame = new JFrame("PDAS");
            mainLayout = new CardLayout();
            mainPanel = new JPanel();
            sessionTable = new JTable();

        }

        { // Initialize functionalities and layouts
            sessionTable.setModel(Session.fetchSessionData());
        }

        { // Setting up to the frame and panel
            mainFrame.setLayout(mainLayout);
            mainPanel.add(sessionTable);

            mainFrame.add(mainPanel);
            mainFrame.setSize(900, 500);
            mainFrame.setLocationRelativeTo(null);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setVisible(true);
            //JOptionPane.showMessageDialog(null, "Deliverable Created!\n Don't forget to set an alarm on <INSERT DATE HERE>\n so you can accomplish <TASK HERE> before the deadline!", "PDAS", 3);

        }
    }

    /**
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Auto-generated method stub

    }

}
