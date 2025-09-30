package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Aadhar {
	
	@Id
	private long aadhar_no;
	private String fathar_name;
	private String address;
	private String dob;
	
	@OneToOne
	private Person person;
	
	


	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public long getAadhar_no() {
		return aadhar_no;
	}
	public void setAadhar_no(long aadhar_no) {
		this.aadhar_no = aadhar_no;
	}
	public String getFathar_name() {
		return fathar_name;
	}
	public void setFathar_name(String fathar_name) {
		this.fathar_name = fathar_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "Aadhar [aadhar_no=" + aadhar_no + ", fathar_name=" + fathar_name + ", address=" + address + ", dob="
				+ dob + "]";
	}
	
	

}
