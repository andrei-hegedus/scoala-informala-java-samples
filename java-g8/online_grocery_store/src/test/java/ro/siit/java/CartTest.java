package ro.siit.java;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by andrei on 9/11/17.
 */
public class CartTest {

    @Test
    public void whenProductAddedToEmptyCart_cartContainsOnlyThatProduct(){
        // given
        Product p = new Product();
        Cart c = new Cart(new Client());
        // when
        c.addProduct(p);
        // then
        List<Product> products = c.getProducts();
        System.out.println(products.size());
        assertTrue(1 == products.size());
        assertEquals(p, products.get(0));
    }

    @Test
    public void whenRemovingProductFromOneItemCart_cartRemainsEmpty(){
        // given
        Product p = new Product();
        Cart c = new Cart(new Client());
        c.addProduct(p);
        // when
        c.removeProduct(p);
        // then
        List<Product> products = c.getProducts();
        assertTrue(0 == products.size());
    }
}
