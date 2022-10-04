package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Deliverable;

// TODO: JUnit these shit
public class DeliverableOperations extends DatabaseConnection {

    /**
     * @param deliverable
     * @return boolean
     */
    public static boolean createDeliverable(Deliverable deliverable) {
        PreparedStatement sqlStatement;
        int intResult;

        String query = "INSERT INTO `deliverables`(`category_id`, `deliverable_name`, `deliverable_detail`, `deliverable_start`, `deliverable_end`, `status_id`) VALUES (?,?,?,?,?,?)";

        try {
            sqlStatement = connectToDatabase().prepareStatement(query);

            sqlStatement.setInt(1, deliverable.intCategory());
            sqlStatement.setString(2, deliverable.strName());
            sqlStatement.setString(3, deliverable.strDetail());
            sqlStatement.setDate(4, deliverable.dtStart());
            sqlStatement.setDate(5, deliverable.dtEnd());
            sqlStatement.setInt(6, deliverable.intStatus());

            intResult = sqlStatement.executeUpdate();

            if (intResult > 0) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;

    }

    /**
     * @param deliverable
     * @param intId
     * @return boolean
     */
    public static boolean updateDeliverable(Deliverable deliverable, int intId) {
        PreparedStatement sqlStatement;
        int intResult;

        String query = "UPDATE `deliverables` SET `category_id`=?, `deliverable_name`=?, `deliverable_detail`=?,`deliverable_end`=?,`status_id`=? WHERE `deliverable_id` =?";

        try {
            sqlStatement = connectToDatabase().prepareStatement(query);

            sqlStatement.setInt(1, deliverable.intCategory());
            sqlStatement.setString(2, deliverable.strName());
            sqlStatement.setString(3, deliverable.strDetail());
            sqlStatement.setDate(4, deliverable.dtEnd());
            sqlStatement.setInt(5, deliverable.intStatus());
            sqlStatement.setInt(6, intId);

            intResult = sqlStatement.executeUpdate();

            if (intResult > 0) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;

    }

    /**
     * @param intId
     * @return boolean
     */
    public static boolean deleteDeliverable(int intId) {
        PreparedStatement sqlStatement;
        int intResult;

        String query = "DELETE FROM `deliverables` WHERE `deliverable_id` =?";

        try {
            sqlStatement = connectToDatabase().prepareStatement(query);

            sqlStatement.setInt(1, intId);

            intResult = sqlStatement.executeUpdate();

            if (intResult > 0) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;

    }

    /**
     * @param strName
     * @return int
     */
    public static int findDeliverableId(String strName) {
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
