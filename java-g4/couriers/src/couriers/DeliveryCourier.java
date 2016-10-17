package couriers;

public class DeliveryCourier extends Thread {

	private String name;
	private DeliveryBox box;

	public DeliveryCourier(String name) {
		this.name = name;
		this.box = new DeliveryBox(name+" box");
	}

	@Override
	public void run() {
		
	}

	public DeliveryBox getBox() {
		return box;
	}

}
