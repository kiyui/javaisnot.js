/**
 * @author      Timothy Kiyui (4316886@students.swinburne.edu.my)
 * @version     0.1
 * @since       19.04.2016
 */

package com.Kiyivinski;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Assessment extends Model {
    /**
     * Resource Model for assessments
     * @param verbose Enable debugging
     */
    Assessment(boolean verbose) {
        super(new ActiveRecordModel("assessments", Assessment.getColumns(), verbose));
    }

    /**
     * Gets all columns in resource
     * @return Columns as a list
     */
    static ArrayList<String> getColumns() {
        ArrayList<String> columns = new ArrayList<>();
        columns.add("id");
        columns.add("name");
        columns.add("mark");
        columns.add("type_id");
        columns.add("semester_id");
        return columns;
    }

    /**
     * Creates a resource instance
     * @param name Resource name
     * @param mark Resource marks
     * @param type_id Resource type
     * @param semester_id Resource semester
     * @throws SQLException
     */
    public void create(String name, String mark, String type_id, String semester_id) throws SQLException {
        HashMap<String, String> columns = new HashMap<>();
        columns.put("name", name);
        columns.put("mark", mark);
        columns.put("type_id", type_id);
        columns.put("semester_id", semester_id);
        super.create(columns);
    }

    /**
     * Creates a resource instance
     * @param name Resource name
     * @param mark Resource marks
     * @param type_id Resource type
     * @param semester_id Resource semester
     * @throws SQLException
     */
    public void create(String name, Integer mark, Integer type_id, Integer semester_id)  throws SQLException {
        this.create(name, mark.toString(), type_id.toString(), semester_id.toString());
    }

    /**
     * Query Assessments from a specific unit and semester
     * @param unitID Unit ID
     * @param semesterID Semester ID
     * @param unitAssessment unit_assessment Model
     * @return
     * @throws SQLException
     */
    public ArrayList<HashMap<String, String>> whereUnitSemester(String unitID, String semesterID, UnitAssessment unitAssessment) throws SQLException {
        ArrayList<HashMap<String, String>> assessments = this.where("semester_id", semesterID.toString());
        ArrayList<HashMap<String, String>> units = unitAssessment.where("unit_id", unitID.toString());

        ArrayList<HashMap<String, String>> results = new ArrayList<>();

        for (HashMap<String, String> assessment: assessments) {
            for (HashMap<String, String> unit : units) {
                if (assessment.get("id").equals(unit.get("assessment_id"))) {
                    results.add(assessment);
                }
            }
        }
        return results;
    }
}
