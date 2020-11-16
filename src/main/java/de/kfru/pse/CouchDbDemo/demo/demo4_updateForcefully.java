package de.kfru.pse.CouchDbDemo.demo;

import java.io.IOException;

import de.kfru.pse.CouchDbDemo.CloudantConnector.ItemConnector;
import de.kfru.pse.CouchDbDemo.Models.Item;
import de.kfru.pse.CouchDbDemo.Models.Region;

public class demo4_updateForcefully {

	public static void main(String[] args) {
		ItemConnector itemConnector = null;
    	
    	try {
    		itemConnector = new ItemConnector();
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//update cucumber forcefully
        try {
        	
        	Item cucumber = itemConnector.getItem("cucumber");
        	cucumber.setPrice(0.49);
        	itemConnector.updateItem(cucumber);
        	System.out.println( "Updated cucumber naturally");
        	
			itemConnector.updateItemForcefully(new Item("cucumber", 0.49, "vegetables", new Region("Spain", "Madrid"), new String[]{"Böblingen", "Berlin"}));
			System.out.println( "Updated cucumber forecfully");
        } catch (Exception e) {
			// Auto-generated catch block
        	System.out.println("Error updating cucumber forcefully");
			e.printStackTrace();
		}

	}

}
