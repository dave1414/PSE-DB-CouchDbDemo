package de.kfru.pse.CouchDbDemo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import de.kfru.pse.CouchDbDemo.CloudantConnector.ItemConnector;
import de.kfru.pse.CouchDbDemo.CloudantConnector.StudentConnector;
import de.kfru.pse.CouchDbDemo.Models.Address;
import de.kfru.pse.CouchDbDemo.Models.Item;
import de.kfru.pse.CouchDbDemo.Models.Region;
import de.kfru.pse.CouchDbDemo.Models.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ItemConnector itemConnector = null;
    	StudentConnector studentConnector = null;
    	
    	try {
    		itemConnector = new ItemConnector();
//    		fruitsDemo(itemConnector);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	try {
    		studentConnector = new StudentConnector();
    		studentsAufgabe(studentConnector);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
        
        
    }
    
    /**
     * alle Aufrufe zur Demonstration der Hands-On Session
     * @param itemConnector der Wrapper für die Verbindung zur Datenbank
     */
    public static void fruitsDemo(ItemConnector itemConnector) {
    	//get version
        System.out.println( "Version: " + itemConnector.version() );
        
        //get item
        try {
        	 System.out.println( "Apfel: " + itemConnector.getItem("apple"));
        } catch (Exception e) {
			// TODO Auto-generated catch block
        	System.out.println("Error saving cucumber");
			e.printStackTrace();
		}
       
        
        //save item
        try {
			itemConnector.saveItem(new Item("cucumber", 0.99, "vegetables", new Region("Spain", "Madrid"), new String[]{"Böblingen", "Berlin"}));
			System.out.println( "Saved cucumber");
        } catch (Exception e) {
			// TODO Auto-generated catch block
        	System.out.println("Error saving cucumber");
			e.printStackTrace();
		}
        
        //update item
        try {
			itemConnector.updateItem(new Item("cucumber", 0.99, "vegetables", new Region("Spain", "Madrid"), new String[]{"Böblingen", "Berlin"}));
			System.out.println( "Updated cucumber forecfully");
        } catch (Exception e) {
			// TODO Auto-generated catch block
        	System.out.println("Error updating cucumber");
			e.printStackTrace();
		}
        
       //update item forcefully
        try {
			itemConnector.updateItemForcefully(new Item("cucumber", 0.49, "vegetables", new Region("Spain", "Madrid"), new String[]{"Böblingen", "Berlin"}));
			System.out.println( "Updated cucumber forecfully");
        } catch (Exception e) {
			// TODO Auto-generated catch block
        	System.out.println("Error updating cucumber forcefully");
			e.printStackTrace();
		}
        
        //delete item
        try {
			itemConnector.deleteItem("cucumber");
			System.out.println( "Deleted cucumber");
        } catch (Exception e) {
			// TODO Auto-generated catch block
        	System.out.println("Error deleting cucumber");
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
			// TODO Auto-generated catch block
			System.out.println("Error getting all fruits");
			e.printStackTrace();
		}
        
        //get number of stores with fruits from view
        try {
			Integer count = itemConnector.countStoresWithFruits();
			System.out.println("There are " + count + " stores with fruits");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error getting number of stores with fruits");
			e.printStackTrace();
		}
        
        //get all fruits sold in Böblingen from view
        try {
			ArrayList<String> fruitsInBoeblingen = itemConnector.getFruitsSoldIn("Böblingen");
			System.out.println("Presenting fruits sold in Böblingen: ");
			for (String item : fruitsInBoeblingen) {
				System.out.println(item);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error getting fruits sold in Böblingen");
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
			// TODO Auto-generated catch block
			System.out.println("Error getting fruits sold in Böblingen");
			e.printStackTrace();
		}
        
        //get number of categories in all stores from view
        try {
        	Map<String,Integer> countOfItems = itemConnector.getCategoriesPerStoreCount();
        	System.out.println("Presenting number of items per category per store: ");
			for (String key : countOfItems.keySet()) {
				System.out.println(key + ": " + countOfItems.get(key));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error getting fruits sold in Böblingen");
			e.printStackTrace();
		}
    }

    /**
     * alle Aufrufe für die Übung
     * @param studentConnector der Wrapper für die Verbidnung zur Datenbank
     */
    public static void studentsAufgabe(StudentConnector studentConnector) {
    	
        //1. Neuen Studenten erstellen
    	String matrikelnummer = "65734";
    	Student neuerStudent = new Student(matrikelnummer, "William", "Gerstil", "DHBW Karlsruhe", 1.5, new Address("Schleierstraße 746", "Dresden"), 7, new String[]{"DB", "BD", "MTTP"});
        try {
        	studentConnector.saveStudent(neuerStudent);
			System.out.println( "Saved new student " + neuerStudent);
        } catch (Exception e) {
			// TODO Auto-generated catch block
        	System.out.println("Error saving new student");
			e.printStackTrace();
		}
        
        //2. Den eigenen Studenten wieder auslesen
        Student meinStudent = studentConnector.getStudent(matrikelnummer);
        System.out.println( "Mein Student: " + meinStudent);
        
        //3. Den eigenen Studenten ändern
        try {
        	meinStudent.setSemester(8);
        	studentConnector.updateStudent(meinStudent);
			System.out.println( "Updated " + meinStudent);
        } catch (Exception e) {
			// TODO Auto-generated catch block
        	System.out.println("Error updating " + meinStudent);
			e.printStackTrace();
		}
        
        //4. Studenten, die ihren Bachelor an der DHBW Stuttgart gemacht haben
        try {
        	ArrayList<Student> allStudentsfromDHBW = studentConnector.getAllStudentsWithBachelorAt("DHBW Stuttgart");
			System.out.println("Zeige alle Studenten die von der DHBW Stuttgart kommen an: ");
        	for (Student student : allStudentsfromDHBW) {
				System.out.println("- " + student);
			}
        } catch (Exception e) {
			// TODO Auto-generated catch block
        	System.out.println("Error getting all students coming from DHBW");
			e.printStackTrace();
		}
        
        //5. Anzahl der Studenten auslesen, die im zweiten Semester sind
        try {
        	int allStudentsInSemester2Count = studentConnector.getStudentsInSemesterCount(2);
			System.out.println("Zeige Anzahl alle Studenten im zweiten Semester an: " + allStudentsInSemester2Count);
        	
        } catch (Exception e) {
			// TODO Auto-generated catch block
        	System.out.println("Error getting number of students in semester 2");
			e.printStackTrace();
		}
        
        //6. Alle Studenten, die das Modul DB belegt haben
        try {
        	ArrayList<Student> allStudentsWhoVisitedDB = studentConnector.getStudentsByModule("DB");
			System.out.println("Zeige alle Studenten die DB besucht haben: ");
        	for (Student student : allStudentsWhoVisitedDB) {
				System.out.println("- " + student);
			}
        } catch (Exception e) {
			// TODO Auto-generated catch block
        	System.out.println("Error getting all students who visited DB");
			e.printStackTrace();
		}
        
        //7. Anzahl der Studenten im Modul DB, die im Bachelor besser als 2.0 waren
        try {
        	int countOfStudents = studentConnector.getStudentCountPerModuleBetterThan("DB", 2);
        	System.out.println("Presenting number of students in DB better than 2.0: " + countOfStudents);
        } catch (Exception e) {
			// TODO Auto-generated catch block
        	System.out.println("Error getting all students who visited DB");
			e.printStackTrace();
		}
    	
    }

}
