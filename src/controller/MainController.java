package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import model.Deliverable;
import model.Session;

public class MainController extends DeliverableOperations {
    // TODO: will contain functions shared between both frames,
    // fetch table
    // also contain functions only for the main veiw frame.. like selectable
    // table... implementation might vary on the view
    private static Session session;
    private static int intUser;
    private static String sqlDate = "NOW()";
    private static String strDetail = "User ";
    private static String strName = "";
    private static String strLevel;

    // differientiate anong part ng deliverable ang iedit
    // generate deliverable shits here
    // Deliverable deliverable = new Deliverable(0, null, null, null, null, 0);
    
    
}
