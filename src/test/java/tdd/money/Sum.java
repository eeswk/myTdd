package tdd.money;

public class Sum implements Expression{
    public Money augend;
    public Money addend;

    public Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(String currency) {
        int amount = augend.amount + addend.amount;
        return new Money(amount, currency);
    }

    @Override
    public Money reduce(Bank bank, String to) {
//        int amount = augend.amount + addend.amount;
//        return new Money(amount, to);
        int amount = augend.reduce(bank, to).amount + addend.reduce(bank, to).amount;
        return new Money(amount, to);
    }
}
