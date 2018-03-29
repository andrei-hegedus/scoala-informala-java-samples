package ro.siit.java.cursbnr;

import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CSVCurrencyRateWriterTest {

    @Test
    public void transformEmptyListToCSV() throws IOException {
        // given
        ArrayList<BNRRate> rates = new ArrayList<>();
        StringWriter dest = new StringWriter();
        // when
        try (CSVCurrencyRateWriter writer = new CSVCurrencyRateWriter(dest)) {
            writer.writeRates(rates);
        }
        // then
        String result = dest.toString();
        String expected = "";
        assertEquals(expected, result);
    }

    @Test
    public void transformListWithOneElementToCSV() throws IOException {
        // given
        ArrayList<BNRRate> rates = new ArrayList<>();
        rates.add(new BNRRate(Currency.EUR, 1, 4.66f));
        StringWriter dest = new StringWriter();
        // when
        try (CSVCurrencyRateWriter writer = new CSVCurrencyRateWriter(dest)) {
            writer.writeRates(rates);
        }
        // then
        String result = dest.toString();
        String expected = "EUR,4.66,1.00\n";
        assertEquals(expected, result);
    }

    @Test
    public void transformListWithOneElement_withBelow1RateToCSV() throws IOException {
        // given
        ArrayList<BNRRate> rates = new ArrayList<>();
        rates.add(new BNRRate(Currency.BGN, 1, 0.66f));
        StringWriter dest = new StringWriter();
        // when
        try (CSVCurrencyRateWriter writer = new CSVCurrencyRateWriter(dest)) {
            writer.writeRates(rates);
        }
        // then
        String result = dest.toString();
        String expected = "BGN,0.66,1.00\n";
        assertEquals(expected, result);
    }

    @Test
    public void transformListWithMultipleElementsToCSV() throws IOException {
        // given
        ArrayList<BNRRate> rates = new ArrayList<>();
        rates.add(new BNRRate(Currency.EUR, 1, 4.66f));
        rates.add(new BNRRate(Currency.USD, 1, 3.79f));
        rates.add(new BNRRate(Currency.HUF, 100, 1.49f));
        StringWriter dest = new StringWriter();
        // when
        try (CSVCurrencyRateWriter writer = new CSVCurrencyRateWriter(dest)) {
            writer.writeRates(rates);
        }
        // then
        String result = dest.toString();
        String expected = "EUR,4.66,1.00\nUSD,3.79,1.00\nHUF,1.49,100.00\n";
        assertEquals(expected, result);
    }
}
