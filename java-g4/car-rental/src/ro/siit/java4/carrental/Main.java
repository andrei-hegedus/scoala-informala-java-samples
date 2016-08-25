package ro.siit.java4.carrental;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
		CarRental carRental = new CarRental();
		Car [] cars = carRental.findCar(Car.SMALL_CAR);
		System.out.println(Arrays.toString(cars));
		// by whatever rules choose a car to rent
		Car chosenCar = cars[1];
		Offer offer = carRental.requestOffer(chosenCar, new TimeFrame(getDate(8, 15), getDate(8,  29)));
		// we like the offer
		Payment payment = new CreditCardPayment();
		carRental.rent(offer, payment);
	}
	
	private static Date getDate(int month, int day){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.MONTH, month);
		return calendar.getTime();
	}

}
