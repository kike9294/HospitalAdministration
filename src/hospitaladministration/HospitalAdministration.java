/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hospitaladministration;

import java.sql.SQLException;

/**
 *
 * @author Lecturer
 */
public class HospitalAdministration {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Patient p1 = new Patient("Sam", "2023-11-15", "O+");
        Patient p2 = new Patient("Lexie", "2021-11-27", "A-");
        
        System.out.println(p1.getPatientID());
        System.out.println(p2.getPatientID());
        
        System.out.println(Patient.getCurrentID());
        if (DatabaseSetup.setupDB()) {
            System.out.println("Database and table created");
        } else {
            System.out.println("Oh no! There was a database creation problem...");
        }
        // Adding p1 to the database
        DatabaseWriter dbw = new DatabaseWriter();
        if (dbw.addPatient(p1)) {
            System.out.println("p1 added");
        }
    }
    
}
