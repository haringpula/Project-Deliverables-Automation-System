package view;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextPane;

import com.github.lgooddatepicker.components.DatePicker;

import model.Session;

// TODO: MainFrame activities
public class MainFrame extends JFrame implements ActionListener {
    // Initialize content here
    private JFrame mainFrame;
    private CardLayout mainLayout;
    private JSplitPane splitTableButtons;
    private JPanel tablePanel;
    private JScrollPane tablePane;
    private JPanel buttoPanel;
    private JTable sessionTable;
    private JLabel lblStart;
    
    private DatePicker dtStart;

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
            splitTableButtons = new JSplitPane(1);
            tablePanel =  new JPanel();
            tablePane = new JScrollPane();
            buttoPanel = new JPanel();
            sessionTable = new JTable();
            lblStart = new JLabel("");
            dtStart = new DatePicker();
            

        }

        { // Initialize functionalities and layouts
            
            sessionTable.setModel(Session.fetchSessionData());
            dtStart.setDateToToday();
            dtStart.setEnabled(true);
            lblStart.setText(dtStart.getDate().toString());
        }

        { // Setting up to the frame and panel
            mainFrame.setLayout(mainLayout);

            splitTableButtons.add(tablePanel);
            splitTableButtons.add(buttoPanel);
            tablePanel.add(tablePane);
            tablePane.add(sessionTable);
            buttoPanel.add(lblStart);
            buttoPanel.add(dtStart);

            mainFrame.add(splitTableButtons);
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

