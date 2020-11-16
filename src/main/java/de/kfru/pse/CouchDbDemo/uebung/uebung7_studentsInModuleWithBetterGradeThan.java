package de.kfru.pse.CouchDbDemo.uebung;

import java.io.IOException;

import de.kfru.pse.CouchDbDemo.CloudantConnector.StudentConnector;

public class uebung7_studentsInModuleWithBetterGradeThan {
	public static void main(String[] args) {
    	StudentConnector studentConnector = null;
    	
    	try {
    		studentConnector = new StudentConnector();
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//7. Anzahl der Studenten im Modul DB, die im Bachelor besser als 2.0 waren
        try {
        	int countOfStudents = studentConnector.getStudentCountPerModuleBetterThan("DB", 2);
        	System.out.println("Presenting number of students in DB better than 2.0: " + countOfStudents);
        } catch (Exception e) {
			// Auto-generated catch block
        	System.out.println("Error getting all students who visited DB");
			e.printStackTrace();
		}
	}
}
