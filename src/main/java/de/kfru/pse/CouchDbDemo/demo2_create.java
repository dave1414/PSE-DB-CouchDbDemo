package de.kfru.pse.CouchDbDemo;

import java.io.IOException;

import de.kfru.pse.CouchDbDemo.CloudantConnector.ItemConnector;
import de.kfru.pse.CouchDbDemo.Models.Item;
import de.kfru.pse.CouchDbDemo.Models.Region;

public class demo2_create {

	public static void main(String[] args) {
		ItemConnector itemConnector = null;
    	
    	try {
    		itemConnector = new ItemConnector();
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//create cucumber
        try {
			itemConnector.saveItem(new Item("cucumber", 0.99, "vegetables", new Region("Spain", "Madrid"), new String[]{"Böblingen", "Berlin"}));
			System.out.println( "Saved cucumber");
        } catch (Exception e) {
			// Auto-generated catch block
        	System.out.println("Error saving cucumber");
			e.printStackTrace();
		}

	}

}
