package tdd.money;

import java.util.Objects;

public class Dollar {
    private int amount;

    public Dollar(int amount) {
        this.amount = amount;
    }

    public Dollar times(int mulitipier) {
        return new Dollar(amount * mulitipier);
    }

    @Override
    public boolean equals(Object o) {
        Dollar dollar = (Dollar) o;
        return amount == dollar.amount;
        /*
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dollar dollar = (Dollar) o;
        return amount == dollar.amount;
         */
    }
}
