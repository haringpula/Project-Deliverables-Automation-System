package view;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements ActionListener {
    // Initialize content here
    private JFrame registerFrame;
    private CardLayout registerLayout;
    private JPanel registerPanel;

    public MainFrame() {
        initializeMain();

    }

    /**
     * 
     */
    public void initializeMain() {

        { // Initialize component contents
            registerFrame = new JFrame("PDAS");
            registerLayout = new CardLayout();
            registerPanel = new JPanel();

        }

        { // Setting up to the frame and panel
            registerFrame.setLayout(registerLayout);

            registerFrame.add(registerPanel);
            registerFrame.setSize(250, 250);
            registerFrame.setLocationRelativeTo(null);
            registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            registerFrame.setVisible(true);
        }

        { // Initialize functionalities and layouts

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
