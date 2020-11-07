package de.kfru.pse.CouchDbDemo.Models;

import java.util.Arrays;

public class Item {
	
	private String _id;
	private String _rev;
	double price;
	String category;
	Region origin;
	String[] stores;
	
	public Item(String _id, double price, String category, Region origin, String[] stores) {
		this.set_id(_id);
		this.price = price;
		this.origin = origin;
		this.stores = stores;
		this.category = category;
	}
	
	public String toString() {
		return get_id() + " (" + category + ") in revision " + get_rev() + " for " + price + "€ from " + origin + " sold in " + Arrays.toString(stores);
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String get_rev() {
		return _rev;
	}

	public void set_rev(String _rev) {
		this._rev = _rev;
	}

}
