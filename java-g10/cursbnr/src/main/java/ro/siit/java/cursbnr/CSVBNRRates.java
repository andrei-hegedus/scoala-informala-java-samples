package ro.siit.java.cursbnr;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVBNRRates implements BNRRatesProvider {
    private File file;

    public CSVBNRRates(File file) {
        this.file = file;
    }

    @Override
    public List<BNRRate> getRates() throws Exception {
        ArrayList<BNRRate> rates = new ArrayList<>();
        try (BufferedReader is = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            /*byte[] buffer = new byte[200];
            int r;
            while ((r = is.read(buffer)) != -1) {
                System.out.println(new String(buffer, "UTF-8"));
            }*/
            String line;
            while ((line = is.readLine()) != null) {
                String[] tokens = line.split(",");
                BNRRate rate = new BNRRate(Currency.valueOf(tokens[0]), Float.parseFloat(tokens[2]), Float.parseFloat(tokens[1]));
                rates.add(rate);
            }
        }
        return rates;
    }
}
