/**
 * @author      Timothy Kiyui (4316886@students.swinburne.edu.my)
 * @version     0.1
 * @since       19.04.2016
 */

package com.Kiyivinski;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class StudentUnit extends Model {
    /**
     * Resource Model for student_units
     * @param verbose  Enable debugging
     */
    StudentUnit(boolean verbose) {
        super(new ActiveRecordModel("student_units", StudentUnit.getColumns(), verbose));
    }

    /**
     * Gets all columns in resource
     * @return Columns as a list
     */
    static ArrayList<String> getColumns() {
        ArrayList<String> columns = new ArrayList<>();
        columns.add("id");
        columns.add("student_id");
        columns.add("unit_id");
        columns.add("semester_id");
        return columns;
    }

    /**
     * Creates resource instance
     * @param student_id ResourceStudent ID
     * @param unit_id Resource Unit ID
     * @param semester_id Resource Semester ID
     * @throws SQLException
     */
    public void create(String student_id, String unit_id, String semester_id) throws SQLException {
        HashMap<String, String> columns = new HashMap<>();
        columns.put("student_id", student_id);
        columns.put("unit_id", unit_id);
        columns.put("semester_id", semester_id);
        super.create(columns);
    }

    /**
     * Creates resource instance
     * @param student_id ResourceStudent ID
     * @param unit_id Resource Unit ID
     * @param semester_id Resource Semester ID
     * @throws SQLException
     */
    public void create(Integer student_id, Integer unit_id, Integer semester_id) throws SQLException {
        this.create(student_id.toString(), unit_id.toString(), semester_id.toString());
    }
}
