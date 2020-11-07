package de.kfru.pse.CouchDbDemo.CloudantConnector;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.ini4j.InvalidFileFormatException;
import org.ini4j.Wini;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;

public class CloudantConnector {
	
	private CloudantClient client;
	
	/**
	 * liest die Konfiguration aus der config/config.ini Datei aus und erstellt eine Verbindung zur dort definierten Cloudant Instanz
	 * @throws InvalidFileFormatException wenn die Konfigurationsdatei fehlerhaft ist
	 * @throws IOException wenn der Inhalt der Date fehlerhaft ist, also z.B. die URL
	 */
	public CloudantConnector() throws InvalidFileFormatException, IOException {
		//lese die Konfiguratiosdatei aus
		Wini ini = new Wini(new File(this.getClass().getClassLoader().getResource("config.ini").getFile()));
        String url = ini.get("CLOUDANT", "URL");
        String apikey = ini.get("CLOUDANT", "APIKEY");
        
        //erstelle die Verbindung zu Cloudant
		client = ClientBuilder.url(new URL(url))
              .iamApiKey(apikey)
              .build();
	}
	
	/**
	 * liefert die angegebene Datenbankinstanz, um auf diese Abfragen durchzuführen
	 * @param databaseName der Name der Datenbank
	 * @return die Datenbank, auf die danach Abfragen durchgeführt werden kann
	 */
	public Database getDB(String databaseName) {
		return client.database(databaseName, false);
	}
	
	/**
	 * ermittelt die Version des Cloudant SDKs
	 * @return die Version des Cloudant SDKs
	 */
	public String version() {
		return client.serverVersion();
	}
	

}
