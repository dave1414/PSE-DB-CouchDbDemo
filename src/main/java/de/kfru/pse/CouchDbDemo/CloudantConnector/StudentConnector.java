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
import com.cloudant.client.api.views.ViewRequest;
import com.cloudant.client.api.views.ViewRequestBuilder;
import com.cloudant.client.api.views.ViewResponse;
import com.cloudant.client.api.views.Key.ComplexKey;

import de.kfru.pse.CouchDbDemo.Models.Item;
import de.kfru.pse.CouchDbDemo.Models.Student;

public class StudentConnector {
	
	CloudantConnector client;
	Database db;
	
	/**
	 * Konstuktor
	 * @throws InvalidFileFormatException wenn die URL in der Konfigurationsdatei ungültig ist
	 * @throws IOException wenn die Konifgurationsdatei nicht eingelesen werden kann
	 */
	public StudentConnector() throws InvalidFileFormatException, IOException {
		client = new CloudantConnector();
		this.db = client.getDB("pse-university");
		
	}
	
	/**
	 * gibt die Version vom CloudantSDK aus, mit dem auf die Datenbank zugegriffen wird
	 * @return die Version
	 */
	public String version() {
		return client.version();
	}
	
	/**
	 * READ Operation für einen Studenten
	 * @param studentName der name des Studenten (entspricht der _id in der Datenbank)
	 * @return der Student, wie er in der Datenbank steht
	 */
	public Student getStudent(String studentName) {
		//TODO Datenbankoperation implementieren
		return new Student("", "", "", "", 0, null, 0, new String[]{"", ""});
	}
	
	/**
	 * CREATE Operation für einen Studenten
	 * @param student der Student, der erstellt werden soll
	 * @return true, wenn die Speicherung erfolgreich war
	 */
	public boolean saveStudent(Student student) {
		//TODO Datenbankoperation implementieren
		return true;
	}
	
	/**
	 * UPDATE Operation für einen Studenten
	 * @param student der Student, der geupdated werden soll. Annahme ist, dass die _rev korrekt gesetzt ist 
	 * @return true, wenn erfolgreich gespeichert wurde
	 */
	public boolean updateStudent(Student student) throws Exception {
		//TODO Datenbankoperation implementieren
		return true;
	}
	
	/**
	 * Liefert die Anzahl aller Studenten, die sich in einem bestimmten Semester befinden
	 * @param semester das entsprechende Semester
	 * @return die Anzahl der Studenten im entsprechenden Semester
	 * @throws IOException falls ein Fehler eintritt
	 */
	public int getStudentsInSemesterCount(int semester) throws IOException {
		//TODO Datenbankoperation implementieren
		return 0;
	}
	
	/**
	 * liefert alle Studenten, die ihren Bachelor an der angegebenen Uni gemacht haben
	 * @param bachelorUniversity die Universität des Bachelors. Prüft nicht auf genau den String, sonder nur dass er damit anfängt.
	 * @return eine Liste mit allen Studente, die ihren Bachelorabschluss an der entsprechenden Universität gemacht haben
	 * @throws IOException
	 */
	public ArrayList<Student> getAllStudentsWithBachelorAt(String bachelorUniversity) throws IOException {
		//TODO Datenbankoperation implementieren
		return null;
	}
	
	/**
	 * liefert alle Studenten, die ein bestimmtes Module besucht haben
	 * @param module der name des moduls
	 * @return eine Liste mit allen Studenten, die ein bestimtes Modul besucht haben
	 * @throws IOException falls ein Fehler auftritt
	 */
	public ArrayList<Student> getStudentsByModule(String module) throws IOException {
		//TODO Datenbankoperation implementieren
		return null;
	}
	
	/**
	 * Anzahl der Studenten, die an einem bestimmten Modul teilnehmen udn besser sind als die gegebene Note
	 * @param modul das Modul, in dem die Studenten sein müssen
	 * @param grade die Note, die mindestens erreicht worden sein muss
	 * @return die Anzahl der Studenten, die besser als die gegebene Note und im gegebenen Modul sind
	 * @throws IOException falls ein Fehelr auftritt
	 */
	public int getStudentCountPerModuleBetterThan(String modul, int grade) throws IOException {
		//TODO Datenbankoperation implementieren
		return 0;
	}

}
