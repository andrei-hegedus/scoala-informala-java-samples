package siit.java3.exceptions;


public class Main {

	public static void main(String[] args) throws AccessDeniedException {
		ParkingCarCatalog carCatalog = new ParkingCarCatalog();
		String bos = "CJ 69 BOS";
		carCatalog.registerCar(bos, new ParkingSubscription(7, 18, 1));
		//carCatalog.registerCar("CJ 69 BOS", null);
		ParkingTollBooth booth = new ParkingTollBooth(carCatalog);
		booth.checkIn(8, bos);
		try{
			//float toPay = booth.checkOut(19, "CJ 61 UCI");
			float toPay = booth.checkOut(19, bos);
			System.out.println("parking fee: "+toPay);
		} catch(ParkingFeeException e){
			System.out.println("You have penalties. Reason: "+e.getMessage()+", Fee: "+e.getFee());
		}
	}

	

}
