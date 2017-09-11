package ro.siit.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by andrei on 9/4/17.
 */
public class Cart {

    private Client client;
    private HashSet<Product> products = new HashSet<Product>();
    private HashMap<Product, Integer> productCount = new HashMap<Product, Integer>();

    public Cart(Client client) {
        this.client = client;
    }

    public void addProduct(Product p) {
        products.add(p);
        increaseProductCount(p);
    }

    private void increaseProductCount(Product p) {
        int count = 0;
        if (productCount.containsKey(p)) {
            count = productCount.get(p);
        }
        count++;
        productCount.put(p, count);
    }

    public Client getClient() {
        return client;
    }

    public List<Product> getProducts() {
        return new ArrayList<Product>(products);
    }

    public void removeProduct(Product p) {
        products.remove(p);
        decreaseProductCount(p);
    }

    private void decreaseProductCount(Product p) {
        if (productCount.containsKey(p)) {
            int count = productCount.get(p);
            if (count == 1) {
                productCount.remove(p);
            } else {
                count--;
                productCount.put(p, count);
            }
        }
    }

    public int getProductCount(Product p) {
        return productCount.get(p);
    }
}
