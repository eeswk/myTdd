package tdd.money;

import java.util.Objects;

public class Dollar extends Money {

    public Dollar(int amount, String currency) {
        super(amount, currency);
    }

    public Money times(int mulitipier) {
        //return Money.dollar(amount * mulitipier);
        return new Dollar(amount * mulitipier, currency);


    }


}
