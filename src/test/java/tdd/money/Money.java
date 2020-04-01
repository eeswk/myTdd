package tdd.money;

public class Money {
    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money dollar(int amount) {
        return new Dollar(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Franc(amount, "CHF");
    }


    @Override
    public boolean equals(Object o) {
        Money money = (Money) o;
        return amount == money.amount
                //&& getClass().equals(money.getClass());
                && currency().equals(money.currency());
    }

    //public abstract Money times(int multiplier);
    public Money times(int mulitplier) {
        return null;
    }

    public String currency() {
        return currency;
    }

    public String toString() {
        return amount + "  " + currency;
    }
}
