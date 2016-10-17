package couriers;

public class DeliveryBox {
	
	private String name;
	private String shippment;
	
	
	public DeliveryBox(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public boolean hasShippment(){
		return shippment!=null;
	}
	
	public String getShippment(){
		String toShip = shippment;
		shippment = null;
		return toShip;
	}
	
	public void addShippment(String toShip){
		shippment = toShip;
	}

}
