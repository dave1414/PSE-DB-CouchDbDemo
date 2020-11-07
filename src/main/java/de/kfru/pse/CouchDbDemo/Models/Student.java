package de.kfru.pse.CouchDbDemo.Models;

import java.util.Arrays;

public class Student {

	private String _id;
	private String _rev;
	String firstName;
	String lastName;
	String bachelorUniversity;
	double bachelorGrade;
	Address address;
	private int semester;
	String[] courses;
	
	public Student(String _id, String firstName, String lastName, String bachelorUniversity, double bachelorGrade, Address address, int semester, String[] courses) {
		this._id = _id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.bachelorUniversity = bachelorUniversity;
		this.bachelorGrade = bachelorGrade;
		this.address = address;
		this.setSemester(semester);
		this.courses = courses;
	}
	
	public String toString() {
		return _id + "(" + lastName + ", " + firstName + "), " + address + ", finished with " + bachelorGrade + " at " + bachelorUniversity + ", is in semester " + getSemester() + " and visited " + Arrays.toString(courses); 
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

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}
	
	
	
}
