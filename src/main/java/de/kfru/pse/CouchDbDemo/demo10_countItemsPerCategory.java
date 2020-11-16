package de.kfru.pse.CouchDbDemo;

import java.io.IOException;
import java.util.Map;

import de.kfru.pse.CouchDbDemo.CloudantConnector.ItemConnector;

public class demo10_countItemsPerCategory {
	public static void main(String[] args) {
		ItemConnector itemConnector = null;
    	
    	try {
    		itemConnector = new ItemConnector();
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//get number of categories in all stores from view
        try {
        	Map<String,Integer> countOfItems = itemConnector.getCategoriesPerStoreCount();
        	System.out.println("Presenting number of items per category per store: ");
			for (String key : countOfItems.keySet()) {
				System.out.println(key + ": " + countOfItems.get(key));
			}
		} catch (IOException e) {
			// Auto-generated catch block
			System.out.println("Error getting fruits sold in Böblingen");
			e.printStackTrace();
		}

	}
}
