package ro.siit.java.main;

import ro.siit.java.*;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

/**
 * Created by andrei on 9/4/17.
 */
public class Main {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Store store = new Store();

        Client c = new Client();
        store.registerClient(c);

        store.addNewProductToStore(new Product("iPhone", 599), 5);
        store.addNewProductToStore(new Product("iPad", 899), 2);
        store.addNewProductToStore(new Product("Nexus 5", 299), 20);

        Map<Product, Integer> productWithStock = store.getProductWithStock(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getPrice() >= o2.getPrice() ? 1 : -1;
            }
        });
        //System.out.println(productWithStock);

        ArrayList<Product> products = new ArrayList<Product>(store.getProducts());
        Cart cart = store.addToCart(c, products.get(0));

        /*File file = new File("product.obj");
        if(!file.exists()) {
            file.createNewFile();
        }*/

        //writeObject(new FileOutputStream(file));
        //readObject(new FileInputStream(file));



        //readWithReaders();
        //readFromStream();
        // TODO - check 1.8 compatibility
        //List<String> strings = Files.readAllLines(new File("in.txt").toPath());
        ProductCSVReader productReader = new ProductCSVReader(new BufferedReader(new FileReader("products.csv")));
        Map<Product, Integer> productIntegerMap = productReader.readProducts();
        for(Product p : productIntegerMap.keySet()){
            System.out.println(p.toString()+" - "+productIntegerMap.get(p));
        }
        productReader.close();

        Product newP = new Product("Zanussi WashingMachine", 200);
        //ProductCSVWriter productCSVWriter = new ProductCSVWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        ProductCSVWriter productCSVWriter = new ProductCSVWriter(new BufferedWriter(new FileWriter("products.csv", true)));
        //productCSVWriter.writeProduct(newP, 3);
        productCSVWriter.flush();
        productCSVWriter.close();

    }

    private static void readObject(InputStream source) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(source);
        Product p = (Product) ois.readObject();
        System.out.println(p);
    }

    private static void writeObject(OutputStream dest) throws IOException {
        Product iphone = new Product("iPhone", 599);
        ObjectOutputStream oos = new ObjectOutputStream(dest);
        oos.writeObject(iphone);
        oos.flush();
        oos.close();
    }

    private static void readWithReaders() {
        //BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream("in.txt")));
        //BufferedReader r = new BufferedReader(new FileReader("in.txt"));
        //BufferedReader r = new BufferedReader(new InputStreamReader(new ByteArrayInputStream("Ana are banane.".getBytes("UTF-8"))));
        //System.out.println(r.readLine());
    }

    private static void readFromStream() {
        try (FileInputStream fis = new FileInputStream("in.txt")) {
            byte buffer[] = new byte[10];
            int read = fis.read(buffer);
            while(read != -1) {
                System.out.println("read nr of chars: " + read);
                System.out.println(Arrays.toString(buffer));
                String x = new String(buffer, 0, read, "UTF-8");
                System.out.println(x);
                //System.out.println(Arrays.toString(x.getBytes("UTF-8")));
                read = fis.read(buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
