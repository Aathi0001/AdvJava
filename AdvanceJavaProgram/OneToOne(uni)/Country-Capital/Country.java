package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Country {
	@Id
	private	int CountryId;
	private String CountryName;
	
	@OneToOne
	private Capital c;
	
	
	public Country() {}
	public Country(int countryId, String countryName, Capital c) {
		super();
		CountryId = countryId;
		CountryName = countryName;

		this.c = c;
	}
	
	public int getCountryId() {
		return CountryId;
	}
	public void setCountryId(int countryId) {
		CountryId = countryId;
	}
	public String getCountryName() {
		return CountryName;
	}
	public void setCountryName(String countryName) {
		CountryName = countryName;
	}
	public Capital getC() {
		return c;
	}
	public void setC(Capital c) {
		this.c = c;
	}
	@Override
	public String toString() {
		return "Country [CountryId=" + CountryId + ", CountryName=" + CountryName + ", c="
				+ c + "]";
	}
	
	
}
