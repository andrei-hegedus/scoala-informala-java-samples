package couriers;

import java.util.List;
import java.util.Queue;

public class SortingOfficer extends Thread {

	private Queue<String> packageQueue;
	private List<DeliveryBox> boxes;

	public SortingOfficer(Queue<String> packageQueue, List<DeliveryBox> deliveryBox) {
		this.packageQueue = packageQueue;
		this.boxes = deliveryBox;
	}

	@Override
	public void run() {
		
	}

}
