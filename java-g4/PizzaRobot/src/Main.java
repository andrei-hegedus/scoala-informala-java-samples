
public class Main {

	public static void main(String[] args) {
		
		PizzaVendingMachine pvm = new PizzaVendingMachine();
		PizzaOffer [] offers = pvm.listPizzas();
		int orderToken = pvm.order(offers[0]);
		// wait some time
		// get hungrier
		try{
			pvm.pickUp(orderToken);
		} catch (PizzaNotReadyException e){
			e.printStackTrace();
		}
		

	}

}
