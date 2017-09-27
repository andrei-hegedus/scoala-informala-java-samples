package ro.siit.java;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by andrei on 9/27/17.
 */
public class ProductCSVReaderTest {

    @Test
    public void testReadingWithOneProductInCSV(){
        // given
        String csvAsString = "aaaa,12.0,3";
        BufferedReader br = new BufferedReader(new StringReader(csvAsString));
        ProductCSVReader reader = new ProductCSVReader(br);

        // when
        Map<Product, Integer> productIntegerMap = reader.readProducts();

        // then
        Product expectedProduct = new Product("aaaa", 12);
        assertTrue(productIntegerMap.keySet().size()==1);
        Product actual = productIntegerMap.keySet().iterator().next();
        assertEquals(expectedProduct, actual);
        assertEquals(new Integer(3), productIntegerMap.get(actual));
    }

    @Test
    public void testReadingWithMultipleProducts(){
        // given
        String csvAsString = "a,1,3\nb,5,2\nc,3,20";
        BufferedReader br = new BufferedReader(new StringReader(csvAsString));
        ProductCSVReader reader = new ProductCSVReader(br);

        // when
        Map<Product, Integer> productIntegerMap = reader.readProducts();

        // then
        Map<Product, Integer> expected = new HashMap<>();
        expected.put(new Product("a",1), 3);
        expected.put(new Product("b",5), 2);
        expected.put(new Product("c",3), 20);
        assertEquals(expected, productIntegerMap);
    }

    @Test
    public void testReadingWithMultipleProducts_fromFile() throws FileNotFoundException {
        // given
        ProductCSVReader reader = new ProductCSVReader(new BufferedReader(new FileReader("test.csv")));

        // when
        Map<Product, Integer> productIntegerMap = reader.readProducts();

        // then
        Map<Product, Integer> expected = new HashMap<>();
        expected.put(new Product("a",1), 3);
        expected.put(new Product("b",5), 2);
        expected.put(new Product("c",3), 20);
        assertEquals(expected, productIntegerMap);
    }
}
