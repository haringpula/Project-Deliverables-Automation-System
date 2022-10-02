package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import model.Session;

public class MainController extends DatabaseConnection {
    // TODO: will contain functions shared between both frames,
    // fetch table
    // also contain functions only for the main veiw frame.. like selectable table... implementation might vary on the view
    private static Session session;
    private static int intAction = 1;
    private static int intUser;
    private static String sqlDate = "NOW()";
    private static String strDetail = "User ";
    private static String strName = "";
    private static String strLevel;

    // TODO: functions for deliverables
    // creating deliverables, 
    // editing deliverable status, 
    // editing deliverable name or detail
    // editing deliverable category
    // deleting deliverable

    // FUNCTIONS HERE WILL GET SHIT FROM VIEW, THEN EXECUTE FROM DELIVERABLE RECORD
    // ANDUN YNUG SQL SHIT WAG KA MALITO


    //INSERT INTO deliverables(category_id, deliverable_name, deliverable_start, status_id) VALUES (1,"Finish REAME",CURDATE(), 2);

    
    
}
