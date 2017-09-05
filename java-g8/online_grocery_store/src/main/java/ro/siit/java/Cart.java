package ro.siit.java;

/**
 * Created by andrei on 9/4/17.
 */
public class Cart {

    private static final int CART_SIZE_INCREMENT = 5;
    private Product[] products = new Product[CART_SIZE_INCREMENT];
    private int nrOfProductsInCart = 0;
    private Client client;

    public Cart(Client client) {
        this.client = client;
    }

    public void addProduct(Product p) {
        if (nrOfProductsInCart > 0 && nrOfProductsInCart % CART_SIZE_INCREMENT == 0) {
            expandProductsArray();
        }
        products[nrOfProductsInCart] = p;
        nrOfProductsInCart++;
    }

    private void expandProductsArray() {
        Product[] expandedArray = new Product[products.length + CART_SIZE_INCREMENT];
        for (int i = 0; i < products.length; i++) {
            expandedArray[i] = products[i];
        }
        products = expandedArray;
    }

    public Client getClient() {
        return client;
    }
}
