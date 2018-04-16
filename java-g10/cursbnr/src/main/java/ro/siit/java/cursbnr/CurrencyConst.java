package ro.siit.java.cursbnr;

// just to compare to enums
public class CurrencyConst {

    public static final CurrencyConst EUR = new CurrencyConst("EUR");
    public static final CurrencyConst RON = new CurrencyConst("RON");
    public static final CurrencyConst USD = new CurrencyConst("USD");

    private static int counter = 0;

    private String name;
    private int ordinal;

    private CurrencyConst(String name) {
        this.name = name;
        this.ordinal = counter++;
    }

    public String name() {
        return name;
    }

    public int ordinal() {
        return ordinal;
    }
}
