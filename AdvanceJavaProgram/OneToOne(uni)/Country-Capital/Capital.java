package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Capital {
	
	@Id
	private	int CapitalId;
	private String CapitalName;
	
	public Capital() {}
	
	public Capital(int capitalId, String capitalName) {
		super();
		CapitalId = capitalId;
		CapitalName = capitalName;
	}
	
	public int getCapitalId() {
		return CapitalId;
	}
	public void setCapitalId(int capitalId) {
		CapitalId = capitalId;
	}
	public String getCapitalName() {
		return CapitalName;
	}
	public void setCapitalName(String capitalName) {
		CapitalName = capitalName;
	}
	
	@Override
	public String toString() {
		return "Capital [CapitalId=" + CapitalId + ", CapitalName=" + CapitalName + "]";
	}
	
	
	
}
