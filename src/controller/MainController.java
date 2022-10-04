package controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import model.Actions;
import model.Deliverable;
import model.Session;

public class MainController extends DeliverableOperations {
    private Session session;
    // TODO: this class should be able to get the int user called from the other class.. idk how
    private int intId = Login.getID();

    
    
    // TODO: will contain functions shared between both frames,
    // fetch table
    // also contain functions only for the main veiw frame.. like selectable
    // table... implementation might vary on the view

    // differientiate anong part ng deliverable ang iedit
    // generate deliverable shits here
    // Deliverable deliverable = new Deliverable(0, null, null, null, null, 0);

    public boolean createDeliverable(int intCategory, String strName, String strDetail, String strStart, String strEnd, int intStatus) {
        String strSessionDetail = "";
        Date dtStart = strToDate(strStart);
        Date dtEnd = strToDate(strEnd);
        Deliverable deliverable = new Deliverable(intStatus, strDetail, strDetail, dtStart, dtEnd, intStatus);
        if (createOperation(deliverable)) {
            // TODO: PASS USER FROM LOGIN
            //session = new Session(Actions.CREATE.id(), , , );
            session.logSession();
            return true;
        }
        return false;
    }



    private Date strToDate(String strDate) {
        return Date.valueOf(strDate);
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
        // idk what to return if this method fails
        return -1;
    }
}
