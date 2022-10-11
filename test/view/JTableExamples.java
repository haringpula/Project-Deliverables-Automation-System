package view;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.github.lgooddatepicker.components.DatePicker;
 
public class JTableExamples {
    // frame
    JFrame f;
    // Table
    JTable j;

    DatePicker p;
    JButton b;
 
    // Constructor
    JTableExamples()
    {
        // Frame initialization
        f = new JFrame();
 
        // Frame Title
        f.setTitle("JTable Example");
 
        // Data to be displayed in the JTable
        String[][] data = {
            { "Kundan Kumar Jha", "4031", "CSE" },
            { "Anand Jha", "6014", "IT" }
        };
 
        // Column Names
        String[] columnNames = { "Name", "Roll Number", "Department" };
 
        // Initializing the JTable
        j = new JTable(data, columnNames);
        j.setBounds(30, 40, 200, 300);

        p = new DatePicker();
        //p.setDateToToday();
        b = new JButton("Press");
        b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                act(evt);
            }

            private void act(ActionEvent evt) {
                String str = "Wala";
                if (p.getDateStringOrEmptyString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, str, "Test", 2);
                } else {
                    JOptionPane.showMessageDialog(null, p.getDate(), "Test", 2);
                }
                
            }
        });
 
        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(j);
        f.add(p);
        f.add(b);
        // Frame Size
        f.setSize(500, 200);
        // Frame Visible = true
        f.setVisible(true);
    }
 
    // Driver  method
    public static void main(String[] args)
    {
        new JTableExamples();
    }
}