package de.kfru.pse.CouchDbDemo.uebung;

import java.io.IOException;

import de.kfru.pse.CouchDbDemo.CloudantConnector.StudentConnector;

public class uebung5_countStudentSecondSemester {
	public static void main(String[] args) {
    	StudentConnector studentConnector = null;
    	
    	try {
    		studentConnector = new StudentConnector();
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//5. Anzahl der Studenten auslesen, die im zweiten Semester sind
        try {
        	int allStudentsInSemester2Count = studentConnector.getStudentsInSemesterCount(2);
			System.out.println("Zeige Anzahl alle Studenten im zweiten Semester an: " + allStudentsInSemester2Count);
        	
        } catch (Exception e) {
			// Auto-generated catch block
        	System.out.println("Error getting number of students in semester 2");
			e.printStackTrace();
		}
	}
}
