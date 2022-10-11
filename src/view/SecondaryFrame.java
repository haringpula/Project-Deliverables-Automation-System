package view;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class SecondaryFrame extends JFrame implements ActionListener {
    // Initialize content here
    private JFrame secondaryFrame;
    private CardLayout secondaryLayout;

    // FIXME: secondaryPanel does not layout table model properly

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

        }

        { // Initialize functionalities and layouts

        }

        { // Setting up to the frame and panel
            secondaryFrame.setLayout(secondaryLayout);

            secondaryFrame.setSize(700, 500);
            secondaryFrame.setLocationRelativeTo(null);
            secondaryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            secondaryFrame.setVisible(true);
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
