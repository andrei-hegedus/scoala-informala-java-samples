package ro.siit.java;

import java.util.*;

/**
 * Created by andrei on 9/4/17.
 */
public class Store {

    private final HashSet<Client> clients = new LinkedHashSet<>();
    private final HashSet<Product> products = new LinkedHashSet<Product>();
    private final HashMap<Product, Integer> stock = new LinkedHashMap<>();
    private final HashMap<Client, Cart> shoppingCarts = new LinkedHashMap<Client, Cart>();

    public void registerClient(Client c) {
        clients.add(c);
    }

    public Set<Product> getProducts() {
        HashSet<Product> productsInStock = new HashSet<Product>();
        for (Product p : products) {
            if (stock.containsKey(p) && stock.get(p) > 0) {
                productsInStock.add(p);
            }
        }
        return productsInStock;
    }


    public void addNewProductToStore(Product p, int stock) {
        products.add(p);
        this.stock.put(p, stock);
    }

    public Cart addToCart(Client client, Product product) {
        Cart cart = shoppingCarts.get(client);
        if (cart == null) {
            cart = new Cart(client);
            shoppingCarts.put(client, cart);
        }
        cart.addProduct(product);
        return cart;
    }

    public Map<Product, Integer> getProductWithStock(Comparator<Product> sorting){
        /*TreeMap<Product, Integer> sortedProducts = new TreeMap<>(sorting);
        sortedProducts.putAll(stock);*/
        LinkedHashMap<Product, Integer> sortedProducts = new LinkedHashMap<>();
        TreeSet<Product> products = new TreeSet<>(sorting);
        products.addAll(this.products);
        for(Product p : products){
            sortedProducts.put(p, stock.get(p));
        }
        return sortedProducts;
    }
}
