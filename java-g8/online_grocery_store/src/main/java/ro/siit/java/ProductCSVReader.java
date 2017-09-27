package ro.siit.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

/**
 * Using the Decorater pattern.
 * Created by andrei on 9/25/17.
 */
public class ProductCSVReader extends Reader{

    private BufferedReader reader;

    public ProductCSVReader(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return reader.read(cbuf, off, len);
    }

    public Map<Product, Integer> readProducts(){
        try {
            String line = reader.readLine();
            HashMap<Product, Integer> productsAndStock = new LinkedHashMap<>();
            while(line!=null){
                // Format of the line in the csv: name,price,stock | String,float,int
                String [] tokens = line.split(",");
                String name = tokens[0];
                float price = Float.parseFloat(tokens[1]);
                int stock = Integer.parseInt(tokens[2]);
                Product p = new Product(name, price);
                productsAndStock.put(p, stock);
                line = reader.readLine();
            }
            return productsAndStock;
        } catch (IOException e) {
            // TODO - think about error handling
            System.err.println(e.getMessage());
        }
        return Collections.emptyMap();
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }
}
