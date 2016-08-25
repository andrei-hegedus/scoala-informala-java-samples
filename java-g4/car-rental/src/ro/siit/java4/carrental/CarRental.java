package ro.siit.java4.carrental;

public class CarRental {

	private Car [] cars;
	
	public CarRental() {
		cars = new Car[7];
		cars[0] = new Car("Mini One", Car.SMALL_CAR);
		cars[1] = new Car("Fiat 500", Car.SMALL_CAR);
		cars[2] = new Car("Ford Mondeo", Car.LARGE_CAR);
		cars[3] = new Car("VW Golf", Car.MEDIUM_CAR);
		cars[4] = new Car("Audi A1", Car.SMALL_CAR);
		cars[5] = new Car("Mercedes S600", Car.LARGE_CAR);
		cars[6] = new Car("VW Transporter", Car.TRUCK);
	}
	
	public Car[] findCar(String size) {
		Car[] results;
		int nrOfCars = 0;
		for(Car car : cars){
			if(size.equals(car.getSize())){
				nrOfCars++;
			}
		}
		results = new Car[nrOfCars];
		int index = 0;
		for(Car car : cars){
			if(size.equals(car.getSize())){
				results[index++] = car;
			}
		}
		return results;
	}

	public Offer requestOffer(Car chosenCar, TimeFrame timeFrame) {
		// TODO implement this
		return null;
	}

	public void rent(Offer offer, Payment payment) {
		// TODO implement this
		
	}

}
