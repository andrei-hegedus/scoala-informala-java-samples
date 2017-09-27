package ro.siit.java;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by andrei on 9/27/17.
 */
public class ProductCSVWriter extends Writer {

    private BufferedWriter writer;

    public ProductCSVWriter(BufferedWriter writer) {
        this.writer = writer;
    }


    public void writeProduct(Product p, int stock){
        // Format of the line in the csv: name,price,stock | String,float,int
        String serializedProduct = p.getName()+","+p.getPrice()+","+stock;
        try {
            //writer.write("\n");
            writer.newLine();
            writer.write(serializedProduct);
        } catch (IOException e) {
            // TODO - think about error handling
            e.printStackTrace();
        }
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        write(cbuf, off, len);
    }

    @Override
    public void flush() throws IOException {
        writer.flush();
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }
}
