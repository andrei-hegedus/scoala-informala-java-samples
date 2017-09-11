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
        p.setName("iPhone");
        p.setPrice(699);
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
        p.setName("iPhone");
        p.setPrice(699);
        Cart c = new Cart(new Client());
        c.addProduct(p);
        // when
        c.removeProduct(p);
        // then
        List<Product> products = c.getProducts();
        assertTrue(0 == products.size());
    }

    @Test
    public void whenProductAddedSecondTimeToCart_cartContainsThatProductCount(){
        // given
        Product p = new Product();
        p.setName("iPhone");
        p.setPrice(699);

        Product p2 = new Product();
        p2.setName("iPhone");
        p2.setPrice(699);

        Cart c = new Cart(new Client());
        // when
        c.addProduct(p);
        c.addProduct(p2);
        // then
        assertEquals(2, c.getProductCount(p));

    }

    @Test
    public void whenProductAddedMultipleTimesToCart_cartContainsThatProductOnlyOnce(){
        // given
        Product p = new Product();
        p.setName("iPhone");
        p.setPrice(699);

        Product p2 = new Product();
        p2.setName("iPhone");
        p2.setPrice(699);

        Cart c = new Cart(new Client());
        // when
        c.addProduct(p);
        c.addProduct(p);
        c.addProduct(p2);
        // then
        List<Product> products = c.getProducts();
        assertEquals(1, products.size());
        assertEquals(p, products.get(0));
    }

    
    @Test
    public void whenProductRemovedFromCart_cartContainsCorrectCount(){
        // given
        Product p = new Product();
        p.setName("iPhone");
        p.setPrice(699);

        Product p2 = new Product();
        p2.setName("iPhone");
        p2.setPrice(699);

        Cart c = new Cart(new Client());
        // when
        c.addProduct(p);
        c.addProduct(p2);
        c.removeProduct(p);
        // then
        assertEquals(1, c.getProductCount(p));
    }
}
