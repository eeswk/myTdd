package tdd.money;

import java.util.Objects;

public class Dollar extends Money {

    public Dollar(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Money times(int mulitipier) {
        return Money.dollar(amount * mulitipier);
    }


}
