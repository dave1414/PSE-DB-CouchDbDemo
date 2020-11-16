package de.kfru.pse.CouchDbDemo;

import java.io.IOException;

import de.kfru.pse.CouchDbDemo.CloudantConnector.ItemConnector;

public class demo5_delete {

	public static void main(String[] args) {
		ItemConnector itemConnector = null;
    	
    	try {
    		itemConnector = new ItemConnector();
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//delete cucumber
        try {
			itemConnector.deleteItem("cucumber");
			System.out.println( "Deleted cucumber");
        } catch (Exception e) {
			// Auto-generated catch block
        	System.out.println("Error deleting cucumber");
			e.printStackTrace();
		}

	}

}
