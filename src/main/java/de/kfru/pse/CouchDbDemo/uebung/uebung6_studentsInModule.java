package de.kfru.pse.CouchDbDemo.uebung;

import java.io.IOException;
import java.util.ArrayList;

import de.kfru.pse.CouchDbDemo.CloudantConnector.StudentConnector;
import de.kfru.pse.CouchDbDemo.Models.Student;

public class uebung6_studentsInModule {
	public static void main(String[] args) {
    	StudentConnector studentConnector = null;
    	
    	try {
    		studentConnector = new StudentConnector();
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//6. Alle Studenten, die das Modul DB belegt haben
        try {
        	ArrayList<Student> allStudentsWhoVisitedDB = studentConnector.getStudentsByModule("DB");
			System.out.println("Zeige alle Studenten die DB besucht haben: ");
        	for (Student student : allStudentsWhoVisitedDB) {
				System.out.println("- " + student);
			}
        } catch (Exception e) {
			// Auto-generated catch block
        	System.out.println("Error getting all students who visited DB");
			e.printStackTrace();
		}
	}
}
