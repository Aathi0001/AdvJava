package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Bike {
	@Id
	private String No;
	private String Color;
	private double Price;
	private String Brand;
	private String Model;
	
	@OneToOne
	private Engine engine;

	public String getNo() {
		return No;
	}

	public void setNo(String no) {
		No = no;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	@Override
	public String toString() {
		return "Bike [No=" + No + ", Color=" + Color + ", Price=" + Price + ", Brand=" + Brand + ", Model=" + Model
				+ ", engine=" + engine + "]";
	}
	
	

}
