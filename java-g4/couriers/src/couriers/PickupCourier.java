package couriers;

import java.util.Queue;

public class PickupCourier extends Thread {
	
	private Queue<String> packageQueue;

	public PickupCourier(Queue<String> packageQueue) {
		this.packageQueue = packageQueue;
	}
	
	@Override
	public void run() {
		
	}

}
