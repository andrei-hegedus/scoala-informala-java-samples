package couriers;

import java.util.Random;

public class DeliveryCourier extends Thread {

	private String name;
	private DeliveryBox box;
	private Random random = new Random();

	public DeliveryCourier(String name) {
		this.name = name;
		this.box = new DeliveryBox(name+" box");
	}

	@Override
	public void run() {
		try {
			while (true) {
				synchronized (box) {
					if (!box.hasShippment()) {
						box.wait();
					}
					Thread.sleep(random.nextInt(2000)+2000);
					String shippment = box.getShippment();
					System.out.println(name+" - Shipped "+shippment);
					box.notify();
				}
			}
		} catch (Exception e) {

		}
	}

	public DeliveryBox getBox() {
		return box;
	}

}
