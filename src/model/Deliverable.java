package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import controller.DatabaseConnection;

public record Deliverable(
        int intCategory,
        String strName,
        String strDetail,
        Date dtEnd,
        int intStatus) {

    /**
     * @return DefaultTableModel
     */
    public static String[][] fetchTableData() {
        String[] columnNames = new String[] { "ID", "Category", "Deliverable", "Details", "Start", "End", "Status" };
        PreparedStatement sqlStatement;
        ResultSet sqlResult;

        int intDeliverableCount = 0;
        int i;

        String query = "SELECT COUNT(deliverable_id) AS deliverable_count FROM deliverables";

        try {
            sqlStatement = DatabaseConnection.connectToDatabase().prepareStatement(query);
            sqlResult = sqlStatement.executeQuery();

            if (sqlResult.next()) {
                intDeliverableCount = sqlResult.getInt("deliverable_count");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        String[][] mtxDeliverables = new String[intDeliverableCount][7];

        query = "SELECT deliverables.deliverable_id, categories.category_name, deliverables.deliverable_name, deliverables.deliverable_detail, deliverables.deliverable_start, deliverables.deliverable_end, statuses.status_name FROM deliverables JOIN categories ON deliverables.category_id = categories.category_id JOIN statuses ON deliverables.status_id = statuses.status_id";

        try {
            sqlStatement = DatabaseConnection.connectToDatabase().prepareStatement(query);
            sqlResult = sqlStatement.executeQuery();

            i = 0;
            while (sqlResult.next()) {
                mtxDeliverables[i][0] = sqlResult.getString("deliverable_id");
                mtxDeliverables[i][1] = sqlResult.getString("category_name");
                mtxDeliverables[i][2] = sqlResult.getString("deliverable_name");
                mtxDeliverables[i][3] = sqlResult.getString("deliverable_detail");
                mtxDeliverables[i][4] = sqlResult.getString("deliverable_start");
                mtxDeliverables[i][5] = sqlResult.getString("deliverable_end");
                mtxDeliverables[i][6] = sqlResult.getString("status_name");
                i++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return mtxDeliverables;
    }

}
