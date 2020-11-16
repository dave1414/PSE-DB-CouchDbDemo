package de.kfru.pse.CouchDbDemo;

import java.io.IOException;

import de.kfru.pse.CouchDbDemo.CloudantConnector.ItemConnector;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ItemConnector itemConnector = null;
    	
    	try {
    		itemConnector = new ItemConnector();
    		itemConnector.getAllFruits();
    		System.out.println("Verbindung funktioniert");
		} catch (IOException e) {
			// Auto-generated catch block
			System.out.println("Verbindung funktioniert nicht");
		}
    	 
    }
}
