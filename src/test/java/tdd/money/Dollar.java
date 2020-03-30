package tdd.money;

import java.util.Objects;

public class Dollar extends Money {
    private String currency;

    public Dollar(int amount) {
        this.amount = amount;
        currency = "USD";
    }

    public Dollar times(int mulitipier) {
        return new Dollar(amount * mulitipier);
    }

    @Override
    public String currency() {
        return currency;
    }
}
