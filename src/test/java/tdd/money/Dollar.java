package tdd.money;

public class Dollar {
    public int amount;

    public Dollar(int amount) {
        this.amount = amount;
    }

    public void times(int mulitipier) {
        amount *= mulitipier;
    }
}
