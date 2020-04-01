package tdd.money;

public class Franc extends Money{
    public Franc(int amount, String currency) {
        super(amount, currency);
    }

    public Money times(int mulitipier) {
        //return Money.franc(amount * mulitipier);
        return new Money(amount * mulitipier, currency);
    }

}
