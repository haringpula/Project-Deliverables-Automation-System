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
        Date dtStart,
        Date dtEnd,
        int intStatus) {

    /**
     * @return DefaultTableModel
     */
    public static DefaultTableModel fetchTableData() {
        // BUG: Fucking nuclear level refactoring required, change to String[][]
        String[] columnNames = new String[] { "ID", "Category", "Deliverable", "Details", "Status" };
        // Object[][] data;
        final DefaultTableModel model = new DefaultTableModel(null, columnNames);
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
            sqlStatement = DatabaseConnection.connectToDatabase().prepareStatement(query);

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
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(model.getValueAt(i, j) + " | ");
            }
            System.out.println();
        }
        return model;
    }

}
