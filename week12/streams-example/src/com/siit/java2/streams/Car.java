package com.siit.java2.streams;

public class Car {
	
	private String manufacturer;
	private String model;
	private int year;
	
	public Car(String manufacturer, String model, int year) {
		super();
		this.manufacturer = manufacturer;
		this.model = model;
		this.year = year;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public String getModel() {
		return model;
	}
	public int getYear() {
		return year;
	}
	@Override
	public String toString() {
		return "Car [manufacturer=" + manufacturer + ", model=" + model + ", year=" + year + "]";
	}
	
}
