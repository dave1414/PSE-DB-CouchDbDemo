package de.kfru.pse.CouchDbDemo.CloudantConnector;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ini4j.InvalidFileFormatException;

import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Response;
import com.cloudant.client.api.views.Key;
import com.cloudant.client.api.views.Key.ComplexKey;
import com.cloudant.client.api.views.ViewRequest;
import com.cloudant.client.api.views.ViewRequestBuilder;
import com.cloudant.client.api.views.ViewResponse;

import de.kfru.pse.CouchDbDemo.Models.Item;

public class ItemConnector {
	
	CloudantConnector client;
	Database db;
	
	/**
	 * Konstuktor
	 * @throws InvalidFileFormatException wenn die URL in der Konfigurationsdatei ungültig ist
	 * @throws IOException wenn die Konifgurationsdatei nicht eingelesen werden kann
	 */
	public ItemConnector() throws InvalidFileFormatException, IOException {
		client = new CloudantConnector();
		this.db = client.getDB("pse_store");
		
	}
	
	/**
	 * gibt die Version vom CloudantSDK aus, mit dem auf die Datenbank zugegriffen wird
	 * @return die Version
	 */
	public String version() {
		return client.version();
	}
	
	/**
	 * READ Operation für ein Item
	 * @param itemName der name des items (entspricht der _id in der Datenbank)
	 * @return das Item, wie es in der Datenbank steht
	 */
	public Item getItem(String itemName) {
		Item doc = db.find(Item.class, itemName);
		return doc;
	}
	
	/**
	 * CREATE Operation für ein Item
	 * @param item das item, das erstellt werden soll
	 * @return true, wenn die Speicherung erfolgreich war
	 */
	public boolean saveItem(Item item) {
		Response resp = db.save(item);
		return true;
	}
	
	/**
	 * UPDATE Operation für ein Item
	 * @param item das item, das geupdated werden soll. Annahme ist, dass die _rev korrekt gesetzt ist 
	 * @return true, wenn erfolgreich gespeichert wurde
	 */
	public boolean updateItem(Item item){
		Response resp = db.update(item);
		return true;
	}
	
	/**
	 * UPDATE Operation für ein Item, nur dass die _rev vorher ausgelesen und aktualisiert wird -> übersschreibt potenzielle Änderungen in der DB (Lost Update Problematik)
	 * @param item das item, das geupdated werden soll
	 * @return true, wenn erfolgreich gespeichert wurde
	 */
	public boolean updateItemForcefully(Item item){
		Item storedItem = this.getItem(item.get_id());
		item.set_rev(storedItem.get_rev());
		return this.updateItem(item);
	}
	
	/**
	 * DELETE Operation, löscht ein Item aus der Datenbank
	 * @param itemname der name des items, entspricht dem _id Attriut in der Datenbank
	 * @return true, wenn erfolgreich gelöscht wurde
	 */
	public boolean deleteItem(String itemname) {
		Item item = db.find(Item.class, itemname);
		Response response = db.remove(item);
		return true;
	}
	
	/**
	 * liefert alle Früchte, die in der Datenbank gespeichert sind
	 * @return eine ArrayList mit allen Früchten in der DB
	 * @throws IOException wenn ein Fehler auftritt
	 */
	public ArrayList<Item> getAllFruits() throws IOException{
		//get a ViewRequestBuilder from the database for the chosen view
		 ViewRequestBuilder viewBuilder = db.getViewRequestBuilder("fruits", "allFruits");

		 //build a new request and specify any parameters required
		 ViewRequest<String, Item> request = viewBuilder.newRequest(Key.Type.STRING, Item.class)
		 .build();

		 //perform the request and get the response
		 ViewResponse<String, Item> response = request.getResponse();

		 //loop through the rows of the response
		 ArrayList<Item> allFruits = new ArrayList<Item>();
		 for (ViewResponse.Row<String, Item> row : response.getRows()) {
			 Item item = row.getValue();
			 allFruits.add(item);
		 }
		 return allFruits;
	}
	
	/**
	 * liefert die Anzahl aller Stores, die Früchte verkaufen
	 * @return die Anzahl aller Stores, die Früchte verkaufen
	 * @throws IOException wenn ein Fehler auftritt
	 */
	public Integer countStoresWithFruits() throws IOException {
		//get a ViewRequestBuilder from the database for the chosen view
		 ViewRequestBuilder viewBuilder = db.getViewRequestBuilder("fruits", "countStoresWithFruits");

		 //build a new request and specify any parameters required
		 ViewRequest<String, Integer> request = viewBuilder.newRequest(Key.Type.STRING, Integer.class)
		 .build();

		 //perform the request and get the response
		 ViewResponse<String, Integer> response = request.getResponse();
		 
		 List<Integer> values = response.getValues();
		 
		 return values.get(0);
		 
	}
	
	/**
	 * liefert die Früchte, die in einem bestimmten Laden verkauft werden
	 * @param store der Laden, für den die verkauften Früchte ermittelt werden sollen
	 * @return Eine Liste mit den Namen der Läden, in denen Früchte verkauft werden
	 * @throws IOException falls ein Fehler auftritt
	 */
	public ArrayList<String> getFruitsSoldIn(String store) throws IOException {
		//get a ViewRequestBuilder from the database for the chosen view
		 ViewRequestBuilder viewBuilder = db.getViewRequestBuilder("fruits", "fruitsByStore");

		 //build a new request and specify any parameters required
		 ViewRequest<String, String> request = viewBuilder.newRequest(Key.Type.STRING, String.class)
		 .keys(store)
		 .build();

		//perform the request and get the response
		 ViewResponse<String, String> response = request.getResponse();

		 //loop through the rows of the response
		 ArrayList<String> fruits = new ArrayList<String>();
		 for (ViewResponse.Row<String, String> row : response.getRows()) {
			 String fruit = row.getValue();
			 fruits.add(fruit);
		 }
		 return fruits;
	}
	
	/**
	 * liefert alle Items einer bestimmten Kategorie in einem bestimmten Laden
	 * @param store der Laden in dem die items verkauft werden müssen
	 * @param category die Kategorie aller items, die geliefert werden sollen
	 * @return Eine Liste mit den Namen der Items, die zu der kategorie gehören und im entsprechenden Laden verkauft werden
	 * @throws IOException falls ein Fehler auftritt
	 */
	public ArrayList<String> getCategoriesPerStore(String store, String category) throws IOException {
		//get a ViewRequestBuilder from the database for the chosen view
		 ViewRequestBuilder viewBuilder = db.getViewRequestBuilder("fruits", "categoryByStore");

		 //build a new request and specify any parameters required
		 ComplexKey searchKey = Key.complex(store).add(category);
		 ViewRequest<ComplexKey, String> request = viewBuilder.newRequest(Key.Type.COMPLEX, String.class)
		 .keys(searchKey)
		 .build();

		//perform the request and get the response
		 ViewResponse<ComplexKey, String> response = request.getResponse();

		 //loop through the rows of the response
		 ArrayList<String> fruits = new ArrayList<String>();
		 for (ViewResponse.Row<ComplexKey, String> row : response.getRows()) {
			 String fruit = row.getValue();
			 fruits.add(fruit);
		 }
		 return fruits;
	}
	
	/**
	 * liefert die Anzahl der Items für alle Kategorien und Läden
	 * @return ein Hashmap, die für jede Kombination aus Kategorie und Laden die Anzahl der Items enthält
	 * @throws IOException falls ein Fehler auftritt
	 */
	public Map<String,Integer> getCategoriesPerStoreCount() throws IOException {
		//get a ViewRequestBuilder from the database for the chosen view
		 ViewRequestBuilder viewBuilder = db.getViewRequestBuilder("fruits", "categoryByStoreCount");

		 //build a new request and specify any parameters required
		 ViewRequest<ComplexKey, Integer> request = viewBuilder.newRequest(Key.Type.COMPLEX, Integer.class)
		 .groupLevel(2)
		 .build();

		//perform the request and get the response
		 ViewResponse<ComplexKey, Integer> response = request.getResponse();

		 Map<String,Integer> map = new HashMap<String,Integer>();
		 for (ViewResponse.Row<ComplexKey, Integer> row : response.getRows()) {
			 map.put(row.getKey().toJson(), row.getValue());
		 }
		 
		 return map;
	}

}
