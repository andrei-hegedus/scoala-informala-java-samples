package siit.java3.exceptions;

import java.util.HashMap;

public class ParkingTollBooth {

	private ParkingCarCatalog carCatalog;
	private HashMap<String, Integer> carEntry = new HashMap<>();

	public ParkingTollBooth(ParkingCarCatalog carCatalog) {
		super();
		this.carCatalog = carCatalog;
	}

	public void checkIn(int currentHour, String registrationNr) throws AccessDeniedException {
		try {
			carCatalog.validateCar(currentHour, registrationNr);
			carEntry.put(registrationNr, currentHour);
		} catch (NoSubscriptionException e) {
			throw new AccessDeniedException(e);
		} catch (OutsideAllowedHoursException e) {
			throw new AccessDeniedException(e);
		}
	}

	public float checkOut(int currentHour, String registrationNr) throws ParkingFeeException{
		Integer entryTime = 0;
		try {
			entryTime = carEntry.get(registrationNr);
			if (entryTime == null) {
				throw new ParkingFeeException("Illegal entry.", 5000);
			}
			carCatalog.validateCar(currentHour, registrationNr);
			return carCatalog.getPriceForHours(registrationNr, currentHour - entryTime);
		} catch (NoSubscriptionException e) {
			throw new ParkingFeeException("Your car is not registered with a subscription.", 5000);
		} catch (OutsideAllowedHoursException e) {
			float fee = carCatalog.getPriceForHours(registrationNr, currentHour - entryTime) + 500;
			throw new ParkingFeeException("You are leaving outside your allowed end-time.", fee);
		}
	}


}
