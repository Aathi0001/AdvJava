package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Engine {
	@Id
	private String Engine_no;
	private int CC;
	private int Stroke;
	private String Type;
	
	
	public String getEngine_no() {
		return Engine_no;
	}
	public void setEngine_no(String engine_no) {
		Engine_no = engine_no;
	}
	public int getCC() {
		return CC;
	}
	public void setCC(int cC) {
		CC = cC;
	}
	public int getStroke() {
		return Stroke;
	}
	public void setStroke(int stroke) {
		Stroke = stroke;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		this.Type = type;
	}
	@Override
	public String toString() {
		return "Engine [Engine_no=" + Engine_no + ", CC=" + CC + ", Stroke=" + Stroke + ", Type=" + Type + "]";
	}
	
	

}
