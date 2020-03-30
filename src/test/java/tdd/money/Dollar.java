package tdd.money;

import java.util.Objects;

public class Dollar extends Money {

    public Dollar(int amount) {
        this.amount = amount;
    }

    public Dollar times(int mulitipier) {
        return new Dollar(amount * mulitipier);
    }


}
