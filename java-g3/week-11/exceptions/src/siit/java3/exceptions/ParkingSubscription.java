package siit.java3.exceptions;

public class ParkingSubscription {
	private int startHour;
	private int endHour;
	private float pricePerHour;

	public ParkingSubscription(int startHour, int endHour, float pricePerHour) {
		this.startHour = startHour;
		this.endHour = endHour;
		this.pricePerHour = pricePerHour;
	}

	public int getStartHour() {
		return startHour;
	}

	public int getEndHour() {
		return endHour;
	}

	public float getPricePerHour() {
		return pricePerHour;
	}

}