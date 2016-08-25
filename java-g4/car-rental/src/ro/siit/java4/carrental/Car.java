package ro.siit.java4.carrental;

public class Car {

	public static final String SMALL_CAR = "SMALL_CAR";
	public static final String MEDIUM_CAR = "MEDIUM_CAR";
	public static final String LARGE_CAR = "LARGE_CAR";
	public static final String TRUCK = "TRUCK";
	
	private String name;
	private String size;
	
	
	public Car(String name, String size) {
		this.name = name;
		this.size = size;
	}


	public String getSize() {
		return size;
	}


	@Override
	public String toString() {
		return "Car [name=" + name + ", size=" + size + "]";
	}
	
	

}
