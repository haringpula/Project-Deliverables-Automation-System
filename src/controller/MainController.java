package controller;

import java.sql.Date;
import java.util.Scanner;

import model.Actions;
import model.Categories;
import model.Deliverable;
import model.Session;
import model.Statuses;
import view.MainFrame;
import view.SecondaryFrame;

public class MainController extends DeliverableOperations {
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
    public static boolean createDeliverable(int intCategory, String strName, String strDetail, String strEnd,
            int intStatus) {
        String strSessionDetail = "User ";
        Date dtEnd = strToDate(strEnd);
        Deliverable deliverable = new Deliverable(intCategory, strName, strDetail, dtEnd, intStatus);

        if (createOperation(deliverable)) {
            strSessionDetail += strUser;
            strSessionDetail += " (id ";
            strSessionDetail += String.valueOf(intUser);
            strSessionDetail += ") has created ";
            strSessionDetail += strName;
            strSessionDetail += " (id ";
            strSessionDetail += String.valueOf(findDeliverableId(strName));
            strSessionDetail += ")!";

            Session session = new Session(Actions.CREATE.id, intUser, strSessionDetail, strUser);
            session.logSession();
            return true;
        }
        return false;
    }

    /** 
     * @param intCategory
     * @param strName
     * @param strDetail
     * @param strEnd
     * @param intStatus
     * @return boolean
     */
    public static boolean updateDeliverable(int intCategory, String strName, String strDetail, String strEnd,
            int intStatus) {
        String strSessionDetail = "User ";
        Date dtEnd = strToDate(strEnd);
        int intId = findDeliverableId(strName);
        Deliverable deliverable = new Deliverable(intCategory, strName, strDetail, dtEnd, intStatus);

        if (updateOperation(deliverable, intId)) {
            strSessionDetail += strUser;
            strSessionDetail += " (id ";
            strSessionDetail += String.valueOf(intUser);
            strSessionDetail += ") has updated ";
            strSessionDetail += strName;
            strSessionDetail += " (id ";
            strSessionDetail += String.valueOf(findDeliverableId(strName));
            strSessionDetail += ")!";

            Session session = new Session(Actions.UPDATE.id, intUser, strSessionDetail, strUser);
            session.logSession();
            return true;
        }
        return false;
    }

    
    /** 
     * @param strName
     * @return boolean
     */
    public static boolean deleteDeliverable(String strName) {
        String strSessionDetail = "User ";
        int intId = findDeliverableId(strName);
        if (deleteOperation(intId)) {
            strSessionDetail += strUser;
            strSessionDetail += " (id ";
            strSessionDetail += String.valueOf(intUser);
            strSessionDetail += ") has deleted a deliverable (";
            strSessionDetail += strName;
            strSessionDetail += ")!";

            Session session = new Session(Actions.DELETE.id, intUser, strSessionDetail, strUser);
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
     * 
     */
    public static void startMainFrame() {
        intUser = Login.getID();
        strUser = Login.getUser();
        new MainFrame();
        // HACK: display table to console out
        Scanner in = new Scanner(System.in);
        int intMenu = -1;
        System.out.println("Welcome\n0. Exit\n1. Create\n2. Update\n3. Show Deliverables\n4. Show Sessions\n5. Counts");
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
                    if (createDeliverable(Categories.RESOURCES.id, "Icons", "Create Icons and put in res folder",
                            "2022-10-14", Statuses.URGENT.id)) {
                        System.out.println("Success");
                    } else {
                        System.out.println("nope");
                    }
                    break;
                case 2:
                    System.out.println();
                    if (updateDeliverable(Categories.CONTROLLER.id, "Deliverables", "implement with a new thing first",
                            "2022-10-11", Statuses.CRITICAL.id)) {
                        System.out.println("Success");
                    } else {
                        System.out.println("nope");
                    }
                    break;
                case 3:
                    String[][] mtxDeliverables = Deliverable.fetchTableData();
                    for (int i = 0; i < mtxDeliverables.length; i++) {
                        for (int j = 0; j < 7; j++) {
                            System.out.print(mtxDeliverables[i][j] + " | ");
                        }
                        System.out.println();
                    }
                    break;
                case 4:
                    String[][] mtxSessions = Session.fetchSessionData();
                    for (int i = 0; i < mtxSessions.length; i++) {
                        for (int j = 0; j < 2; j++) {
                            System.out.print(mtxSessions[i][j] + " | ");
                        }
                        System.out.println();
                    }
                    break;
                case 5:
                    System.out.println("Deliverables: " + Deliverable.fetchDeliverableCount());
                    System.out.println("Sessions: " + Session.fetchSessionCount());
                    break;
                case 6:
                    System.out.println();
                    if (deleteDeliverable("Deliverables")) {
                        System.out.println("Success");
                    } else {
                        System.out.println("nope");
                    }
                    break;
                default:
                    System.out.println("Try again");
                    break;
            }
        }

    }

    /**
     * 
     */
    public static void startSecondaryFrame() {
        intUser = Login.getID();
        new SecondaryFrame();
    }

}
