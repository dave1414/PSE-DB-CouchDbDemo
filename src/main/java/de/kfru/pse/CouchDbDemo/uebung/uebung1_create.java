package de.kfru.pse.CouchDbDemo.uebung;

import java.io.IOException;

import de.kfru.pse.CouchDbDemo.CloudantConnector.StudentConnector;
import de.kfru.pse.CouchDbDemo.Models.Address;
import de.kfru.pse.CouchDbDemo.Models.Student;

public class uebung1_create {
	public static void main(String[] args) {
    	StudentConnector studentConnector = null;
    	
    	try {
    		studentConnector = new StudentConnector();
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//1. Neuen Studenten erstellen
    	//TODO: neuen Studenten ersellen
    	Student neuerStudent = new Student("", "", "", "", 0, new Address("", ""), 0, new String[]{"", ""});
    	//new Student("matrikelnummer", "vorname", "nachname", "bacheloruni", note, new Address("Strasse", "Stadt"), semester, new String[]{"fach1", "fach2", ...});
        
    	try {
        	studentConnector.saveStudent(neuerStudent);
			System.out.println( "Saved new student " + neuerStudent);
        } catch (Exception e) {
			// Auto-generated catch block
        	System.out.println("Error saving new student");
			e.printStackTrace();
		}
	}
}
