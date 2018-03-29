package ro.siit.java.cursbnr;

import java.io.Serializable;
import java.util.Objects;

/**
 * Currency rate relative to 1 RON
 */
public class BNRRate implements Serializable {

    private Currency currency;
    private float multiplier = 1;
    private float rate;

    public BNRRate(Currency currency, float multiplier, float rate) {
        this.currency = currency;
        this.multiplier = multiplier;
        this.rate = rate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public float getMultiplier() {
        return multiplier;
    }

    public float getRate() {
        return rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BNRRate bnrRate = (BNRRate) o;
        return Float.compare(bnrRate.multiplier, multiplier) == 0 &&
                Float.compare(bnrRate.rate, rate) == 0 &&
                currency == bnrRate.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, multiplier, rate);
    }

    @Override
    public String toString() {
        return "BNRRate{" +
                "currency=" + currency +
                ", multiplier=" + multiplier +
                ", rate=" + rate +
                '}';
    }
}
