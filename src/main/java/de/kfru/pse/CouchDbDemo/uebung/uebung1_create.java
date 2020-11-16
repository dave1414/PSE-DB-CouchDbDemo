package de.kfru.pse.CouchDbDemo.uebung;

import java.io.IOException;

import de.kfru.pse.CouchDbDemo.CloudantConnector.StudentConnector;
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
    	
    	//TODO neuerStudent definieren
    	Student neuerStudent = new Student("", "", "", "", 0, null, 0, null);
    	//neuerStudent = new Student(matrikelnummer, "vorname", "nachname", "Bachelor Uni", note, new Address("Strasse", "Ort"), Semester, new String[]{"Kurs1", "Kurs2", "Kurs3"});
        
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
