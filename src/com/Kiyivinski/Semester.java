/**
 * @author      Timothy Kiyui (4316886@students.swinburne.edu.my)
 * @version     0.1
 * @since       19.04.2016
 */

package com.Kiyivinski;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Semester extends Model {
    Semester(boolean verbose) {
        super(new ActiveRecordModel("semesters", Semester.getColumns(), verbose));
    }

    static ArrayList<String> getColumns() {
        ArrayList<String> columns = new ArrayList<>();
        columns.add("id");
        columns.add("name");
        return columns;
    }

    public void create(String name) throws SQLException {
        HashMap<String, String> columns = new HashMap<>();
        columns.put("name", name);
        super.create(columns);
    }
}
