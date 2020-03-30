package tdd.money;

public class Franc extends Money{
    public Franc(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Money times(int mulitipier) {
        return Money.franc(amount * mulitipier);
    }

}
