package tdd.money;

public class Bank {
    public Money reduce(Expression source, String currency) {
        //return Money.dollar(10);
        Sum sum = (Sum)source;
        //int amount = sum.augend.amount + sum.addend.amount;
        return sum.reduce(currency);
        //return new Money(amount, currency);
    }
}
