package ro.siit.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static org.junit.Assert.assertEquals;

/**
 * Created by andrei on 9/13/17.
 */
public class ProductSorting {

    @Test
    public void testAlphabeticalProductSorting(){
        ArrayList<Product> products = new ArrayList<Product>();
        Product p1 = new Product("Apple iPhone", 699);
        Product p2 = new Product("Samsung Washingmachine", 1300);
        Product p3 = new Product("LG Television", 150);

        products.add(p2);
        products.add(p1);
        products.add(p3);

        System.out.println(products);
        Collections.sort(products);

        ArrayList<Product> expected = new ArrayList<Product>();
        expected.add(p1);
        expected.add(p3);
        expected.add(p2);

        System.out.println(products);

        assertEquals(expected, products);

    }

    @Test
    public void testAlphabeticalProductSortingInDescendingOrder(){
        ArrayList<Product> products = new ArrayList<Product>();
        Product p1 = new Product("Apple iPhone", 699);
        Product p2 = new Product("Samsung Washingmachine", 1300);
        Product p3 = new Product("LG Television", 150);

        products.add(p2);
        products.add(p1);
        products.add(p3);

        System.out.println(products);
        Collections.sort(products, new Comparator<Product>() {
            public int compare(Product pr1, Product pr2) {
                return pr2.getName().compareTo(pr1.getName());
            }
        });

        ArrayList<Product> expected = new ArrayList<Product>();
        expected.add(p2);
        expected.add(p3);
        expected.add(p1);

        System.out.println(products);

        assertEquals(expected, products);

    }

    @Test
    public void testProductSortingByPrice(){
        ArrayList<Product> products = new ArrayList<Product>();
        Product p1 = new Product("Apple iPhone", 699);
        Product p2 = new Product("Samsung Washingmachine", 1300);
        Product p3 = new Product("LG Television", 150);

        products.add(p2);
        products.add(p1);
        products.add(p3);

        System.out.println(products);
        Collections.sort(products, Product.COMPARE_BY_PRICE_ASC);

        ArrayList<Product> expected = new ArrayList<Product>();
        expected.add(p3);
        expected.add(p1);
        expected.add(p2);

        System.out.println(products);

        assertEquals(expected, products);

    }
}
