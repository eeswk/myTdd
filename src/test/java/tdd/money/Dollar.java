package tdd.money;

public class Dollar {
    public int amount;

    public Dollar(int amount) {
        this.amount = amount;
    }

    public Dollar times(int mulitipier) {
        return new Dollar(amount * mulitipier);
    }
}
