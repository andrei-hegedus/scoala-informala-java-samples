package ro.siit.java;

/**
 * Created by andrei on 9/4/17.
 */
public class Store {

    private static int userIdCounter = 1;
    private Client [] clients;
    private Product [] products;
    private int [] stock;
    private Cart [] carts;

    public void registerClient(Client c){
        c.setUserId(getNewUserID());
    }

    private String getNewUserID(){
        return "uid_"+userIdCounter++;
    }

    public Product[] getProducts(){
        int nrOfproductsInStock = getNrOfproductsInStock();
        Product [] productsInStock = new Product[nrOfproductsInStock];
        int productsInStockIndex = 0;
        for(int i =0;i<stock.length;i++){
            if(stock[i]>0){
                productsInStock[productsInStockIndex] = products[i];
                productsInStockIndex++;
            }
        }
        return productsInStock;
    }

    private int getNrOfproductsInStock() {
        int nrOfproductsInStock = 0;
        for(int s : stock){
            if(s>0){
                nrOfproductsInStock++;
            }
        }
        return nrOfproductsInStock;
    }


    public Cart addToCart(Client client, Product product) {
        Cart cart = null;
        for(Cart c: carts){
            if(c.getClient().equals(client)){
                cart  = c;
            }
        }
        if(cart == null){
            cart = new Cart(client);
            // cart has to be added to this.carts
        }
        return null;
    }
}
