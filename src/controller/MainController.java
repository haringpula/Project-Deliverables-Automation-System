package controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.table.DefaultTableModel;

import model.Actions;
import model.Categories;
import model.Deliverable;
import model.Session;
import model.Statuses;
import view.MainFrame;
import view.SecondaryFrame;

public class MainController extends DeliverableOperations {
    private Session session;
    private static int intUser;
    private static String strUser;

    /**
     * @param intCategory
     * @param strName
     * @param strDetail
     * @param strStart
     * @param strEnd
     * @param intStatus
     * @return boolean
     */
    // TODO: will contain functions shared between both frames,
    // fetch table
    // also contain functions only for the main veiw frame.. like selectable
    // table... implementation might vary on the view

    // differientiate anong part ng deliverable ang iedit
    // generate deliverable shits here
    // Deliverable deliverable = new Deliverable(0, null, null, null, null, 0);

    public static boolean createDeliverable(int intCategory, String strName, String strDetail, String strEnd,
            int intStatus) {
        String strSessionDetail = "User ";
        Date dtEnd = strToDate(strEnd);
        Deliverable deliverable = new Deliverable(intCategory, strName, strDetail, dtEnd, intStatus);

        strSessionDetail += strUser;
        strSessionDetail += " (id ";
        strSessionDetail += String.valueOf(intUser);
        strSessionDetail += ") has created ";
        strSessionDetail += strName;
        strSessionDetail += "!";

        if (createOperation(deliverable)) {
            Session session = new Session(Actions.CREATE.id, intUser, strSessionDetail, strUser);
            session.logSession();
            return true;
        }
        return false;
    }

    /**
     * @param strDate
     * @return Date
     */
    private static Date strToDate(String strDate) {
        if (strDate.isEmpty()) {
            return null;
        } else {
            return Date.valueOf(strDate);
        }
    }

    /**
     * @param strName
     * @return int
     */
    public int findDeliverableId(String strName) {
        int intId;
        PreparedStatement sqlStatement;
        ResultSet sqlResult;

        String query = "SELECT * FROM `deliverables` WHERE `deliverable_name` =?";

        try {
            sqlStatement = connectToDatabase().prepareStatement(query);

            sqlStatement.setString(1, strName);

            sqlResult = sqlStatement.executeQuery();

            while (sqlResult.next()) {
                intId = sqlResult.getInt("deliverable_id");
                return intId;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        // SEE: idk what to return if this method fails
        return -1;
    }

    public static void startMainFrame() {
        intUser = Login.getID();
        strUser = Login.getUser();
        // HACK: display table to console out
        Scanner in = new Scanner(System.in);
        int intMenu = -1;
        System.out.println("Welcome\n0. Exit\n1. Login\n2. Register");
        while (true) {
            System.out.print("Enter: ");
            intMenu = in.nextInt();
            switch (intMenu) {
                case 0:
                    System.out.println("Exiting now");
                    in.close();
                    System.exit(0);
                    break;
                case 1:
                    System.out.println();
                    boolean b = false;
                    try {
                        b = createDeliverable(Categories.CONTROLLER.id, "Deliverables", null, "", Statuses.CRITICAL.id);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (b) {
                        System.out.println("Success");
                    } else {
                        System.out.println("nope");
                    }
                    break;
                case 2:
                    System.out.println();
                    break;
                default:
                    System.out.println("Try again");
                    break;
            }
        }
        // new MainFrame();
    }

    public static void startSecondaryFrame() {
        intUser = Login.getID();
        // HACK: display table to console out
        new SecondaryFrame();
    }

}
