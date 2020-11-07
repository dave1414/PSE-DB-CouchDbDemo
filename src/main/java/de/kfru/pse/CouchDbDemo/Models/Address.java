package de.kfru.pse.CouchDbDemo.Models;

public class Address {
	String street;
	String city;
	
	/**
	 * Konstruktor
	 * @param street die Straße mitsamt Hausnummer
	 * @param city die Stadt
	 */
	public Address(String street, String city) {
		this.street = street;
		this.city = city;
	}
	
	public String toString() {
		return street + " in " + city;
	}

}
