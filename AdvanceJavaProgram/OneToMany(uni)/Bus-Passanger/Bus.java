package com.example;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Bus {

	@Id
	private String busNo;
	private String name;
	private int noOfSeats;
	private String type;
	private double price;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Passanger> passangers;
	
	
	public  void  addPassanger(Passanger p) {
		passangers.add(p);
	}
	
	
	public  void  removePassanger(Passanger p) {
		passangers.remove(p);
	}

	public String getBusNo() {
		return busNo;
	}

	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Passanger> getPassangers() {
		return passangers;
	}

	public void setPassangers(List<Passanger> passangers) {
		this.passangers = passangers;
	}

}
