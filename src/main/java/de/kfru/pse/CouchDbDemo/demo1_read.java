package de.kfru.pse.CouchDbDemo;

import java.io.IOException;

import de.kfru.pse.CouchDbDemo.CloudantConnector.ItemConnector;
import de.kfru.pse.CouchDbDemo.CloudantConnector.StudentConnector;

public class demo1_read {

	public static void main(String[] args) {
		ItemConnector itemConnector = null;
    	
    	try {
    		itemConnector = new ItemConnector();
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//get apple
        try {
        	 System.out.println( "Apfel: " + itemConnector.getItem("apple"));
        } catch (Exception e) {
			// Auto-generated catch block
        	System.out.println("Error getting apple");
			e.printStackTrace();
		}
	}

}
