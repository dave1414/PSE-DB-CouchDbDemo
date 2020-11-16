package de.kfru.pse.CouchDbDemo;

import java.io.IOException;

import de.kfru.pse.CouchDbDemo.CloudantConnector.ItemConnector;
import de.kfru.pse.CouchDbDemo.Models.Item;
import de.kfru.pse.CouchDbDemo.Models.Region;

public class demo3_update {

	public static void main(String[] args) {
		ItemConnector itemConnector = null;
    	
    	try {
    		itemConnector = new ItemConnector();
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//update cucumber
        try {
			itemConnector.updateItem(new Item("cucumber", 0.99, "vegetables", new Region("Spain", "Madrid"), new String[]{"Böblingen", "Berlin"}));
			System.out.println( "Updated cucumber");
        } catch (Exception e) {
			// Auto-generated catch block
        	System.out.println("Error updating cucumber");
			e.printStackTrace();
		}

	}

}
