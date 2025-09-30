package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String gender;
	private String email;
	private long phoneno;

	@OneToOne
	private Aadhar aadhar;
	
	public Aadhar getAadhar() {
		return aadhar;	
	}
	
	public void setAadhar(Aadhar aadhar) {
		this.aadhar = aadhar;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}
	
	@Override
	public String toString() {
		return "Person: [ Id: " + id + ", Name: " + name + ", Gender: " + gender + ", Email: " + email + ", Phone Number: " + phoneno + "]";
	}
	
	
	
}
