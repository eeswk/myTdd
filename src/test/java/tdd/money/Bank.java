package tdd.money;

import java.util.Hashtable;

public class Bank {
    private Hashtable rates = new Hashtable();

    public Money reduce(Expression source, String currency) {
        return source.reduce(this, currency);
        //return source.reduce(currency);

        //return Money.dollar(10);
        //if (source instanceof Money)
        //    return (Money) source.reduce(currency);
        //Sum sum = (Sum)source;
        //int amount = sum.augend.amount + sum.addend.amount;
        //return sum.reduce(currency);
        //return new Money(amount, currency);
    }

    int rate(String from, String to) {
        //return (from.equals("CHF") && to.equals("USD")) ? 2 : 1;
        if (from.equals(to)) return 1;
        Integer rate = (Integer) rates.get(new Pair(from, to));
        return rate.intValue();
    }

    public void addRate(String from, String to, int rate) {
        rates.put(new Pair(from, to), new Integer(rate));
    }

}
