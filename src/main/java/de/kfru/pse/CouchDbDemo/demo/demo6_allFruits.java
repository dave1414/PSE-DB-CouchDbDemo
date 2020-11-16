package de.kfru.pse.CouchDbDemo.demo;

import java.io.IOException;
import java.util.ArrayList;

import de.kfru.pse.CouchDbDemo.CloudantConnector.ItemConnector;
import de.kfru.pse.CouchDbDemo.Models.Item;

public class demo6_allFruits {

	public static void main(String[] args) {
		ItemConnector itemConnector = null;
    	
    	try {
    		itemConnector = new ItemConnector();
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//get all fruits from view
        try {
			ArrayList<Item> allFruits = itemConnector.getAllFruits();
			System.out.println("Presenting all fruits: ");
			for (Item item : allFruits) {
				System.out.println(item);
			}
		} catch (IOException e) {
			// Auto-generated catch block
			System.out.println("Error getting all fruits");
			e.printStackTrace();
		}

	}

}
