package tdd.money;

public class Franc extends Money{

    public Franc(int amount) {
        this.amount = amount;
    }

    public Franc times(int mulitipier) {
        return new Franc(amount * mulitipier);
    }

}
