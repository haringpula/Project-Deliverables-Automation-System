package view;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

// TODO: MainFrame activities
public class MainFrame extends JFrame implements ActionListener {
    // Initialize content here
    private JFrame mainFrame;
    private CardLayout mainLayout;
    private JPanel mainPanel;

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

        }

        { // Initialize functionalities and layouts

        }

        { // Setting up to the frame and panel
            mainFrame.setLayout(mainLayout);

            mainFrame.add(mainPanel);
            mainFrame.setSize(900, 500);
            mainFrame.setLocationRelativeTo(null);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setVisible(true);
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
