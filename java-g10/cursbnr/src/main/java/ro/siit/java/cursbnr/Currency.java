package ro.siit.java.cursbnr;

public enum Currency {

    EUR , AED, AUD, BGN, BRL, CAD, CHF, CNY, CZK, DKK, EGP, GBP, HRK, HUF, INR, JPY, KRW, MDL, MXN, NOK, NZD, PLN, RSD,
    RUB, SEK, THB, TRY, UAH, USD("$") {
        @Override
        public String format(float amount) {
            return getSymbol()+amount;
        }
    }, XAU, XDR, ZAR, RON;

    private String symbol;

    Currency(String symbol) {
        this.symbol = symbol;
    }

    Currency() {
        this.symbol = this.name();
    }

    public String getSymbol() {
        return symbol;
    }

    public String format(float amount) {
        return amount+" "+getSymbol();
    }
}
