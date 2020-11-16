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
    	
    	Student neuerStudent = new Student("86734", "Michael", "Klose", "Technische Universität München", 1.3, new Address("Garagenstraße", "München"), 1, new String[]{"DB"});
        
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
