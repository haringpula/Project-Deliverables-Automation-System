package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import model.Session;

public class MainController extends DatabaseConnection {
    // TODO: will contain functions shared between both frames,
    private static Session session;
    private static int intAction = 1;
    private static int intUser;
    private static String sqlDate = "NOW()";
    private static String strDetail = "User ";
    private static String strName = "";
    private static String strLevel;
    private static String[] columnNames = { "ID", "Category", "Deliverable", "Details", "Status" };
    private static DefaultTableModel model = new DefaultTableModel();

    public static DefaultTableModel fetchTableData() {
        model.setColumnIdentifiers(columnNames);
        PreparedStatement sqlStatement;
        ResultSet sqlResult;

        String id = "";
        String category = "";
        String deliverable = "";
        String detail = "";
        String status = "";

        String query = "SELECT deliverables.deliverable_id, categories.category_name, deliverables.deliverable_name, deliverables.deliverable_detail, statuses.status_name FROM deliverables JOIN categories ON deliverables.category_id = categories.category_id JOIN statuses ON deliverables.status_id = statuses.status_id";

        try {
            sqlStatement = connectToDatabase().prepareStatement(query);

            sqlResult = sqlStatement.executeQuery();

            int i = 0;
            while (sqlResult.next()) {
                id = sqlResult.getString("deliverable_id");
                category = sqlResult.getString("category_name");
                deliverable = sqlResult.getString("deliverable_name");
                detail = sqlResult.getString("deliverable_detail");
                status = sqlResult.getString("status_name");
                model.addRow(new Object[] { id, category, deliverable, detail, status });
                i++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return model;
    }
}
