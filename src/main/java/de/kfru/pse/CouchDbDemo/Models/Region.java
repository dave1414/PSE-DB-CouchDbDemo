package de.kfru.pse.CouchDbDemo.Models;

public class Region {
	String country;
	String region;
	
	public Region(String country, String region) {
		this.country = country;
		this.region = region;
	}
	
	
	public String toString() {
		return region + " in " + country;
	}

}
