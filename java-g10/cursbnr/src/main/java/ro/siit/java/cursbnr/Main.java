package ro.siit.java.cursbnr;

import java.io.*;
import java.text.MessageFormat;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        //BNRRatesProvider ratesProvider = new FileBNRRates(new File("nbrfxrates.xml"));
        BNRRatesProvider ratesProvider = new CSVBNRRates(new File("bnrrates.csv"));
        List<BNRRate> rates = ratesProvider.getRates();
        CurrencyConverter cc = new CurrencyConverter(rates);
        //System.out.println(cc.convert(Currency.RON, Currency.EUR, 4660));
        //PrintStream ps = System.out;
        try (PrintStream ps = new PrintStream(new FileOutputStream("./src/main/bnrrates.csv"))) {
            for (BNRRate r : rates) {
                //ps.println(r.getCurrency().name() + "," + r.getRate() + "," + r.getMultiplier());
                System.out.println(r.getCurrency().name() + " - " + r.getRate() + " - " + r.getMultiplier());
            }
        }
        BNRRate obj = rates.get(0);
        //saveRateToFile(obj);
        BNRRate rate = readRateFromFile();
        System.out.println(rate);


        //System.out.println(MessageFormat.format("{0},{1},{2,number,#.0}\n","EUR", 4.66, 1.12));
        try (CSVCurrencyRateWriter writer = new CSVCurrencyRateWriter(new FileWriter("newRates.txt"))) {
            writer.writeRates(rates);
        }
    }

    private static BNRRate readRateFromFile() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("rate.txt"))) {
            return (BNRRate) ois.readObject();
        }
    }

    private static void saveRateToFile(BNRRate obj) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("rate.txt"))) {
            oos.writeObject(obj);
        }
    }


}
