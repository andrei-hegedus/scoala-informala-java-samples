package ro.siit.java.cursbnr;

import java.util.Arrays;

public class Enums {

    public static void main(String[] args) {

        System.out.println(CurrencyConst.RON.name()+", "+CurrencyConst.RON.ordinal());
        Currency currency = Currency.USD;
        System.out.println(currency.name()+", "+ currency.ordinal()+", "+ currency.getSymbol());

        Money m = new Money(15.0f, "ley");
        TypeSafeMoneyWithEnum tsmwe = new TypeSafeMoneyWithEnum(15.0f,  Currency.RON);
        TypeSafeMoney tsm = new TypeSafeMoney(15.0f, CurrencyConst.EUR);

        switch(currency){
            case EUR:
                break;
            case USD:
                break;
        }

        String val = "USD";
        //CurrencyConst cc = CurrencyConst.
        Currency c = Currency.valueOf(val);
        System.out.println(c.getSymbol());

        Currency[] values = Currency.values();
        System.out.println(Arrays.toString(values));

        System.out.println(Currency.RON.format(100));
    }

    private static class Money {
        private float amount;
        private String currency;

        public Money(float amount, String currency) {
            this.amount = amount;
            this.currency = currency;
        }
    }

    private static class TypeSafeMoney {
        private float amount;
        private CurrencyConst currency;

        public TypeSafeMoney(float amount, CurrencyConst currency) {
            this.amount = amount;
            this.currency = currency;
        }
    }

    private static class TypeSafeMoneyWithEnum {
        private float amount;
        private Currency currency;

        public TypeSafeMoneyWithEnum(float amount, Currency currency) {
            this.amount = amount;
            this.currency = currency;
        }
    }
}
