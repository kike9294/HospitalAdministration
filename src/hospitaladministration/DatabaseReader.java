/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitaladministration;

import static hospitaladministration.Database.DB_URL;
import static hospitaladministration.Database.PASSWORD;
import static hospitaladministration.Database.TABLE_NAME;
import static hospitaladministration.Database.USER;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Lecturer
 */
public class DatabaseReader extends Database {
    public ArrayList<Patient> getAllData() {
        try(
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();  
        ){
            /*
            Exercise
            read each row
            assign the data to a new Patient object
            add the Patient to the list
            return the list
            */
            // Object that stores the result of our query
            ResultSet results = stmt.executeQuery(String.format(
                    "SELECT * FROM %s;",
                    TABLE_NAME));
            // results is a cursor/pointer to a particular row in the results
            // once we are on the row we want, we can extract the data based on the 
            // column name
            // Selects row 1
            System.out.println(results.next());
            // Selects row 2
            System.out.println(results.next());
            // Selects row 3
            System.out.println(results.next());
            // Selects row 4
            System.out.println(results.next());
            System.out.println(results.next());
            System.out.println(results.getString("name"));
            System.out.println(results.getInt("id"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }  
        

    }
    
    public Patient getPatientData(int patientID) {
            try(
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();  
            ){
                // Object that stores the result of our query
                ResultSet results = stmt.executeQuery(String.format(
                        "SELECT * FROM %s WHERE id=%d;",
                        TABLE_NAME, patientID));
                results.next();
                System.out.println(results.getString("name"));
                String name = results.getString("name");
                String birthdate = results.getString("birthdate");
                String bloodtype = results.getString("bloodtype");
                int id = results.getInt("id");
                Patient patient = new Patient(name, birthdate, bloodtype, id);
                return patient;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }              
        }
}
