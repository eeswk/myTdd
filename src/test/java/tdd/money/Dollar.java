package tdd.money;

import java.util.Objects;

public class Dollar extends Money {

    public Dollar(int amount, String currency) {
        this.amount = amount;
        this.currency = "USD";
    }

    public Dollar times(int mulitipier) {
        return new Dollar(amount * mulitipier, null);
    }


}
