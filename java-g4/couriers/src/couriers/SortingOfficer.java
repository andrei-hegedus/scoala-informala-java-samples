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
		try {
			// for (String p : packageQueue) {
			while (true) {
				String p;
				synchronized (packageQueue) {
					if (packageQueue.isEmpty()) {
						packageQueue.wait();
					}
					p = packageQueue.remove();
					packageQueue.notify();
				}
				boolean packageShipped = false;
				do {
					for (DeliveryBox box : boxes) {
						synchronized (box) {
							if (!box.hasShippment()) {
								System.out.println("sorting officer - Adding " + p + " to delivery box " + box.getName());
								box.addShippment(p);
								packageShipped = true;
								box.notify();
								break;
							}
						}
					}
				} while (!packageShipped);

			}
		} catch (Exception e) {

		}
	}

}
