package ro.siit.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by andrei on 9/4/17.
 */
public class Cart {

    private Client client;
    private ArrayList<Product> productsList = new ArrayList<Product>();

    public Cart(Client client) {
        this.client = client;
    }

    public void addProduct(Product p) {
        productsList.add(p);
    }

    public Client getClient() {
        return client;
    }

    public List<Product> getProducts() {
        return productsList;
    }

    public void removeProduct(Product p) {
        productsList.remove(p);
    }
}
