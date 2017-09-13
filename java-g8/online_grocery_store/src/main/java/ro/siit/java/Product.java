package ro.siit.java;

import java.util.Comparator;

/**
 * Created by andrei on 9/4/17.
 */
public class Product implements Comparable<Product> {

    private String name;
    private float price;

    public static final Comparator<Product> COMPARE_BY_PRICE_ASC = new Comparator<Product>() {
        public int compare(Product o1, Product o2) {
            if(o1.price == o2.price){
                return 0;
            } else if(o1.price > o2.price){
                return 1;
            } else {
                return -1;
            }
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Float.compare(product.price, price) != 0) return false;
        return name.equals(product.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        return result;
    }

    public int compareTo(Product o) {
        return name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
