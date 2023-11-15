/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitaladministration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Lecturer
 */
public class DatabaseSetup {
    final String DB_BASE_URL = "jdbc:mysql://localhost";
    final String USER = "ooc2023";
    final String PASSWORD = "ooc2023";
    
    public boolean setupDB() throws SQLException {
        try(
                Connection conn = DriverManager.getConnection(DB_BASE_URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();  
            ){
            stmt.execute("CREATE DATABASE IF NOT EXISTS 'hospital';");
            stmt.execute("USE 'hospital';");
            String sql = 
                    "CREATE TABLE IF NOT EXISTS 'patientData' ("
                    + "'name' VARCHAR(255),"
                    + "'birthdate' DATE,"
                    + "'bloodType' VARCHAR(2),"
                    + "'id' INT(10)"
                    + ");";
            stmt.execute(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
