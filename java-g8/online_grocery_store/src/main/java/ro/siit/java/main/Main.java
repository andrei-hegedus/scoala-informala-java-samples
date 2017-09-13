package ro.siit.java.main;

import ro.siit.java.Cart;
import ro.siit.java.Client;
import ro.siit.java.Product;
import ro.siit.java.Store;

import java.util.PriorityQueue;

/**
 * Created by andrei on 9/4/17.
 */
public class Main {

    public static void main(String[] args) {
        Store store = new Store();
        Client c = new Client();
        store.registerClient(c);
        Client c2 = new Client();
        store.registerClient(c2);

        System.out.println(c.getUserId());
        System.out.println(c2.getUserId());

        Product[] products = store.getProducts();
        Cart cart = store.addToCart(c, products[1]);



    }
}
