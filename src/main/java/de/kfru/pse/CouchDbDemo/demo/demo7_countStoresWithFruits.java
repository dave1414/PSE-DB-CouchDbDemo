package de.kfru.pse.CouchDbDemo.demo;

import java.io.IOException;

import de.kfru.pse.CouchDbDemo.CloudantConnector.ItemConnector;

public class demo7_countStoresWithFruits {
	public static void main(String[] args) {
		ItemConnector itemConnector = null;
    	
    	try {
    		itemConnector = new ItemConnector();
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//get number of stores with fruits from view
        try {
			Integer count = itemConnector.countStoresWithFruits();
			System.out.println("There are " + count + " stores with fruits");
		} catch (IOException e) {
			// Auto-generated catch block
			System.out.println("Error getting number of stores with fruits");
			e.printStackTrace();
		}

	}
}
