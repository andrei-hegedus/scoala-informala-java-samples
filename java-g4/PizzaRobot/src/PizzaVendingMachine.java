
public class PizzaVendingMachine {
	
	private Ingredient [] ingredients;
	private PizzaRecipe [] pizzaRecipes;
	private ItemPrice [] priceCatalog;
	private Order [] orders;

	public PizzaVendingMachine() {
	}
	
	public void setIngredients(Ingredient[] ingredients) {
		this.ingredients = ingredients;
	}
	
	public void setPizzaRecipes(PizzaRecipe[] pizzaRecipes) {
		this.pizzaRecipes = pizzaRecipes;
	}
	
	public void setPriceCatalog(ItemPrice[] priceCatalog) {
		this.priceCatalog = priceCatalog;
	}

	public PizzaOffer[] listPizzas() {
		PizzaOffer [] offers = new PizzaOffer[pizzaRecipes.length];
		for(int i=0;i<pizzaRecipes.length;i++){
			offers[i] = new PizzaOffer(pizzaRecipes[i], calculateCurrentPrice(pizzaRecipes[i].getIngredients(), priceCatalog));
		}
		return offers;
	}

	private float calculateCurrentPrice(Ingredient[] ingredients, ItemPrice[] priceCatalog) {
		float price = 0;
		for(Ingredient ingredient : ingredients){
			float ingredientPrice = findPrice(ingredient, priceCatalog);
			price+=ingredientPrice;
		}
		return price;
	}

	private float findPrice(Ingredient ingredient, ItemPrice[] priceCatalog) {
		for(ItemPrice price : priceCatalog){
			if(price.getItemName().equals(ingredient.getName())){
				return price.getPrice();
			}
		}
		return -1; // TODO change this with an exception.
	}

	public int order(PizzaOffer pizzaOffer) {
		Order order = new Order(pizzaOffer);
		return order.getToken();
	}

	public void pickUp(int orderToken) throws PizzaNotReadyException{
		for(Order o :orders){
			if(orderToken == o.getToken()){
				if(o.isReady()){
					System.out.println("here's your pizza: "+o.getPizzaOffer().getType());
					return;
				} else {
					throw new PizzaNotReadyException();
				}
			}
		}
	}

}
