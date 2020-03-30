package tdd.money;

public class Franc extends Money{
    private int amount;

    public Franc(int amount) {
        this.amount = amount;
    }

    public Franc times(int mulitipier) {
        return new Franc(amount * mulitipier);
    }

    @Override
    public boolean equals(Object o) {
        Franc dollar = (Franc) o;
        return amount == dollar.amount;
    }
}
