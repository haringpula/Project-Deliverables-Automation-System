package view;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SecondaryFrame extends JFrame implements ActionListener {
    // Initialize content here
    private JFrame secondaryFrame;
    private CardLayout secondaryLayout;
    private JPanel secondaryPanel;

    public SecondaryFrame() {
        initializeMain();

    }

    /**
     * 
     */
    public void initializeMain() {

        { // Initialize component contents
            secondaryFrame = new JFrame("PDAS");
            secondaryLayout = new CardLayout();
            secondaryPanel = new JPanel();

        }

        { // Setting up to the frame and panel
            secondaryFrame.setLayout(secondaryLayout);

            secondaryFrame.add(secondaryPanel);
            secondaryFrame.setSize(250, 250);
            secondaryFrame.setLocationRelativeTo(null);
            secondaryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            secondaryFrame.setVisible(true);
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
