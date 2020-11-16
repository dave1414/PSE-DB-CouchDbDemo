package de.kfru.pse.CouchDbDemo.uebung;

import java.io.IOException;

import de.kfru.pse.CouchDbDemo.CloudantConnector.StudentConnector;
import de.kfru.pse.CouchDbDemo.Models.Student;

public class uebung2_read {
	public static void main(String[] args) {
    	StudentConnector studentConnector = null;
    	
    	try {
    		studentConnector = new StudentConnector();
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//2. Den eigenen Studenten wieder auslesen
    	//TODO: Matrikelnummer in Methodenaufruf ergänzen
        Student meinStudent = studentConnector.getStudent("");
        System.out.println( "Mein Student: " + meinStudent);
	}
}
