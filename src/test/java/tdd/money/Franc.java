package tdd.money;

public class Franc extends Money{
    private String currency;
    public Franc(int amount) {
        this.amount = amount;
        currency = "CHF";
    }

    public Franc times(int mulitipier) {
        return new Franc(amount * mulitipier);
    }

    @Override
    public String currency() {
        return currency;
    }
}
