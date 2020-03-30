package tdd.money;

public class Franc extends Money{
    public Franc(int amount, String currency) {
        this.amount = amount;
        this.currency = "CHF";
    }

    public Franc times(int mulitipier) {
        return new Franc(amount * mulitipier, null);
    }

}
