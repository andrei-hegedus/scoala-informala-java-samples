package siit.java3.exceptions;

public class ParkingFeeException extends Exception {
	
	private float fee;

	public ParkingFeeException(String reason, float fee) {
		super(reason);
		this.fee = fee;
	}
	
	public float getFee() {
		return fee;
	}

}
