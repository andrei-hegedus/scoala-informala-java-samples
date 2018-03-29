package ro.siit.java.cursbnr;

import java.util.HashMap;
import java.util.List;

public class CurrencyConverter {

    private HashMap<Currency, BNRRate> ronConvertionRates = new HashMap<Currency, BNRRate>();

    public CurrencyConverter(List<BNRRate> rates) {
        for (BNRRate rate : rates) {
            ronConvertionRates.put(rate.getCurrency(), rate);
        }
    }

    public float convert(Currency from, Currency to, float value) {
        if (Currency.RON.equals(from)) {
            BNRRate rate = ronConvertionRates.get(to);
            return value * rate.getMultiplier() / rate.getRate();
        }
        // TODO: 3/22/18 implement rest of convertor
        return 0;
    }
}
