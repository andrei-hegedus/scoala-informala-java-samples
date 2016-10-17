package couriers;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		LinkedList<String> queue = new LinkedList<>();
		
		ArrayList<DeliveryBox> boxes = new ArrayList<>();
		
		DeliveryCourier dc = new DeliveryCourier("courier1");
		dc.start();
		
		DeliveryCourier dc2 = new DeliveryCourier("courier2");
		dc2.start();
		
		boxes.add(dc.getBox());
		boxes.add(dc2.getBox());
		
		SortingOfficer so = new SortingOfficer(queue, boxes);
		so.start();
		
		PickupCourier pc = new PickupCourier(queue);
		pc.start();
	}

}
