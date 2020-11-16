package de.kfru.pse.CouchDbDemo;

import java.io.IOException;
import java.util.ArrayList;

import de.kfru.pse.CouchDbDemo.CloudantConnector.ItemConnector;

public class demo9_fruitsFromBöblingenGeneric {
	public static void main(String[] args) {
		ItemConnector itemConnector = null;
    	
    	try {
    		itemConnector = new ItemConnector();
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//get all fruits sold in Böblingen generally from view
        try {
			ArrayList<String> fruitsInBoeblingen = itemConnector.getCategoriesPerStore("Böblingen", "fruit");
			System.out.println("Presenting fruits sold in Böblingen: ");
			for (String item : fruitsInBoeblingen) {
				System.out.println(item);
			}
		} catch (IOException e) {
			// Auto-generated catch block
			System.out.println("Error getting fruits sold in Böblingen");
			e.printStackTrace();
		}

	}
}
