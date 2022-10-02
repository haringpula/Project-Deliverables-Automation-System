package view;

import java.awt.*;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JPanel;

import controller.MainController;
import model.Deliverable;

public class SecondaryFrame extends JFrame implements ActionListener {
    // Initialize content here
    private JFrame secondaryFrame;
    private CardLayout secondaryLayout;
    private JPanel secondaryPanel;
    private JScrollPane secondaryPane;
    private JTable deliverableTable;
    
    // TODO: secondaryPanel does not layout table model properly

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
            secondaryPane = new JScrollPane();
            deliverableTable = new JTable();
        }

        

        { // Initialize functionalities and layouts
            deliverableTable.setModel(Deliverable.fetchTableData());
        }

        { // Setting up to the frame and panel
            secondaryFrame.setLayout(secondaryLayout);
            secondaryFrame.add(secondaryPanel);
            secondaryPanel.add(deliverableTable);

            secondaryFrame.add(secondaryPanel);
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
