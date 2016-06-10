package siit.java3.exceptions;

import java.util.HashMap;


public class ParkingCarCatalog {
	// <Registration-nr, Subscription
	private HashMap<String, ParkingSubscription> registeredCars = new HashMap<>();

	public void registerCar(String registrationNr, ParkingSubscription subscription) {
		registeredCars.put(registrationNr, subscription);
	}

	public float getPriceForHours(String registrationNr, int hours) {
		return registeredCars.get(registrationNr).getPricePerHour() * hours;
	}

	public void validateCar(int currentHour, String registrationNr)
			throws NoSubscriptionException, OutsideAllowedHoursException {
		ParkingSubscription subscription = registeredCars.get(registrationNr);
		if (subscription == null) {
			throw new NoSubscriptionException();
		}
		if (currentHour < subscription.getStartHour() || currentHour > subscription.getEndHour()) {
			throw new OutsideAllowedHoursException();
		}
	}

}