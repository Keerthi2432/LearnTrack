package com.airtribe.learntrack.entity;

public class Student extends Person{

	private String batch;
	private boolean active;
	
	
	public Student(int id, String firstName, String lastName, String email, String batch, boolean active) {
		super(id, firstName, lastName, email);
		this.batch = batch;
		this.active = active;
	}
	
	public Student(int id, String firstName, String lastName, String batch, boolean active) {
		super(id, firstName, lastName, null);
		
		this.batch = batch;
		this.active = active;
	}
	

	@Override
	public String getDisplayName() {
	    return "Student: " + firstName + " " + lastName;
	}
	
	@Override
	public String toString() {
		return "Student ["+ 
				"id=" + id +
				", name=" + firstName + " "+ lastName + '\''+
				 ", email=" + email +'\''+
				 ", batch=" + batch + '\''+
				", active =" + active + "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstName;
	}
	public void setFirstname(String firstname) {
		this.firstName = firstname;
	}
	public String getLastname() {
		return lastName;
	}
	public void setLastname(String lastname) {
		this.lastName = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	

}
