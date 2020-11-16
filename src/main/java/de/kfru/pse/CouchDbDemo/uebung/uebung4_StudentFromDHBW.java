package de.kfru.pse.CouchDbDemo.uebung;

import java.io.IOException;
import java.util.ArrayList;

import de.kfru.pse.CouchDbDemo.CloudantConnector.StudentConnector;
import de.kfru.pse.CouchDbDemo.Models.Student;

public class uebung4_StudentFromDHBW {
	public static void main(String[] args) {
    	StudentConnector studentConnector = null;
    	
    	try {
    		studentConnector = new StudentConnector();
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//4. Studenten, die ihren Bachelor an der DHBW Stuttgart gemacht haben
        try {
        	ArrayList<Student> allStudentsfromDHBW = studentConnector.getAllStudentsWithBachelorAt("DHBW Stuttgart");
			System.out.println("Zeige alle Studenten die von der DHBW Stuttgart kommen an: ");
        	for (Student student : allStudentsfromDHBW) {
				System.out.println("- " + student);
			}
        } catch (Exception e) {
			// Auto-generated catch block
        	System.out.println("Error getting all students coming from DHBW");
			e.printStackTrace();
		}
	}
}
