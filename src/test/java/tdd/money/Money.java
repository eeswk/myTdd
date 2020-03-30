package tdd.money;

public abstract class Money {
    protected int amount;
    protected String currency;

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
                && getClass().equals(money.getClass());
    }

    public abstract Money times(int multiplier);

    public String currency() {
        return currency;
    }
}
