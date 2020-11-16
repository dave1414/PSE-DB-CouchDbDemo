package de.kfru.pse.CouchDbDemo.uebung;

import java.io.IOException;

import de.kfru.pse.CouchDbDemo.CloudantConnector.StudentConnector;
import de.kfru.pse.CouchDbDemo.Models.Student;

public class uebung3_update {
	public static void main(String[] args) {
    	StudentConnector studentConnector = null;
    	
    	try {
    		studentConnector = new StudentConnector();
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//1. Studenten aus DB abrufen
    	//TODO matrikelnummer festlegen
    	Student meinStudent = studentConnector.getStudent("");
    	
    	
    	//3. Den eigenen Studenten ändern und geändert abspeichern
        try {
        	meinStudent.setSemester(8);
        	studentConnector.updateStudent(meinStudent);
			System.out.println( "Updated " + meinStudent);
        } catch (Exception e) {
			// Auto-generated catch block
        	System.out.println("Error updating " + meinStudent);
			e.printStackTrace();
		}
	}
}
