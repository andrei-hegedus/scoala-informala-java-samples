
public class Order {

	private PizzaOffer pizzaOffer;
	private static int orderCount = 0;
	private int orderId;
	
	public Order(PizzaOffer pizzaOffer) {
		this.pizzaOffer = pizzaOffer;
		orderId = orderCount++;
	}

	public int getToken() {
		return orderId;
	}

	public PizzaOffer getPizzaOffer() {
		return pizzaOffer;
	}

	public boolean isReady() {
		// TODO Auto-generated method stub
		return false;
	}

}
